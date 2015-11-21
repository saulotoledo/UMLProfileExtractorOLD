package br.edu.ufcg.splab.reuml.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import br.edu.ufcg.splab.reuml.feature.Measurable;
import br.edu.ufcg.splab.reuml.profile.ClassDiagramProfile;
import br.edu.ufcg.splab.reuml.profile.SequenceDiagramProfile;
import br.edu.ufcg.splab.reuml.profile.UMLProfile;

/**
 * Service to generate, save and get UML Profiles from XMI Documents.
 * Created by gustavo on 11/08/15.
 */
public class UMLProfileService {


    private String metricsPackage;// = "br.edu.ufcg.splab.reuml.feature.";

    public UMLProfileService(String metricsPackage) {
        this.metricsPackage = metricsPackage + ".";
    }

    /**
     * Generate a Class Diagram Profile from a XMI Document.
     * @param filepath Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile getClassDiagramProfile(String filepath) {
        return this.getClassDiagramProfile(this.filepathToDocument(filepath));
    }

    /**
     * Generate a Class Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public ClassDiagramProfile getClassDiagramProfile(Document doc) {
        return this.getUMLProfile(ClassDiagramProfile.class, doc);
    }

    /**
     * Generate a Sequence Diagram Profile from a XMI Document.
     * @param filepath Directory of the XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile getSequenceDiagramProfile(String filepath) {
        return this.getSequenceDiagramProfile(this.filepathToDocument(filepath));
    }

    /**
     * Generate a sequence Diagram Profile from a XMI Document.
     * @param doc XMI Document.
     * @return Class Diagram Profile Generated.
     */
    public SequenceDiagramProfile getSequenceDiagramProfile(Document doc) {
        return this.getUMLProfile(SequenceDiagramProfile.class, doc);
    }

    /**
     * Get the XML Document from a directory.
     * @param filepath Directory of the XML Document
     * @return XML Document Object
     */
    private Document filepathToDocument(String filepath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;

        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(filepath);
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
        List<Measurable> metricList = new ArrayList<Measurable>();
        for (Field field : fields) {
            Class metricClass = null;

            try {
                metricClass = Class.forName(this.metricsPackage + type + field.getName());
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
