package br.edu.ufcg.reuml.dao;

import br.edu.ufcg.reuml.profiles.ClassDiagramProfile;

/**
 * Created by gustavo on 11/08/15.
 */
public class ClassDiagramProfileDAO extends AbstractDAO<Long, ClassDiagramProfile>{


    public ClassDiagramProfile findById(Long id) {
        return getByKey(id);
    }

    public void save(ClassDiagramProfile profile) {
        persist(profile);
    }
}
