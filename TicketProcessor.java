import java.io.*;
import java.util.*;


class TicketProcessor {

    public static List<Ticket> readTicketsFromExcel(String filePath) throws IOException {
        List<Ticket> tickets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true; // Skip header row

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(","); // Split by comma
                if (values.length >= 5) { // Ensure there are enough columns
                    tickets.add(new Ticket(values[0], values[1], values[2], values[3], values[4]));
                }
            }
        }
        return tickets;
    }

    public static void processTicketsQueue(List<Ticket> tickets) {
        // Used for efficiency test
        long startTime = System.nanoTime();

        // Use two queues to solve the priority problem
        Queue<Ticket> urgentQueue = new LinkedList<>();
        Queue<Ticket> normalQueue = new LinkedList<>();

        // If the ticket is urgent, add it to the urgent queue. Otherwise, add to the normal queue
        for (Ticket ticket : tickets) {
            if ("Urgent".equals(ticket.priorityLevel)) {
                urgentQueue.offer(ticket);
            } else {
                normalQueue.offer(ticket);
            }
        }

        // Handle the urgent queue firstly
        while (!urgentQueue.isEmpty()) {
            Ticket ticket = urgentQueue.poll();
            //System.out.println("Processing URGENT ticket " + ticket.ticketId + " from " + ticket.customerName + " - " + ticket.issueDescription);
        }

        // Then the handle normal queue
        while (!normalQueue.isEmpty()) {
            Ticket ticket = normalQueue.poll();
            //System.out.println("Processing NORMAL ticket " + ticket.ticketId + " from " + ticket.customerName + " - " + ticket.issueDescription);
        }

        // calculate time used
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime);
    }

    public static void processTicketsDeque(List<Ticket> tickets) {
        // Used for efficiency test
        long startTime = System.nanoTime();

        Deque<Ticket> ticketDeque = new ArrayDeque<>();
        // If the ticket is urgent, add to head, otherwise add to tail
        for (Ticket ticket : tickets) {
            if (ticket.priorityLevel.equals("Urgent")) {
                ticketDeque.addFirst(ticket);
            } else {
                ticketDeque.addLast(ticket);
            }
        }

        while (!ticketDeque.isEmpty()) {
            Ticket ticket = ticketDeque.pollFirst();
            //System.out.println("Processing ticket " + ticket.ticketId + " from " + ticket.customerName + " - " + ticket.issueDescription);
        }

        // calculate time used
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime);
    }

    public static void main(String[] args) throws IOException {
        String filePath = "customer_tickets.csv";

        List<Ticket> tickets = readTicketsFromExcel(filePath);
        System.out.println("Processing using Queue:");
        processTicketsQueue(tickets);

        System.out.println("\nProcessing using Deque:");
        processTicketsDeque(tickets);

    }
}
