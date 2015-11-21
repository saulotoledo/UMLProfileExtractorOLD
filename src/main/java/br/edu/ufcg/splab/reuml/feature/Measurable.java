package br.edu.ufcg.splab.reuml.feature;

import org.w3c.dom.Document;

/**
 * Interface to be implemented by all features.
 * Created by gustavo on 27/03/15.
 */
public interface Measurable {

    double measureMetric(Document document);
}
