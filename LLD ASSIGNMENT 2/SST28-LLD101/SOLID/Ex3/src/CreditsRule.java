public class CreditsRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        return s.earnedCredits < 20 ? "credits below 20" : null;
    }
}
