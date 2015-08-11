package br.edu.ufcg.reuml.metrics.sequenceprofile;

import br.edu.ufcg.reuml.metrics.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 12/05/15.
 */
public class NL implements Measurable {

    public static final String NAME = "Number of Lifelines";
    private static final String XPATH_QUERY = "count(//lifeline[@*=\"uml:Lifeline\"])";

    public static final double SMALL_NUM_LIFELINES = 3.0;
    public static final double MEDIUM_NUM_LIFELINES = 8.0;

    public static final double SMALL_VALUE = 1.0;
    public static final double MEDIUM_VALUE = 2.0;
    public static final double LARGE_VALUE = 3.0;

    public NL() {
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

        if (count <= SMALL_NUM_LIFELINES) {
            return SMALL_VALUE;
        } else if (count <= MEDIUM_NUM_LIFELINES) {
            return MEDIUM_VALUE;
        } else {
            return LARGE_VALUE;
        }
        //return count;
    }
}
