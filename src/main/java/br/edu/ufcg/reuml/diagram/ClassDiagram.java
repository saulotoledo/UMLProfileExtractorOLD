package br.edu.ufcg.reuml.diagram;

import br.edu.ufcg.reuml.profile.ClassDiagramProfile;
import javax.persistence.Entity;

/**
 * Created by gustavo on 28/03/15.
 */
@Entity
public class ClassDiagram extends UMLDiagram {

    public ClassDiagram() {
        super();
    }

    public ClassDiagram(String name, ClassDiagramProfile profile) {
        super(name, profile);
    }
}
