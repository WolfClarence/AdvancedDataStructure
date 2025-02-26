import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;



class TicketProcessor {

    //Use Apache API to generate an Excel file
    public static void generateExcelFile(String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Tickets");
        String[] headers = {"Ticket ID", "Customer Name", "Issue Description", "Priority Level", "Timestamp"};

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        String[] customers = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"};
        String[] issues = {"Login Issue", "Payment Failure", "Account Hacked", "Refund Request", "Bug Report",
                "Feature Request", "Order Not Received", "Slow Performance", "App Crash", "Other"};
        Random random = new Random();

        for (int i = 1; i <= 10000; i++) {
            Row row = sheet.createRow(i);
            //This means T00001
            row.createCell(0).setCellValue("T" + String.format("%05d", i));
            row.createCell(1).setCellValue(customers[random.nextInt(customers.length)]);
            row.createCell(2).setCellValue(issues[random.nextInt(issues.length)]);
            row.createCell(3).setCellValue(random.nextDouble() < 0.2 ? "Urgent" : "Normal");
            row.createCell(4).setCellValue("2025-02-26 10:00:00");
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public static List<Ticket> readTicketsFromExcel(String filePath) throws IOException {
        List<Ticket> tickets = new ArrayList<>();
        //Use Java I/O to transform file to Java instance
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                tickets.add(new Ticket(
                        row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue()
                ));
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
        String filePath = "customer_tickets.xlsx";
        //generateExcelFile(filePath);

        List<Ticket> tickets = readTicketsFromExcel(filePath);
        System.out.println("Processing using Queue:");
        processTicketsQueue(tickets);

        System.out.println("\nProcessing using Deque:");
        processTicketsDeque(tickets);

    }
}
