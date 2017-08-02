package ee.bitweb.geneticalgorithm;

import ee.bitweb.geneticalgorithm.fitness.FitnessFunction;
import ee.bitweb.geneticalgorithm.selection.SelectionFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by tobre on 18/07/2017.
 */
public class Population {

    protected List<Individual> individuals = new ArrayList<>();
    protected FitnessFunction fitnessFunction;
    protected SelectionFunction selectionFunction;
    protected Integer populationSize;

    Population(Integer populationSize, FitnessFunction fitnessFunction, SelectionFunction selectionFunction) {
        this.populationSize = populationSize;
        this.fitnessFunction = fitnessFunction;
        this.selectionFunction = selectionFunction;
    }

    public void generateIndividuals(Class<? extends Chromosome> chromosomeClass) {
        for (int i = 0; i < populationSize; i++) {
            Individual individual = new Individual(this);
            try {
                individual.setChromosome(chromosomeClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            individuals.add(individual);
        }
    }

    void addIndividual(Individual individual) {
        individuals.add(individual);
    }

    public void addIndividuals(Callable callable) throws Exception {
        for (int i = 0; i < populationSize; i++) {
            addIndividual((Individual) callable.call());
        }
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public Individual getIndividual(int i) {
        return individuals.get(i);
    }

    public Individual getFittest() {
        individuals.sort(null);

        return individuals.iterator().next();
    }

    Population evolve() {
        Population newPopulation = new Population(individuals.size(), fitnessFunction, selectionFunction);

        for (int i = 0; i < individuals.size(); i++) {
            Individual parent1 = selectParent();
            Individual parent2 = selectParent();
            Individual child = parent1.crossover(newPopulation, parent2);
            child.mutate();
            newPopulation.addIndividual(child);
        }
        selectionFunction.setPopulation(newPopulation);

        return newPopulation;
    }

    private Individual selectParent() {
        return selectionFunction.selectParent();
    }

    public FitnessFunction getFitnessFunction() {
        return fitnessFunction;
    }
}
