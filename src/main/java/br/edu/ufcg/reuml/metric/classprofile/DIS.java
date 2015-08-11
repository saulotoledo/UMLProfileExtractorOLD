package br.edu.ufcg.reuml.metric.classprofile;

import br.edu.ufcg.reuml.metric.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 27/03/15.
 */
public class DIS implements Measurable {

    public static final String NAME = "Diagram's Size";

    public static final double SMALL_NUM_CLASSES = 5.0;
    public static final double MEDIUM_NUM_CLASSES = 20.0;

    public static final double SMALL_VALUE = 1.0;
    public static final double MEDIUM_VALUE = 2.0;
    public static final double LARGE_VALUE = 3.0;

    private static final String XPATH_QUERY = "count(//packagedElement[@*=\"uml:Class\"])";

    public DIS() {
    }

    public double measureMetric(Document document) {
        double count = 0;

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expression = xpath.compile(XPATH_QUERY);
            count = (Double) expression.evaluate(document, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        if (count <= SMALL_NUM_CLASSES) {
            return SMALL_VALUE;
        } else if (count <= MEDIUM_NUM_CLASSES) {
            return MEDIUM_VALUE;
        } else {
            return LARGE_VALUE;
        }
    }
}
