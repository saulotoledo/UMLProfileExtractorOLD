package br.edu.ufcg.reuml.metric.classprofile;

import br.edu.ufcg.reuml.metric.Measurable;
import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 17/04/15.
 */
public class PTC implements Measurable {

    public static final String NAME = "Presence of Template Classes";
    private static final String XPATH_QUERY = "count(//packagedElement[@*=\"uml:Class\"]/ownedTemplateSignature)";

    public PTC() {
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