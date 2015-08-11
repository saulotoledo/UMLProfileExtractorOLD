package br.edu.ufcg.reuml.diagram;

import br.edu.ufcg.reuml.profile.UMLProfile;
import javax.persistence.*;

/**
 * An generic UML Diagram.
 * Created by gustavo on 26/03/15.
 */
@Entity
public abstract class UMLDiagram {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn
    private UMLProfile profile;

    @Column
    private String name;

    public UMLDiagram() {
    }

    public UMLDiagram(String name, UMLProfile profile) {
        this.name = name;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UMLProfile getProfile() {
        return profile;
    }

    public void setProfile(UMLProfile profile) {
        this.profile = profile;
    }
}