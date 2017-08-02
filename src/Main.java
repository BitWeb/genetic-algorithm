import ee.bitweb.geneticalgorithm.Chromosome;
import ee.bitweb.geneticalgorithm.GeneticAlgorithm;
import ee.bitweb.geneticalgorithm.chromosome.DoubleNumberChromosome;
import ee.bitweb.geneticalgorithm.fitness.BinaryFitnessFunction;
import ee.bitweb.geneticalgorithm.selection.TournamentSelection;

/**
 * Created by tobre on 18/07/2017.
 */
public class Main {

    public static void main(String[] args) {
        GeneticAlgorithm ga = new GeneticAlgorithm(100,
                new BinaryFitnessFunction(Math.random()),
                new TournamentSelection(5)
        );
        ga.getPopulation().generateIndividuals(DoubleNumberChromosome.class);

        Integer generations = ga.run();
        System.out.print("Solution found in " + generations + " generations");
    }
}
