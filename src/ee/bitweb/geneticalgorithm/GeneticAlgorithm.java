package ee.bitweb.geneticalgorithm;

import ee.bitweb.geneticalgorithm.fitness.FitnessFunction;
import ee.bitweb.geneticalgorithm.selection.SelectionFunction;

/**
 * Created by tobre on 18/07/2017.
 */
public class GeneticAlgorithm {

    private Population population;

    public GeneticAlgorithm(Integer populationSize, FitnessFunction fitnessFunction, SelectionFunction selectionFunction) {
        population = new Population(populationSize, fitnessFunction, selectionFunction);
        selectionFunction.setPopulation(population);
    }

    public Integer run() {
        int generationCount = 1;
        while (population.getFittest().getFitness() < population.getFitnessFunction().getMaxFitness()) {
            population = population.evolve();
            generationCount++;
        }

        return generationCount;
    }

    public Population getPopulation() {
        return population;
    }

    public Population evolve() {
        population = population.evolve();

        return population;
    }

    public Boolean solutionFound() {
        return population.getFittest().getFitness() < population.getFitnessFunction().getMaxFitness();
    }
}
