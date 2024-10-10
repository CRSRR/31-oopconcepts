// Author: Clayton
// Rollno: 31
// Title: Goa Legislative Assembly
// Startdate: 15-07-24
// Modifieddate: 22-07-24
// Description: Method overloading, copy constructor added, and switch-case retained

import java.util.ArrayList;
import java.util.List;

public class Session {
    private String sessionDate;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String agenda;
    private List<String> topicsOfDiscussion;

    // Constructor
    public Session(String sessionDate, int startHour, int startMinute, int endHour, int endMinute, String agenda) {
        this.sessionDate = sessionDate;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.agenda = agenda;
        this.topicsOfDiscussion = new ArrayList<>();
    }

    // Copy Constructor
    public Session(Session another) {
        this.sessionDate = another.sessionDate;
        this.startHour = another.startHour;
        this.startMinute = another.startMinute;
        this.endHour = another.endHour;
        this.endMinute = another.endMinute;
        this.agenda = another.agenda;
        this.topicsOfDiscussion = new ArrayList<>(another.topicsOfDiscussion);
    }

    // Overloaded constructor (Polymorphism - Overloading)
    public Session(String sessionDate, String agenda) {
        this.sessionDate = sessionDate;
        this.agenda = agenda;
        this.topicsOfDiscussion = new ArrayList<>();
    }

    // Overloaded method
    public void addTopicOfDiscussion(String topic, boolean urgent) {
        topicsOfDiscussion.add(topic + (urgent ? " (Urgent)" : ""));
    }

    // Original method
    public void addTopicOfDiscussion(String topic) {
        topicsOfDiscussion.add(topic);
    }

    public void displayInfo() {
        System.out.println("Session Date: " + sessionDate);
        System.out.printf("Start Time: %02d:%02d\n", startHour, startMinute);
        System.out.printf("End Time: %02d:%02d\n", endHour, endMinute);
        System.out.println("Agenda: " + agenda);
        System.out.println("Topics of Discussion:");
        for (String topic : topicsOfDiscussion) {
            System.out.println(" - " + topic);
        }
    }

    // Switch case to modify session agenda
    public void updateAgenda(int option) {
        switch (option) {
            case 1:
                this.agenda = "Education Policy";
                break;
            case 2:
                this.agenda = "Healthcare Reform";
                break;
            case 3:
                this.agenda = "Economic Growth";
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    public String getAgenda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAgenda'");
    }
}
