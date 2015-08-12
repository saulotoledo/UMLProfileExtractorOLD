package br.edu.ufcg.reuml.strategy;

import br.edu.ufcg.reuml.diagram.UMLDiagram;
import br.edu.ufcg.reuml.profile.UMLProfile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by gustavo on 11/08/15.
 */
public class CosineSimilarity implements RecommendationStrategy {

    public CosineSimilarity() {
    }

    @Override
    public List<UMLDiagram> getRecommendedNItemsBy(List<UMLDiagram> diagrams, UMLProfile profile, int numberOfItens) {
        return null;
    }

    private double calculateSimilarity(UMLProfile profile1, UMLProfile profile2) {
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;

        List<Double> list1 = getMetricValues(profile1);
        List<Double> list2 = getMetricValues(profile2);

        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            sum1 += list1.get(i) * list2.get(i);
            sum2 += Math.pow(list1.get(i), 2);
            sum3 += Math.pow(list2.get(i), 2);
        }

        if (sum2 == 0 || sum3 == 0) {
            return 0;
        } else {
            return sum1 / (Math.sqrt(sum2) * Math.sqrt(sum3));
        }
    }

    /**
     * Auxiliar method to transform the profile class in a list with the values of the attributes.
     * @param profile Profile
     * @return List with values of the attributes of the profile.
     */
    private List<Double> getMetricValues(UMLProfile profile) {
        Class clazz = profile.getClass();

        List<Double> metricValues = new ArrayList<>();
        Field[] fields = profile.getClass().getDeclaredFields();

        for (Field field : fields) {
            //Aqui se pode botar um if vendo se o atributo tem tal annotation
            String getterName = "get" + field.getName();
            Method getter = null;

            try {
                 getter = clazz.getDeclaredMethod(getterName);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            Double value = 0.0;
            try {
                value = (Double) getter.invoke(profile);
            } catch (Exception e) {
                e.printStackTrace();
            }

            metricValues.add(value);
        }

        return metricValues;
    }
}
