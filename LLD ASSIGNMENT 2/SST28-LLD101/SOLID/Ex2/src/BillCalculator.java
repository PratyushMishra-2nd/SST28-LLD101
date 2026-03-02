import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BillCalculator {
    public BillResult calculate(String customerType, List<OrderLine> lines, Map<String, MenuItem> menu) {
        List<String> lineDescs = new ArrayList<>();
        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineDescs.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }

        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;

        return new BillResult(lineDescs, subtotal, taxPct, tax, discount, total);
    }
}
