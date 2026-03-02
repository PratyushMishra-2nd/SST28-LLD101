public class AttendanceRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        return s.attendancePct < 75 ? "attendance below 75" : null;
    }
}
