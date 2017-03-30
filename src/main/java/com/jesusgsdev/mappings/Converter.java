package com.jesusgsdev.mappings;

import com.jesusgsdev.entities.Journal;
import com.jesusgsdev.entities.JournalRankedDTO;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Created by jesgarsal on 30/03/17.
 */
public class Converter {

    public static List<JournalRankedDTO> convert(List<Journal> journals){
        List<JournalRankedDTO> journalsRanked = new LinkedList<>();

        Integer rank = 0, counter = 0;
        Journal before = null;
        for(Journal journal : journals){
            counter++;
            if(shouldUpdateRankToCurrentCount(journal, before)){
                rank = counter;
            }

            journalsRanked.add(convert(journal, rank));
            before = journal;
        }

        return journalsRanked;
    }

    private static JournalRankedDTO convert(Journal journal, Integer rank){
        return JournalRankedDTO.newJournalRankedDTO().name(journal.getName()).score(journal.getScore()).rank(rank).build();
    }


    private static Boolean shouldUpdateRankToCurrentCount(Journal journal, Journal before){
        return isNull(before) || (nonNull(before) && !before.getScore().equals(journal.getScore()));
    }
}
