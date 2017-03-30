package com.jesusgsdev.database;

import com.jesusgsdev.entities.Journal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jesgarsal on 30/03/17.
 */
public class Database {

    public static List<Journal> journals = new LinkedList<>();

    public static void addJournals(List<Journal> newJournals) {
        journals.addAll(newJournals);
    }

}
