import java.util.*;

//SOLID Principles

//SRP : single responnsibility protocol
class Student
{
    private String name;
    private double fee;

    public Student(String name , double fee)
    {
        this.name = name;
        this.fee = fee;
    }

    public String getName()
    {
        return name;
    }

    public double getFee()
    {
        return fee;
    }
}


// DIP: Dependency Inversion Principle

interface FeeCalculator {
    double getCalculateFees(Student st);
}

class CalculateFees implements FeeCalculator {
    @Override
    public double getCalculateFees(Student st) {
        return st.getFee();
    }
}

//OCP:- Open Close Principle

interface TotalProfessor
{
    public int calculateProfessor(int professor);
}

class AssociateProfessor implements TotalProfessor 
{
    public int calculateProfessor(int professor) 
    {
        return professor * 2;  
    }
}

class AssistantProfessor implements TotalProfessor 
{
    public int calculateProfessor(int professor) 
    {
        return professor * 3;  
    }
}



//LSP: Liskov’s Substitution Principle 

abstract class StudentTypes
{
    abstract String calculateStudents(String student);
}

class FullTimeStudent extends StudentTypes {
    public String calculateStudents(String student) {
        return "Full-time student: " + student;
    }
}

class PartTimeStudent extends StudentTypes {
    public String calculateStudents(String student) {
        return "Part-time student: " + student;
    }
}


//ISP : interface segmentation principle
interface RecessTime
{
    void getRecess();
}

interface Assignment
{
    void checkAssignmet();
}

class Students implements RecessTime
{
    public void getRecess()
    {
        System.out.println("you get break");
    }
}

class Professor implements RecessTime , Assignment
{
    public void getRecess()
    {
        System.out.println("you get break");
    }

    public void checkAssignmet()
    {
        System.out.println("you have to check assignment");
    }
}

public class Principles
{
    public static void main(String[] args) {
        Student s1 = new Student("tony" , 120000);
        System.out.println("student name is: "+s1.getName());
        System.out.println("student fee is: "+s1.getFee());

        CalculateFees c1 = new CalculateFees();
        System.out.println("Calculated Fee: " + c1.getCalculateFees(s1));

        AssociateProfessor as = new AssociateProfessor();
        as.calculateProfessor(50);
        AssistantProfessor asp = new AssistantProfessor();
        asp.calculateProfessor(70);

        FullTimeStudent ft = new FullTimeStudent();
        ft.calculateStudents("fulltime");
        PartTimeStudent pt = new PartTimeStudent();
        pt.calculateStudents("parttime");

        Students s2 = new Students();
        s2.getRecess();
        Professor p = new Professor();
        p.getRecess();
        p.checkAssignmet();

    }
}