package ee.bitweb.geneticalgorithm.fitness;

import ee.bitweb.geneticalgorithm.Individual;
import ee.bitweb.geneticalgorithm.util.BinaryUtil;

/**
 * Created by tobre on 18/07/2017.
 */
public class BinaryFitnessFunction implements FitnessFunction<Integer> {

    private Double solution;
    private byte[] solutionAllele;

    public BinaryFitnessFunction(Double solution) {
        this.solution = solution;
        this.solutionAllele = BinaryUtil.convert(solution);
    }

    @Override
    public Integer getFitness(Individual individual) {
        int fitness = 0;
        byte[] alleles = individual.getChromosome().getAlleles();
        for (int i = 0; i < alleles.length; i++) {
            if (alleles[i] == solutionAllele[i]) {
                fitness++;
            }
        }

        return fitness;
    }

    public Integer getMaxFitness() {
        return solutionAllele.length;
    }
}
