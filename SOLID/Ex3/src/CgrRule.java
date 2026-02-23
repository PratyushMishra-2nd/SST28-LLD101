public class CgrRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        return s.cgr < 8.0 ? "CGR below 8.0" : null;
    }
}
