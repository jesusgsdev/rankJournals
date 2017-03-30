package com.jesusgsdev;

import com.jesusgsdev.database.Database;
import com.jesusgsdev.entities.Journal;
import com.jesusgsdev.entities.JournalRankedDTO;
import com.jesusgsdev.mappings.Converter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jesgarsal on 30/03/17.
 */
public class JournalService {

    public static List<JournalRankedDTO> getByYearSortedByScore(Integer year) {
        return Converter.convert(getSortedByScore(year).collect(Collectors.toList()));
    }

    public static List<JournalRankedDTO> getOrderedByRankExcludingReviewJournals(Integer year) {
        return Converter.convert(getSortedByScore(year).filter(journal -> !journal.getIsReview()).collect(Collectors.toList()));
    }

    private static Stream<Journal> getSortedByScore(final Integer year) {
        return Database.journals
                .stream()
                .filter(journal -> journal.getYear().equals(year))
                .sorted(Comparator.comparing(Journal::getScore).reversed().thenComparing(Journal::getName));
    }

}
