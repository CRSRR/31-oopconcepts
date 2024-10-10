// Author: Clayton
// Rollno: 31
// Title: Goa Legislative Assembly
// Startdate: 15-07-24
// Modifieddate: 22-07-24
// Description: Constituency linked to members and structure retained

import java.util.ArrayList;
import java.util.List;

public class Constituency {
    private String name;
    private List<Member> members;

    public Constituency(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void displayInfo() {
        System.out.println("Constituency: " + name);
        System.out.println("Members:");
        for (Member member : members) {
            member.displayInfo();
        }
    }

}
