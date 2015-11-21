package br.edu.ufcg.splab.reuml.feature.classprofile;

import br.edu.ufcg.splab.reuml.feature.Measurable;

import org.w3c.dom.Document;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 17/04/15.
 */
public class PATPS implements Measurable {

    public static final String NAME = "Presence of Attributes with Property Strings";
    private static final String XPATH_QUERY =
            "count(" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@isOrdered=\"true\"]          |" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@isReadOnly=\"true\"]         |" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@isDerivedUnion=\"true\"]     |" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@isUnique=\"false\"]          |" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@redefinedProperty]           |" +
            "      //packagedElement[@*=\"uml:Class\"]/ownedAttribute/defaultValue[@subsettedProperty]           |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@isOrdered=\"true\"]      |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@isReadOnly=\"true\"]     |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@isDerivedUnion=\"true\"] |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@isUnique=\"false\"]      |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@redefinedProperty]       |" +
            "      //packagedElement[@*=\"uml:Interface\"]/ownedAttribute/defaultValue[@subsettedProperty]" +
            ")";

    public PATPS() {
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
