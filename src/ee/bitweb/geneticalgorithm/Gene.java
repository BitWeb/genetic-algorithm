package ee.bitweb.geneticalgorithm;

import ee.bitweb.geneticalgorithm.util.BinaryUtil;

import java.nio.ByteBuffer;

/**
 * Created by tobre on 18/07/2017.
 */
public class Gene {

    private Integer alleleSize;
    private byte[] alleles;

    Gene(Integer alleleSize) {
        this.alleleSize = alleleSize;
        alleles = new byte[alleleSize];
    }

    Gene(Double value) {
        this.alleles = BinaryUtil.convert(value);
    }

    public byte[] getAlleles() {
        return alleles;
    }

    public byte getAllele(int i) {
        return alleles[i];
    }

    void setAllele(int i, byte allele) {
        alleles[i] = allele;
    }
}
