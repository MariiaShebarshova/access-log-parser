//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.List;
//
//public class StudentTest {
//
//    @Test
//    public void testGetGradesReturnsUnmodifiableList() {
//        Student student = new Student("Alice");
//        student.addGrade(5);
//        student.addGrade(4);
//
//        List<Integer> grades = student.getGrades();
//
//        // Проверяем, что можно читать
//        assertEquals(2, grades.size());
//        assertEquals(5, grades.get(0));
//        assertEquals(4, grades.get(1));
//
//        // Проверяем, что нельзя изменять
//        assertThrows(UnsupportedOperationException.class, () -> {
//            grades.add(3);
//        });
//
//        assertThrows(UnsupportedOperationException.class, () -> {
//            grades.remove(0);
//        });
//
//        assertThrows(UnsupportedOperationException.class, () -> {
//            grades.set(0, 2);
//        });
//    }
//
//    @Test
//    public void testAddGradeValid() {
//        Student student = new Student("Bob");
//        student.addGrade(3);
//        student.addGrade(5);
//
//        List<Integer> grades = student.getGrades();
//        assertEquals(2, grades.size());
//        assertEquals(3, grades.get(0));
//        assertEquals(5, grades.get(1));
//    }
//
//    @Test
//    public void testAddGradeInvalid() {
//        Student student = new Student("Charlie");
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            student.addGrade(1);
//        });
//
//        assertThrows(IllegalArgumentException.class, () -> {
//            student.addGrade(6);
//        });
//    }
//
//    @Test
//    public void testEqualsAndHashCode() {
//        Student s1 = new Student("David");
//        s1.addGrade(4);
//        s1.addGrade(5);
//
//        Student s2 = new Student("David");
//        s2.addGrade(4);
//        s2.addGrade(5);
//
//        assertEquals(s1, s2);
//        assertEquals(s1.hashCode(), s2.hashCode());
//    }
//
//    @Test
//    public void testToString() {
//        Student student = new Student("Eve");
//        student.addGrade(5);
//        student.addGrade(2);
//
//        String expected = "Student{name=Eve, marks=[5, 2]}";
//        assertEquals(expected, student.toString());
//    }
//
//    @Test
//    public void testSetName() {
//        Student student = new Student("Frank");
//        student.setName("Fred");
//        assertEquals("Fred", student.getName());
//    }
//}
