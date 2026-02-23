public class AddOnFeeComponent implements FeeComponent {
    private final double amount;

    public AddOnFeeComponent(AddOn addOn) {
        switch (addOn) {
            case MESS -> this.amount = 1000.0;
            case LAUNDRY -> this.amount = 500.0;
            case GYM -> this.amount = 300.0;
            default -> this.amount = 0.0;
        }
    }

    @Override
    public double monthlyAmount() {
        return amount;
    }
}
