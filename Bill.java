// Author: Clayton
// Rollno: 31
// Title: Goa Legislative Assembly
// Startdate: 15-07-24
// Modifieddate: 22-07-24
// Description: OOP principles added - copy constructor and case statement preserved

public class Bill {
    public enum BillStatus {
        PROPOSED,
        PENDING,
        APPROVED,
        REJECTED
    }

    private String title;
    private String description;
    private String proposer;
    private String dateIntroduced;
    private BillStatus status;

    public Bill(String title, String description, String proposer, String dateIntroduced, BillStatus status) {
        this.title = title;
        this.description = description;
        this.proposer = proposer;
        this.dateIntroduced = dateIntroduced;
        this.status = status;
    }

    // Copy Constructor
    public Bill(Bill another) {
        this.title = another.title;
        this.description = another.description;
        this.proposer = another.proposer;
        this.dateIntroduced = another.dateIntroduced;
        this.status = another.status;
    }
    
    public void setStatus(BillStatus status) {
        this.status = status;
    }

  
    public void displayInfo() {
        System.out.println("Bill Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Proposer: " + proposer);
        System.out.println("Date Introduced: " + dateIntroduced);
        System.out.println("Status: " + status);
    }

    public void updateStatus(int statusOption) {
        switch (statusOption) {
            case 1:
                this.status = BillStatus.PROPOSED;
                break;
            case 2:
                this.status = BillStatus.PENDING;
                break;
            case 3:
                this.status = BillStatus.APPROVED;
                break;
            case 4:
                this.status = BillStatus.REJECTED;
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
