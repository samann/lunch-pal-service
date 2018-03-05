package com.droidwolf.lunchpal.service.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class Rating implements Serializable {
    private BigDecimal score;

    private Set<User> raters;

    public Rating() {
        this.score = ZERO;
        this.raters = new HashSet<>();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void incScore(User rater) {
        this.raters.add(rater);
        this.score = score.add(ONE);
    }

    public Set<User> getRaters() {
        return raters;
    }
}
