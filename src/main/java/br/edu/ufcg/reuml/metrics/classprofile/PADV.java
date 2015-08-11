package br.edu.ufcg.reuml.metrics.classprofile;

import br.edu.ufcg.reuml.metrics.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 17/04/15.
 */
public class PADV implements Measurable {

    public static final String NAME = "Presence of Attributes with Default Values";

    private static final String XPATH_QUERY =
            "count(" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue  | " +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue" +
            ")";

    public PADV() {
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
        //return (count > 0.0) ? 1.0 : 0.0;
    }
}
