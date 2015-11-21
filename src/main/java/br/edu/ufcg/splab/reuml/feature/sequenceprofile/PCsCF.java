package br.edu.ufcg.splab.reuml.feature.sequenceprofile;

import br.edu.ufcg.splab.reuml.feature.Measurable;

import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 13/05/15.
 */
public class PCsCF implements Measurable {

    public static final String NAME = "Presence of combined fragments of type consider";
    private static final String XPATH_QUERY = "count(//fragment[@*=\"uml:ConsiderIgnoreFragment\"][@interactionOperator=\"consider\"])";

    public PCsCF() {
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
