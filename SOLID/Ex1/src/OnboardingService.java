import java.util.List;
import java.util.Map;

public class OnboardingService {
    private final StudentRepository repo;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final RegistrationPrinter printer;

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
        this.parser = new StudentParser();
        this.validator = new StudentValidator();
        this.printer = new RegistrationPrinter();
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = validator.validate(name, email, phone, program);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);
        repo.save(rec);

        printer.printSuccess(rec, repo.count());
    }
}
