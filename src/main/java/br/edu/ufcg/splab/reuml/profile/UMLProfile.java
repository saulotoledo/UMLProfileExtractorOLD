package br.edu.ufcg.splab.reuml.profile;

/**
 * An generic UML Profile.
 * Created by gustavo on 26/03/15.
 */
public abstract class UMLProfile {

    private long id;

    public UMLProfile() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
