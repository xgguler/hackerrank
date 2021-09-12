import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class Priorities {

    public static List<Student> getStudents(List<String> events) {
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getName().equals(s2.getName()) && s1.getCgpa() == s2.getCgpa()) {
                    return s1.getId() - s2.getId();
                } else if(s1.getCgpa() == s2.getCgpa()) {
                    return s1.getName().compareTo(s2.getName());
                }
                return Double.compare(s2.getCgpa(),s1.getCgpa());
            }
        };

        java.util.PriorityQueue<Student> priorityQueue = new java.util.PriorityQueue<>(studentComparator);

        for(int i = 0; i < events.size(); i++) {
            if(!events.get(i).equals("SERVED")) {
                String[] arrOfStr = events.get(i).split(" ");
                Student student = new Student(Integer.parseInt(arrOfStr[3]), arrOfStr[1], Double.parseDouble(arrOfStr[2]));
                priorityQueue.add(student);
            } else {
                priorityQueue.poll();
            }
        }

        List<Student> students = new ArrayList<>();

        for (Student s: priorityQueue) {
            students.add(s);
        }

        students.sort(studentComparator);

        return students;
    }
}

public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}