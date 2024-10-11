//Author:Clayton
//Rollno:31
//Title:Goa Legislative Assembly
//Startdate:15-07-24
//Modifieddate:22-07-24
//Description:to show oop implementation in goa legislative assembly
public class Member {
    private String name;
    private int age;
    private String constituency;
    private String party;
    private String position;

    public Member(String name, int age, String constituency, String party, String position) {
        this.name = name;
        this.age = age;
        this.constituency = constituency;
        this.party = party;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getConstituency() {
        return constituency;
    }

    public String getParty() {
        return party;
    }

    public String getPosition() {
        return position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Constituency: " + constituency);
        System.out.println("Party: " + party);
        System.out.println("Position: " + position);
    }
}

