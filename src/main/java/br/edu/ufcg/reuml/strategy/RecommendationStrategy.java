package br.edu.ufcg.reuml.strategy;

import br.edu.ufcg.reuml.diagram.UMLDiagram;
import br.edu.ufcg.reuml.profile.UMLProfile;

import java.util.List;

/**
 * Created by gustavo on 26/03/15.
 */
public interface RecommendationStrategy {

    List<UMLDiagram> getRecommendedNItemsBy(List<UMLDiagram> diagrams, UMLProfile profile, int numberOfItens);
}
