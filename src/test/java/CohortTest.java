import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort emptyCohort;
    Cohort cohortWithOne;
    Cohort cohortWithMany;

    @Before
    public void setup(){
        emptyCohort = new Cohort();
        cohortWithOne = new Cohort();
        cohortWithMany = new Cohort();

        Student fer = new Student(1, "Fer M");
        fer.addGrade(90);

        Student trant = new Student(2, "Trant B");
        trant.addGrade(70);
        trant.addGrade(90);
        trant.addGrade(80);

        cohortWithOne.addStudent(fer);
        cohortWithMany.addStudent(fer);
        cohortWithMany.addStudent(trant);
    }

    @Test
    public void testAddStudentAndGetStudentsWork(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortWithOne.getStudents().size());
//        assertEquals(1, cohortWithOne.getStudents().get(0).getId());
    }

    @Test
    public void testIfAvgIsCorrect(){
        assertEquals(85.0, cohortWithMany.getCohortAverage(), 0);
    }

    @Test
    public void testAddStudent() {
        int startSize = cohortWithMany.getStudents().size();
        Student casey = new Student(2, "Casey F");
        casey.addGrade(90);
        casey.addGrade(100);
        casey.addGrade(80);
        cohortWithMany.addStudent(casey);
        assertEquals(startSize + 1, cohortWithMany.getStudents().size());
    }

    // Though the test are very similar, by keeping them separate we can change then later
    @Test
    public void testGetStudents() {
        int startSize = cohortWithMany.getStudents().size();
        Student casey = new Student(2, "Casey F");
        casey.addGrade(90);
        casey.addGrade(100);
        casey.addGrade(80);
        cohortWithMany.addStudent(casey);
        List <Student> students = cohortWithMany.getStudents();
        assertEquals(startSize + 1, students.size());
        assertEquals("Casey F", students.get(2).getName());
    }

    @Test
    public void testFindStudentsById() {
        Student student = null;
        try {
            student = cohortWithMany.findStudentById(2);
            assertEquals("Trant B", student.getName());
            student = cohortWithMany.findStudentById(47);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("not found"));
        }
    }

}