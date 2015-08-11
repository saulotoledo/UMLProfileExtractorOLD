package br.edu.ufcg.reuml.metric.sequenceprofile;

import br.edu.ufcg.reuml.metric.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 12/05/15.
 */
public class PRM implements Measurable {

    public static final String NAME = "Presence of return messages";
    private static final String XPATH_QUERY = "count(//message[@*=\"uml:Message\"][@messageSort=\"reply\"])";

    public PRM() {
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

        return count;

        //Para retornar so 0 ou 1 usar o seguinte:
    }
}
