package br.edu.ufcg.reuml.dao;

import br.edu.ufcg.reuml.diagrams.UMLDiagram;

/**
 * Created by gustavo on 11/08/15.
 */
public class UMLDiagramDAO extends AbstractDAO<Long, UMLDiagram>{


    public UMLDiagram findById(Long id) {
        return getByKey(id);
    }

    public void save(UMLDiagram profile) {
        persist(profile);
    }
}
