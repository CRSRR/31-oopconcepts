// Author: Clayton
// Rollno: 31
// Title: Goa Legislative Assembly
// Startdate: 15-07-24
// Modifieddate: 22-07-24
// Description: OOP principles added - abstraction, inheritance, and polymorphism (overriding)

public abstract class Member {
    protected String name;
    protected int age;
    protected String constituency;
    protected String party;
    protected String position;
    protected boolean isCopied; 

    public Member(String name, int age, String constituency, String party, String position) {
        this.name = name;
        this.age = age;
        this.constituency = constituency;
        this.party = party;
        this.position = position;
        this.isCopied = false; // Original members are not copied
    }

    // Copy Constructor
    public Member(Member another) {
        this.name = another.name;
        this.age = another.age;
        this.constituency = another.constituency;
        this.party = another.party;
        this.position = another.position;
        this.isCopied = true; 
    }

    // Abstract method (to be overridden by derived classes)
    public abstract void displayInfo();

    // Overloaded method - polymorphism (compile-time)
    public void setDetails(String party, String position) {
        this.party = party;
        this.position = position;
    }

    public void setDetails(int age) {
        this.age = age;
    }
}

// Single-level inheritance - MLA Member
class MLAMember extends Member {
    public MLAMember(String name, int age, String constituency, String party, String position) {
        super(name, age, constituency, party, position);
    }

    // Copy constructor
    public MLAMember(MLAMember another) {
        super(another); // Call the parent class's copy constructor
    }

    @Override
    public void displayInfo() {
        System.out.println("MLA Member: " + name);
        if (isCopied) {
            System.out.println("This is a copied member.");
        }
        System.out.println("Age: " + age + ", Constituency: " + constituency + ", Party: " + party + ", Position: " + position);
    }
}

// Multi-level inheritance - Senior MLA
class SeniorMLAMember extends MLAMember {
    private int yearsOfService;

    public SeniorMLAMember(String name, int age, String constituency, String party, String position, int yearsOfService) {
        super(name, age, constituency, party, position);
        this.yearsOfService = yearsOfService;
    }

    // Copy constructor
    public SeniorMLAMember(SeniorMLAMember another) {
        super(another); // Call the parent class's copy constructor
        this.yearsOfService = another.yearsOfService; // Copy yearsOfService
    }

    @Override
    public void displayInfo() {
        System.out.println("Senior MLA Member: " + name + " with " + yearsOfService + " years of service.");
        if (isCopied) {
            System.out.println("This is a copied member.");
        }
        System.out.println("The senior member has control of more constituencies.");
        super.displayInfo(); // Call to the parent class's method
    }
}

// Hierarchical inheritance - Special Members
class SpecialMember extends Member {
    public SpecialMember(String name, int age, String constituency, String party, String position) {
        super(name, age, constituency, party, position);
    }

    // Copy constructor
    public SpecialMember(SpecialMember another) {
        super(another); // Call the parent class's copy constructor
    }

    @Override
    public void displayInfo() {
        System.out.println("Special Member: " + name);
        if (isCopied) {
            System.out.println("This is a copied member.");
        }
        System.out.println("Age: " + age + ", Constituency: " + constituency + ", Party: " + party + ", Position: " + position);
    }
}
