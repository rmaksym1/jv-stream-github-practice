package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MINIMUM_AGE = 35;
    private static final String CANDIDATE_REQ_NATIONALITY = "Ukrainian";
    private static final int CANDIDATE_MUST_LIVED_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsPeriod = candidate.getPeriodsInUkr().split("-");
        int yearsInUa = Integer.parseInt(yearsPeriod[1]) - Integer.parseInt(yearsPeriod[0]);
        if (candidate.getAge() >= CANDIDATE_MINIMUM_AGE
                && candidate.getNationality().equals(CANDIDATE_REQ_NATIONALITY)
                && yearsInUa >= CANDIDATE_MUST_LIVED_YEARS
                && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }
}
