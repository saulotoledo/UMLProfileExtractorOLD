package br.edu.ufcg.reuml.profiles;

import javax.persistence.*;

/**
 * An generic UML Profile.
 * Created by gustavo on 26/03/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UMLProfile {
    @Id
    @GeneratedValue
    private long id;

    public UMLProfile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
