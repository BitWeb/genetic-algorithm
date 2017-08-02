package ee.bitweb.geneticalgorithm;

import com.sun.org.apache.bcel.internal.generic.POP;
import ee.bitweb.geneticalgorithm.fitness.BinaryFitnessFunction;
import ee.bitweb.geneticalgorithm.fitness.FitnessFunction;
import ee.bitweb.geneticalgorithm.solution.SolutionFunction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tobre on 18/07/2017.
 */
public class Individual implements Comparable<Individual> {

    private Integer fitness = 0;
    private Chromosome chromosome;
    private Population parentPopulation;

    public Individual(Population parentPopulation) {
        setParentPopulation(parentPopulation);
    }

    void setParentPopulation(Population parentPopulation) {
        this.parentPopulation = parentPopulation;
    }

    public Integer getFitness() {
        if (fitness == 0) {
            fitness = (Integer) parentPopulation.fitnessFunction.getFitness(this);
        }

        return fitness;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    @Override
    public int compareTo(Individual o) {
        if (o.getFitness() < this.getFitness()) {
            return -1;
        } else if (o.getFitness() > this.getFitness()) {
            return 1;
        }

        return 0;
    }

    public Individual crossover(Population population, Individual parent) {
        Individual child = new Individual(population);
        child.setChromosome(chromosome.crossover(parent));

        return child;
    }

    public void mutate() {
        chromosome = chromosome.mutate();
    }
}
