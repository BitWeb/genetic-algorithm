package ee.bitweb.geneticalgorithm.fitness;

import ee.bitweb.geneticalgorithm.Gene;
import ee.bitweb.geneticalgorithm.Individual;
import ee.bitweb.geneticalgorithm.solution.SolutionFunction;

/**
 * Created by tobre on 18/07/2017.
 */
public class BinaryFitnessFunction implements FitnessFunction<Integer> {

    private SolutionFunction solutionFunction;

    @Override
    public void setSolutionFunction(SolutionFunction solutonFunction) {
        this.solutionFunction = solutonFunction;
    }

    @Override
    public Integer getFitness(Individual individual) {
        int fitness = 0;
        for (Gene gene : individual.getGenes()) {
            for (int i = 0; i < gene.getAlleles().length; i++) {
                if (gene.getAllele(i) == solutionFunction.getSolutionAllele(i)) {
                    fitness++;
                }
            }
        }

        return fitness;
    }
}
