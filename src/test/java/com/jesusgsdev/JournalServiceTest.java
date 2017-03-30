package com.jesusgsdev;

import com.jesusgsdev.database.Database;
import com.jesusgsdev.entities.Journal;
import com.jesusgsdev.entities.JournalRankedDTO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by jesgarsal on 30/03/17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JournalServiceTest {

    @BeforeClass
    public static void setUp(){
        setUpScenario1();
        setUpScenario2();
        setUpScenario3();
    }

    @Test
    public void scenario1(){
        System.out.println("Running Scenario 1");
        Integer year = 2015;
        List<JournalRankedDTO> rankedJournals = JournalService.getByYearSortedByScore(year);

        assertThat(rankedJournals, is(not(empty())));
        assertThat(rankedJournals, hasSize(3));

        JournalRankedDTO firstJournal = rankedJournals.get(0);
        assertThat(firstJournal.getName(), is(new String("Journal A")));
        assertThat(firstJournal.getScore(), is(new Double(5.6)));
        assertThat(firstJournal.getRank(), is(new Integer(1)));

        printResults(rankedJournals);
    }

    @Test
    public void scenario2(){
        System.out.println("\nRunning Scenario 2");
        Integer year = 2014;
        List<JournalRankedDTO> rankedJournals = JournalService.getByYearSortedByScore(year);

        assertThat(rankedJournals, is(not(empty())));
        assertThat(rankedJournals, hasSize(3));

        JournalRankedDTO firstJournal = rankedJournals.get(0);
        assertThat(firstJournal.getName(), is(new String("Journal B")));
        assertThat(firstJournal.getScore(), is(new Double(6.2)));
        assertThat(firstJournal.getRank(), is(new Integer(1)));

        JournalRankedDTO secondJournal = rankedJournals.get(1);
        assertThat(secondJournal.getName(), is(new String("Journal C")));
        assertThat(secondJournal.getScore(), is(new Double(6.2)));
        assertThat(secondJournal.getRank(), is(new Integer(1)));

        printResults(rankedJournals);
    }

    @Test
    public void scenario3(){
        System.out.println("\nRunning Scenario 3");
        Integer year = 2013;
        List<JournalRankedDTO> rankedJournals = JournalService.getOrderedByRankExcludingReviewJournals(year);

        assertThat(rankedJournals, is(not(empty())));
        assertThat(rankedJournals, hasSize(2));

        JournalRankedDTO firstJournal = rankedJournals.get(0);
        assertThat(firstJournal.getName(), is(new String("Journal C")));
        assertThat(firstJournal.getScore(), is(new Double(3.1)));
        assertThat(firstJournal.getRank(), is(new Integer(1)));

        JournalRankedDTO secondJournal = rankedJournals.get(1);
        assertThat(secondJournal.getName(), is(new String("Journal B")));
        assertThat(secondJournal.getScore(), is(new Double(2.4)));
        assertThat(secondJournal.getRank(), is(new Integer(2)));

        printResults(rankedJournals);
    }

    private static void setUpScenario1(){
        Journal j1 = Journal.newJournal().year(2015).name("Journal A").score(5.6).review(Boolean.FALSE).build();
        Journal j2 = Journal.newJournal().year(2015).name("Journal B").score(2.4).review(Boolean.FALSE).build();
        Journal j3 = Journal.newJournal().year(2015).name("Journal C").score(3.1).review(Boolean.FALSE).build();

        Database.addJournals(Arrays.asList(j1,j2,j3));
    }

    private static void setUpScenario2(){
        Journal j1 = Journal.newJournal().year(2014).name("Journal A").score(2.2).review(Boolean.FALSE).build();
        Journal j2 = Journal.newJournal().year(2014).name("Journal B").score(6.2).review(Boolean.FALSE).build();
        Journal j3 = Journal.newJournal().year(2014).name("Journal C").score(6.2).review(Boolean.FALSE).build();

        Database.addJournals(Arrays.asList(j1,j2,j3));
    }

    private static void setUpScenario3(){
        Journal j1 = Journal.newJournal().year(2013).name("Journal A").score(5.6).review(Boolean.TRUE).build();
        Journal j2 = Journal.newJournal().year(2013).name("Journal B").score(2.4).review(Boolean.FALSE).build();
        Journal j3 = Journal.newJournal().year(2013).name("Journal C").score(3.1).review(Boolean.FALSE).build();

        Database.addJournals(Arrays.asList(j1,j2,j3));
    }

    private void printResults(List<JournalRankedDTO> journals){
        System.out.println("Rank\tJournal\t\tScore");
        journals.forEach(j -> System.out.println(j.getRank() + "\t\t" + j.getName() + "\t" + j.getScore()));
    }
}
