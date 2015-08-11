package br.edu.ufcg.reuml.metrics;

import org.w3c.dom.Document;

/**
 * Interface to be implemented by all metrics.
 * Created by gustavo on 27/03/15.
 */
public interface Measurable {

    double measureMetric(Document document);
}
