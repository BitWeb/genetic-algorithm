package ee.bitweb.geneticalgorithm.chromosome;

import ee.bitweb.geneticalgorithm.Chromosome;
import ee.bitweb.geneticalgorithm.util.BinaryUtil;

/**
 * Created by tobre on 31/07/2017.
 */
public class DoubleNumberChromosome extends Chromosome<Double> {

    public DoubleNumberChromosome() {
        super(Math.random());
    }

    public DoubleNumberChromosome(Double chromosome) {
        super(chromosome);
    }

    @Override
    protected byte[] encode(Double chromosome) {
        return BinaryUtil.convert(chromosome);
    }

    @Override
    protected Double decode(byte[] alleles) {
        return BinaryUtil.convert(alleles);
    }
}
