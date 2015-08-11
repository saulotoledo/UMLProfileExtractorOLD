package br.edu.ufcg.reuml.metric.classprofile;

import br.edu.ufcg.reuml.metric.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 17/04/15.
 */
public class PRI implements Measurable {

    public static final String NAME = "Presence of Realized Interfaces";
    private static final String XPATH_QUERY_CHECK = "count(//packagedElement[@*=\"uml:Interface\"])";
    private static final String XPATH_QUERY = "count(//interfaceRealization)";

    public PRI() {
    }

    public double measureMetric(Document document) {
        double count = 0;
        double count_interfaces = 0;

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        try {
            XPathExpression expression = xpath.compile(XPATH_QUERY_CHECK);
            count_interfaces = (Double) expression.evaluate(document, XPathConstants.NUMBER);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        if (count_interfaces > 0.0) {
            try {
                XPathExpression expression = xpath.compile(XPATH_QUERY);
                count = (Double) expression.evaluate(document, XPathConstants.NUMBER);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
        }

        return count;

        //Para retornar so 0 ou 1 usar o seguinte:
        //return (count > 0.0) ? 1.0 : 0.0;
    }
}
