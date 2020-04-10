
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class StudentTest {
    Student studentOne;

    @Before
    public void setUP() {
        studentOne = new Student("Vivian");
        studentOne.addGrade(100);
        studentOne.addGrade(95);
        studentOne.addGrade(90);
        studentOne.addGrade(93);
        studentOne.addGrade(87);
    }

    @Test
    public void testGetId() {
        assertNotNull(studentOne.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Vivian", studentOne.getName());
    }

    @Test
    public void testAddGrade() {
        Student s = new Student("New");
        s.addGrade(98);
        assertEquals(98, s.getGradeAverage());
    }

    @Test
    public void testGetGradeAverage() {
        Student s = new Student("New");
        s.addGrade(100);
        s.addGrade(90);
        s.addGrade(80);
        s.addGrade(70);
        assertEquals(85, s.getGradeAverage());
    }

    @Test
    public void testIfConstructorWorked() {
        Student student = new Student();
        assertNotNull(student);
    }

    @Test
    public void testCountIsWorking() {
        long expected = Student.getCount();
        Student s2 = new Student();
        Student s3 = new Student();
        expected += 2;
        assertEquals(expected, Student.getCount());
    }

    @Test
    public void testIfIdIsInitailized() {
        long count = Student.getCount();
        Student s1 = new Student();
        assertEquals("Test ID 1", count + 1, s1.getId());
    }

    @Test
    public void testIfIStudentNameIsSetByConstructor() {
        long count = Student.getCount();
        String expected = "Trant";
        Student student = new Student(expected);
        assertEquals("Test name access", expected, student.getName());
    }

    @Test
    public void testSettingAndGettingTheName() {
        String expected = "Trant";
        Student student = new Student();
        student.setName(expected);
        assertEquals("Test name get & set", expected, student.getName());
    }

    @Test
    public void testAddingGradesAndAveraging() {
        Student student = new Student("Casey");
        student.addGrade(100);
        student.addGrade(95);
        student.addGrade(90);
        int expected = 95;
        assertEquals("Testing Grade Average ", 95, student.getGradeAverage());
    }

    @Test
    public void testGetGrade() {
        int expected = 90;
        int actual = studentOne.getGrade(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteGrade() {
        studentOne.deleteGrade(2);
        int expected = 93;
        int actual = studentOne.getGrade(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateGrade() {
        int expected = 97;
        studentOne.updateGrade(2, expected);
        int actual = studentOne.getGrade(2);
        assertEquals(expected, actual);
    }
}
