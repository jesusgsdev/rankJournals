package com.jesusgsdev.entities;

import java.util.Objects;

/**
 * Created by jesgarsal on 30/03/17.
 */
public class JournalRankedDTO {

    private Integer rank;
    private String name;
    private Double score;

    private JournalRankedDTO() {
    }

    private JournalRankedDTO(Builder builder) {
        this.rank = builder.rank;
        this.name = builder.name;
        this.score = builder.score;
    }

    public static Builder newJournalRankedDTO() {
        return new Builder();
    }

    public Integer getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JournalRankedDTO)) return false;
        JournalRankedDTO that = (JournalRankedDTO) o;
        return Objects.equals(rank, that.rank) &&
                Objects.equals(name, that.name) &&
                Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, name, score);
    }

    @Override
    public String toString() {
        return "{rank=" + rank +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static final class Builder {
        private Integer rank;
        private String name;
        private Double score;

        private Builder() {
        }

        public JournalRankedDTO build() {
            return new JournalRankedDTO(this);
        }

        public Builder rank(Integer rank) {
            this.rank = rank;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder score(Double score) {
            this.score = score;
            return this;
        }
    }
}
