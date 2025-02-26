class Ticket {
    String ticketId;
    String customerName;
    String issueDescription;
    String priorityLevel;
    String timestamp;

    public Ticket(String ticketId, String customerName, String issueDescription, String priorityLevel, String timestamp) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priorityLevel = priorityLevel;
        this.timestamp = timestamp;
    }
}