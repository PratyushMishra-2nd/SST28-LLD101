public class InvoiceFormatter {
    public static String format(String invId, BillResult bill) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(invId).append("\n");
        for (String line : bill.lineDescriptions)
            sb.append(line).append("\n");
        sb.append(String.format("Subtotal: %.2f\n", bill.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", bill.taxPct, bill.tax));
        sb.append(String.format("Discount: -%.2f\n", bill.discount));
        sb.append(String.format("TOTAL: %.2f\n", bill.total));
        return sb.toString();
    }
}
