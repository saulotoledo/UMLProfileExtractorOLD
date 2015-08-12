package br.edu.ufcg.reuml.service;

import br.edu.ufcg.reuml.dao.UMLProfileDAO;
import br.edu.ufcg.reuml.metric.Measurable;
import br.edu.ufcg.reuml.profile.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service to generate, save and get UML Profiles from XMI Documents.
 * Created by gustavo on 11/08/15.
 */
public class UMLProfileService {
    private UMLProfileDAO dao;
    private static final String METRICS_PACKAGE = "br.edu.ufcg.reuml.metric.";

    public UMLProfileService() {
        dao = new UMLProfileDAO();
    }

    public UMLProfile findById(Long id) {
        return dao.findById(id);
    }

    /**
     * Generate a Class Diagram Profile from a XMI Document.
     * @param dir Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile getClassDiagramProfile(String dir) {
        return getUMLProfile(ClassDiagramProfile.class, dirToDocument(dir));
    }

    /**
     * Generate a Class Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile getClassDiagramProfile(Document doc) {
        return getUMLProfile(ClassDiagramProfile.class, doc);
    }

    /**
     * Generate and save a Class Diagram Profile from a XMI Document.
     * @param dir Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile createClassDiagramProfile(String dir) {
        ClassDiagramProfile profile = getClassDiagramProfile(dir);
        dao.save(profile);
        return profile;
    }

    /**
     * Generate and save a Class Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile createClassDiagramProfile(Document doc) {
        ClassDiagramProfile profile = getClassDiagramProfile(doc);
        dao.save(profile);
        return profile;
    }

    /**
     * Generate a Sequence Diagram Profile from a XMI Document.
     * @param dir Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile getSequenceDiagramProfile(String dir) {
        return getUMLProfile(SequenceDiagramProfile.class, dirToDocument(dir));
    }

    /**
     * Generate a sequence Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile getSequenceDiagramProfile(Document doc) {
        return getUMLProfile(SequenceDiagramProfile.class, doc);
    }

    /**
     * Generate and save a Sequence Diagram Profile from a XMI Document.
     * @param dir Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile createSequenceDiagramProfile(String dir) {
        SequenceDiagramProfile profile = getSequenceDiagramProfile(dir);
        dao.save(profile);
        return profile;
    }

    /**
     * Generate and save sequence Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile createSequenceDiagramProfile(Document doc) {
        SequenceDiagramProfile profile = getSequenceDiagramProfile(doc);
        dao.save(profile);
        return profile;
    }

    /**
     * Get the XML Document from a directory.
     * @param dir Directory of the XML Document
     * @return XML Document Object
     */
    private Document dirToDocument(String dir) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doc;
    }

    /**
     * Generic method to generate UML Profiles from a XMI Document.
     * @param clazz Class of the UML Profile
     * @param doc XMI Document
     * @return UML Profile object built with the XMI Document
     */
    private <T extends UMLProfile> T getUMLProfile(Class<T> clazz, Document doc) {

        T profile = null;
        String type = clazz.getSimpleName().replaceAll("DiagramProfile","").toLowerCase() + "profile.";

        try {
            profile = clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //get the class attributes(or fields)
        Field[] fields = clazz.getDeclaredFields();
        //helper list
        List<Measurable> metricList = new ArrayList<>();
        for (Field field : fields) {
            Class metricClass = null;

            try {
                metricClass = Class.forName(METRICS_PACKAGE + type + field.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                //here we need to throw some exception
                //because if there is a ClassNotFound, our pattern isn't been
                //used the right way
            }

            Constructor constructor = null;
            try {
                constructor = metricClass.getDeclaredConstructor();
            } catch (Exception e) {
                e.printStackTrace();
                //same here
            }

            Measurable measurable = null;

            try {
                measurable = (Measurable) constructor.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                //and here
            }

            if (measurable != null) {
                metricList.add(measurable);
            }
        }

        for (Measurable metric : metricList) {
            String setterName = "set" + metric.getClass().getSimpleName();
            Method setter = null;
            try {
                setter = clazz.getDeclaredMethod(setterName, double.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                //Same thing
            }

            double value = metric.measureMetric(doc);

            try {
                setter.invoke(profile, value);
            } catch (Exception e) {
                e.printStackTrace();
                //here too
            }
        }

        return profile;
    }
}
