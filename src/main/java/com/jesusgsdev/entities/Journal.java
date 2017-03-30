package com.jesusgsdev.entities;

import java.util.Objects;

/**
 * Created by jesgarsal on 30/03/17.
 */
public class Journal {

    private String name;
    private Double score;
    private Integer year;
    private Boolean isReview;

    private Journal() {
    }

    private Journal(Builder builder) {
        this.name = builder.name;
        this.score = builder.score;
        this.year = builder.year;
        this.isReview = builder.isReview;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getIsReview() {
        return isReview;
    }

    public void setIsReview(Boolean isReview) {
        this.isReview = isReview;
    }

    public static Builder newJournal() {
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        Journal journal = (Journal) o;
        return Objects.equals(name, journal.name) &&
                Objects.equals(score, journal.score) &&
                Objects.equals(year, journal.year) &&
                Objects.equals(isReview, journal.isReview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, year, isReview);
    }

    public static final class Builder {
        private String name;
        private Double score;
        private Integer year;
        private Boolean isReview;

        private Builder() {
        }

        public Journal build() {
            return new Journal(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder score(Double score) {
            this.score = score;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Builder review(Boolean isReview) {
            this.isReview = isReview;
            return this;
        }
    }
}
