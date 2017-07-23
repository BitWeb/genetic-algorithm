package ee.bitweb.geneticalgorithm.solution;

/**
 * Created by tobre on 18/07/2017.
 */
public interface SolutionFunction<T> {


    public byte[] getSolutionAlleles();

    public byte getSolutionAllele(Integer i);

    Integer getMaxFitness();
}
