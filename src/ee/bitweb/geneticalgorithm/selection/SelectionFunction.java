package ee.bitweb.geneticalgorithm.selection;

import ee.bitweb.geneticalgorithm.Individual;
import ee.bitweb.geneticalgorithm.Population;

import java.util.List;

/**
 * Created by tobre on 19/07/2017.
 */
public interface SelectionFunction {

    public void setPopulation(Population population);
    public Individual selectParent();
}
