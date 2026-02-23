import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        List<FeeComponent> components = new ArrayList<>();
        components.add(new RoomFeeComponent(req.roomType));
        for (AddOn a : req.addOns) {
            components.add(new AddOnFeeComponent(a));
        }

        double total = 0.0;
        for (FeeComponent c : components) {
            total += c.monthlyAmount();
        }
        return new Money(total);
    }
}
