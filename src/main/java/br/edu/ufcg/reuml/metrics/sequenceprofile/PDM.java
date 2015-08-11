package br.edu.ufcg.reuml.metrics.sequenceprofile;

import br.edu.ufcg.reuml.metrics.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 12/05/15.
 */
public class PDM implements Measurable {

    public static final String NAME = "Presence of deletion message";
    private static final String XPATH_QUERY = "count(//message[@*=\"uml:Message\"][@messageSort=\"deleteMessage\"])";

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
        //return (count > 0.0) ? 1.0 : 0.0;
    }
}
