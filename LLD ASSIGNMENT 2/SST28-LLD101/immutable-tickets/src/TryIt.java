import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        IncidentTicket assigned = service.assign(t, "agent@example.com");
        IncidentTicket escalated = service.escalateToCritical(assigned);
        System.out.println("\nAfter service updates (new instances): " + escalated);
        System.out.println("Original ticket unchanged: " + t);

        List<String> tags = t.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("\nERROR: tags list was mutable!");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nImmutability confirmed: external tag mutation blocked.");
        }

        System.out.println("Original tags still intact: " + t.getTags());
    }
}
