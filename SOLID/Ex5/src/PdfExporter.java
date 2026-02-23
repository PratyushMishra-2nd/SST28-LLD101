import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    private static final int MAX_BODY_LEN = 20;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("req must not be null");
        if (req.body != null && req.body.length() > MAX_BODY_LEN) {
            throw new IllegalArgumentException("PDF cannot handle content > " + MAX_BODY_LEN + " chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
