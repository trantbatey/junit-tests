import java.util.ArrayList;
import java.util.List;

public class Student {
    private long id;
    private static long count;
    private String name;
    public List<Integer> grades;

    public Student() {
        count++;
        id = count;
        grades = new ArrayList<>();
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    public static long getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(int i) {
        grades.add(i);
    }

    public int getGradeAverage() {
        int sum = 0;
        for(int grade : grades) {
            sum += grade;
        }
        return sum/grades.size();
    }

    public void deleteGrade(int index) {
        grades.remove(index);
    }

    public int getGrade(int index) {
        return grades.get(index);
    }

    public void updateGrade(int index, int newGrade) {
        grades.set(index, newGrade);
    }
}
