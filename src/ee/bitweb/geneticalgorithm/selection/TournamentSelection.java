package ee.bitweb.geneticalgorithm.selection;

import ee.bitweb.geneticalgorithm.Individual;
import ee.bitweb.geneticalgorithm.Population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by tobre on 19/07/2017.
 */
public class TournamentSelection implements SelectionFunction {

    private Population population;
    private Integer tournamentSize;

    public TournamentSelection(Integer tournamentSize) {
        this.tournamentSize = tournamentSize;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    public Individual selectParent() {
        Random generator = new Random();
        List<Individual> parentCandidates = new ArrayList<>();
        for (int i = 0; i < tournamentSize; i++) {
            int random = generator.nextInt(population.getIndividuals().size());
            parentCandidates.add(population.getIndividual(random));
        }

        Collections.sort(parentCandidates);

        return parentCandidates.iterator().next();
    }
}
