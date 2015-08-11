package br.edu.ufcg.reuml.dao;

import br.edu.ufcg.reuml.profile.UMLProfile;

/**
 * Created by gustavo on 11/08/15.
 */
public class UMLProfileDAO extends AbstractDAO<Long, UMLProfile>{


    public UMLProfile findById(Long id) {
        return getByKey(id);
    }

    public void save(UMLProfile profile) {
        persist(profile);
    }
}