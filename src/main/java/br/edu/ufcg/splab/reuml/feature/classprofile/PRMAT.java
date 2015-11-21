package br.edu.ufcg.splab.reuml.feature.classprofile;

import br.edu.ufcg.splab.reuml.feature.Measurable;

import org.w3c.dom.*;

import javax.xml.xpath.*;

/**
 * Created by gustavo on 22/04/15.
 */
public class PRMAT implements Measurable {

    public static final String NAME = "Presence of Range Multiplicities for Attributes";

    private static final String XPATH_QUERY_CLASSES = "//packagedElement[@*=\"uml:Class\"]";
    private static final String OWNED_ATTRIBUTE = "ownedAttribute";
    private static final String UPPER_VALUE = "upperValue";
    private static final String LOWER_VALUE = "lowerValue";


    public PRMAT() {
    }

    public double measureMetric(Document document) {
        double multiplicities = 0;

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        NodeList classes = null;

        try {
            XPathExpression expression = xpath.compile(XPATH_QUERY_CLASSES);
            classes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < classes.getLength(); i++) {
            Node clazz = classes.item(i);
            NodeList attributes = clazz.getChildNodes();

            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);

                if (attribute.getNodeName().equals(OWNED_ATTRIBUTE)) {
                    NodeList values = attribute.getChildNodes();

                    String upperValue = null;
                    String lowerValue = null;

                    for (int k = 0; k < values.getLength(); k++) {
                        Node value = values.item(k);

                        if (value.getNodeName().equals(UPPER_VALUE)) {
                            upperValue = value.getAttributes().getNamedItem("value").getNodeValue();
                        }

                        if (value.getNodeName().equals(LOWER_VALUE)) {
                            lowerValue = value.getAttributes().getNamedItem("value").getNodeValue();
                        }
                    }

                    if (upperValue != null && lowerValue != null) {
                        if (upperValue != lowerValue) {
                            multiplicities++;
                        }
                    }

                }
            }
        }

        return multiplicities;

        //Para retornar so 0 ou 1 usar o seguinte:
        //return (multiplicities > 0.0) ? 1.0 : 0.0;
    }
}
