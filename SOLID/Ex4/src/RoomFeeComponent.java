public class RoomFeeComponent implements FeeComponent {
    private final double base;

    public RoomFeeComponent(int roomType) {
        switch (roomType) {
            case LegacyRoomTypes.SINGLE -> this.base = 14000.0;
            case LegacyRoomTypes.DOUBLE -> this.base = 15000.0;
            case LegacyRoomTypes.TRIPLE -> this.base = 12000.0;
            default -> this.base = 16000.0;
        }
    }

    @Override
    public double monthlyAmount() {
        return base;
    }
}
