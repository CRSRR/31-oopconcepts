//Author:Clayton
//Rollno:31
//Title:Goa Legislative Assembly
//Startdate:15-07-24
//Modifieddate:22-07-24
//Description:to show oop implementation in goa legislative assembly
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class legis {
    private static List<Member> members = new ArrayList<>();
    private static List<Bill> bills = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static List<Constituency> constituencies = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Goa Legislative Assembly");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Add Bill");
            System.out.println("4. Create Session");
            System.out.println("5. see Session created");
            System.out.println("6. View Constituencies");
            System.out.println("0. EXIT");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addMember(scanner);
                    break;
                case 2:
                    displayMembers();
                    break;
                case 3:
                    addBill(scanner);
                    break;
                case 4:
                    createSession(scanner);
                    break;
                case 5:
                    displaySession();
                    break;
                case 6:
                    displayConstituencies();
                    break;
                case 0:
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    System.exit(0); 
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void addMember(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter constituency: ");
        String constitname = scanner.nextLine();
        System.out.print("Enter party: ");
        String party = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();

        Member member = new Member(name, age, constitname, party, position);
        members.add(member);

        Constituency constituency = getConstituencyByName(constitname);
        if (constituency == null) {
            constituency = new Constituency(constitname);
            constituencies.add(constituency);
        }
        constituency.addMember(member);
    }

    private static void displayMembers() {
        System.out.println("Members of the Legislative Assembly:");
        for (Member member : members) {
            member.displayInfo();
        }
    }

    private static void addBill(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Enter bill title: ");
        String title = scanner.nextLine();
        System.out.print("Enter bill description: ");
        String description = scanner.nextLine();
        System.out.print("Enter proposer: ");
        String proposer = scanner.nextLine();
        System.out.print("Enter date introduced (DD-MM-YYYY): ");
        String dateintro = scanner.nextLine();

        Bill.BillStatus status = null;
        while (status == null) {
            System.out.print("Enter status (Proposed, Pending, Approved, Rejected): ");
            try {
                status = Bill.BillStatus.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status. Please enter one of the following: Proposed, Pending, Approved, Rejected");
            }
        }

        bills.add(new Bill(title, description, proposer, dateintro, status));
    }

    private static void createSession(Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter session date (dd/mm/yyyy): ");
        String sessionDate = scanner.nextLine();
        System.out.print("Enter start hour (0-23): ");
        int startHour = scanner.nextInt();
        System.out.print("Enter start minute (0-59): ");
        int startMinute = scanner.nextInt();
        System.out.print("Enter end hour (0-23): ");
        int endHour = scanner.nextInt();
        System.out.print("Enter end minute (0-59): ");
        int endMinute = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter agenda: ");
        String agenda = scanner.nextLine();

        Session session = new Session(sessionDate, startHour, startMinute, endHour, endMinute, agenda);
        sessions.add(session);

        System.out.println("Do you want to add topics of discussion to this session? (yes/no): ");
        String addTopics = scanner.nextLine();
        while (addTopics.equalsIgnoreCase("yes")) {
            System.out.print("Enter topic of discussion: ");
            String topic = scanner.nextLine();
            session.addTopicOfDiscussion(topic);
            System.out.println("Topic added: " + topic);

            System.out.println("Do you want to add more topics? (yes/no): ");
            addTopics = scanner.nextLine();
        }
    }

    private static void displayConstituencies() {
        System.out.println("Constituencies in the Legislative Assembly:");
        for (Constituency constituency : constituencies) {
            System.out.println("Constituency: " + constituency.getName());
        }
    }

    private static void displaySession() {
        System.out.println("Sessions created:");
        for (Session session : sessions) {
            System.out.println("LIST: "+ session.getAgenda());
        }
           
        
    }

    private static Constituency getConstituencyByName(String name) {
        for (Constituency constituency : constituencies) {
            if (constituency.getName().equalsIgnoreCase(name)) {
                return constituency;
            }
        }
        return null;
    }
}

