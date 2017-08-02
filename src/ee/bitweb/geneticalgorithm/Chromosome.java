package ee.bitweb.geneticalgorithm;

import ee.bitweb.geneticalgorithm.util.BinaryUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * Created by tobre on 24/07/2017.
 */
abstract public class Chromosome<T> {

    protected T chromosome;
    private byte[] alleles;

    public Chromosome() {
    }

    public Chromosome(T chromosome) {
        this.chromosome = chromosome;
    }

    public byte[] getAlleles() {
        if (alleles == null) {
            alleles = encode(chromosome);
        }

        return alleles;
    }

    Chromosome crossover(Individual parent2) {
        byte[] newAlleles = new byte[getAlleles().length];
        for (int i = 0; i < getAlleles().length; i++) {
            if (Math.random() <= 0.5) {
                newAlleles[i] = getAlleles()[i];
            } else {
                newAlleles[i] = parent2.getChromosome().getAlleles()[i];
            }
        }

        return newInstance(newAlleles);
    }

    public Chromosome mutate() {
        Random generator = new Random();
        byte[] newAlleles = new byte[getAlleles().length];
        for (int i = 0; i < getAlleles().length; i++) {
            if (Math.random() <= 0.02) {
                byte[] b = new byte[1];
                generator.nextBytes(b);
                newAlleles[i] = b[0];
            } else {
                newAlleles[i] = getAlleles()[i];
            }
        }

        return newInstance(newAlleles);
    }

    private Chromosome newInstance(byte[] newAlleles) {
        try {
            return this.getClass().getConstructor(chromosome.getClass()).newInstance(decode(newAlleles));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public T getChromosome() {
        return chromosome;
    }

    abstract protected byte[] encode(T chromosome);
    abstract protected T decode(byte[] alleles);
}
