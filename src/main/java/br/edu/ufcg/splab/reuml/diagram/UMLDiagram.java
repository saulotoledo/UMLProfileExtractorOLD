package br.edu.ufcg.splab.reuml.diagram;

import br.edu.ufcg.splab.reuml.profile.UMLProfile;

/**
 * An generic UML Diagram.
 * Created by gustavo on 26/03/15.
 */
public abstract class UMLDiagram {

    private UMLProfile profile;

    private String name;

    public UMLDiagram() {
    }

    public UMLDiagram(String name, UMLProfile profile) {
        this.name = name;
        this.profile = profile;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UMLProfile getProfile() {
        return this.profile;
    }

    public void setProfile(UMLProfile profile) {
        this.profile = profile;
    }
}
