package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.*;
import static java.math.BigDecimal.ONE;

public class Rating {
    private BigDecimal score;

    private List<User> raters;

    public Rating() {
        this.score = ZERO;
        this.raters = new ArrayList<>();
    }

    public BigDecimal getScore() {
        return score.divide(valueOf(raters.size()), ROUND_CEILING);
    }

    public BigDecimal incScore(User rater) {
        this.raters.add(rater);
        return score.add(ONE);
    }

    public List<User> getRaters() {
        return raters;
    }
}
