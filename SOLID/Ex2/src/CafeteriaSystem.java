import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private final BillCalculator calculator = new BillCalculator();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        BillResult bill = calculator.calculate(customerType, lines, menu);

        String printable = InvoiceFormatter.format(invId, bill);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
