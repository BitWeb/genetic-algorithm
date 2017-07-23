package ee.bitweb.geneticalgorithm.solution;

import ee.bitweb.geneticalgorithm.util.BinaryUtil;

/**
 * Created by tobre on 18/07/2017.
 */
public class BinarySolution implements SolutionFunction<Double> {

    private Double solution;
    private byte[] solutionAlleles;

    public BinarySolution(Double solution) {
        this.solution = solution;
        solutionAlleles = BinaryUtil.convert(solution);
    }

    public byte[] getSolutionAlleles() {
        return solutionAlleles;
    }

    public byte getSolutionAllele(Integer i) {
        return solutionAlleles[i];
    }

    @Override
    public Integer getMaxFitness() {
        return solutionAlleles.length;
    }
}
