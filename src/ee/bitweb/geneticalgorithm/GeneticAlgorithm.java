package ee.bitweb.geneticalgorithm;

import ee.bitweb.geneticalgorithm.fitness.FitnessFunction;
import ee.bitweb.geneticalgorithm.selection.SelectionFunction;
import ee.bitweb.geneticalgorithm.solution.SolutionFunction;

/**
 * Created by tobre on 18/07/2017.
 */
public class GeneticAlgorithm {

    private Population population;
    private SolutionFunction solutionFunction;

    public GeneticAlgorithm(Integer populationSize, FitnessFunction fitnessFunction, SolutionFunction solutionFunction, SelectionFunction selectionFunction) {
        fitnessFunction.setSolutionFunction(solutionFunction);
        population = new Population(populationSize, fitnessFunction, selectionFunction);
        population.generateIndividuals();
        selectionFunction.setPopulation(population);
        this.solutionFunction = solutionFunction;
    }

    public Integer run() {
        int generationCount = 1;
        while (population.getFittest().getFitness() < solutionFunction.getMaxFitness()) {
            population = population.evolve();
            generationCount++;
        }

        return generationCount;
    }
}
