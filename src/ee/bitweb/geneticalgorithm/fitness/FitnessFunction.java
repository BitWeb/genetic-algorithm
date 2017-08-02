package ee.bitweb.geneticalgorithm.fitness;

import ee.bitweb.geneticalgorithm.Individual;

/**
 * Created by tobre on 18/07/2017.
 */
public interface FitnessFunction<T> {

    T getFitness(Individual individual);

    public Integer getMaxFitness();
}
