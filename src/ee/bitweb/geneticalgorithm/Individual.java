package ee.bitweb.geneticalgorithm;

import com.sun.org.apache.bcel.internal.generic.POP;
import ee.bitweb.geneticalgorithm.fitness.BinaryFitnessFunction;
import ee.bitweb.geneticalgorithm.fitness.FitnessFunction;
import ee.bitweb.geneticalgorithm.solution.SolutionFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tobre on 18/07/2017.
 */
public class Individual implements Comparable<Individual> {

    private Integer fitness = 0;
    private List<Gene> genes = new ArrayList<>();
    private Population parentPopulation;

    public Individual() {
    }

    public Individual(Population parentPopulation) {
        setParentPopulation(parentPopulation);
    }

    void setParentPopulation(Population parentPopulation) {
        this.parentPopulation = parentPopulation;
    }

    public void generateGenes(Integer geneSize) {
        for (int i = 0; i < geneSize; i++) {
            Gene gene = new Gene(Math.random());
            genes.add(gene);
        }
    }

    public Integer getFitness() {
        if (fitness == 0) {
            fitness = (Integer) parentPopulation.fitnessFunction.getFitness(this);
        }

        return fitness;
    }

    void addGene(Gene gene) {
        genes.add(gene);
    }

    public List<Gene> getGenes() {
        return genes;
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

    public Individual crossover(Individual parent) {
        Individual child = new Individual();
        for (int i = 0; i < parent.getGenes().size(); i++) {
            Gene gene = new Gene(parent.getGenes().get(i).getAlleles().length);
            for (int j = 0; j < parent.getGenes().get(i).getAlleles().length; j++) {
                if (Math.random() <= 0.5) {
                    gene.setAllele(j, this.getGenes().get(i).getAllele(j));
                } else {
                    gene.setAllele(j, parent.getGenes().get(i).getAllele(j));
                }
            }
            child.addGene(gene);
        }
        return child;
    }

    public void mutate() {
        Random generator = new Random();
        List<Gene> genes = new ArrayList<>();
        for (int i = 0; i < this.getGenes().size(); i++) {
            Gene gene = new Gene(this.getGenes().get(i).getAlleles().length);
            for (int j = 0; j < this.getGenes().get(i).getAlleles().length; j++) {
                if (Math.random() <= 0.02) {
                    byte[] b = new byte[1];
                    generator.nextBytes(b);
                    gene.setAllele(j, b[0]);
                } else {
                    gene.setAllele(j, this.getGenes().get(i).getAllele(j));
                }
            }
            genes.add(gene);
        }

        this.genes = genes;
    }
}
