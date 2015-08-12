package br.edu.ufcg.reuml.service;

import br.edu.ufcg.reuml.dao.UMLDiagramDAO;
import br.edu.ufcg.reuml.diagram.*;
import br.edu.ufcg.reuml.profile.*;
import org.w3c.dom.Document;

/**
 * Service to generate, save and get UMLDiagrams.
 * Created by gustavo on 11/08/15.
 */
public class UMLDiagramService {
    private UMLDiagramDAO dao;
    private UMLProfileService service;

    public UMLDiagramService() {
        this.dao = new UMLDiagramDAO();
        this.service = new UMLProfileService();
    }

    public UMLDiagram findById(Long id) {
        return dao.findById(id);
    }

    public ClassDiagram createClassDiagram(String name, ClassDiagramProfile profile) {
        ClassDiagram diagram = new ClassDiagram(name, profile);
        dao.save(diagram);
        return diagram;
    }

    public ClassDiagram createClassDiagram(String name, Document doc) {
        ClassDiagramProfile profile = service.getClassDiagramProfile(doc);
        ClassDiagram diagram = new ClassDiagram(name, profile);
        dao.save(diagram);
        return diagram;
    }

    public SequenceDiagram createSequenceDiagram(String name, SequenceDiagramProfile profile) {
        SequenceDiagram diagram = new SequenceDiagram(name, profile);
        dao.save(diagram);
        return diagram;
    }

    public SequenceDiagram createSequenceDiagram(String name, Document doc) {
        SequenceDiagramProfile profile = service.getSequenceDiagramProfile(doc);
        SequenceDiagram diagram = new SequenceDiagram(name, profile);
        dao.save(diagram);
        return diagram;
    }
}
