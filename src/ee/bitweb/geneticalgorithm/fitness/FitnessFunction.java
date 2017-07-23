package ee.bitweb.geneticalgorithm.fitness;

import ee.bitweb.geneticalgorithm.Individual;
import ee.bitweb.geneticalgorithm.solution.SolutionFunction;

/**
 * Created by tobre on 18/07/2017.
 */
public interface FitnessFunction<T> {

    T getFitness(Individual individual);

    void setSolutionFunction(SolutionFunction solutonFunction);
}
