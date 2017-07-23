import ee.bitweb.geneticalgorithm.GeneticAlgorithm;
import ee.bitweb.geneticalgorithm.fitness.BinaryFitnessFunction;
import ee.bitweb.geneticalgorithm.selection.TournamentSelection;
import ee.bitweb.geneticalgorithm.solution.BinarySolution;

/**
 * Created by tobre on 18/07/2017.
 */
public class Main {

    public static void main(String[] args) {
        GeneticAlgorithm ga = new GeneticAlgorithm(100,
                new BinaryFitnessFunction(),
                new BinarySolution(Math.random()),
                new TournamentSelection(5)
        );

        Integer generations = ga.run();
        System.out.print("Solution found in " + generations + " generations");
    }
}
