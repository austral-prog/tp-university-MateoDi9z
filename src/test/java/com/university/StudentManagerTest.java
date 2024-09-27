/*
public class StudentManagerTest {
    private StudentManager studentManager;

    @BeforeEach
    public void setUp() throws Exception {
        this.studentManager = new StudentManager();
    }

    @Test
    public void testAddAndGetStudent() {
        studentManager.addStudent(new Student("Mateo", "mateo@gmail"));
        List<Student> students = studentManager.getStudentList();

        assertNotNull(students);
        assertEquals(1, students.size());
        assertEquals("Mateo", students.getFirst().getName());
        assertEquals("mateo@gmail", students.getFirst().getEmail());
    }

    @Test
    public void testGetStudentsSortedAlphabetically() {
        studentManager.addStudent(new Student("b", "bbb@gmail"));
        studentManager.addStudent(new Student("z", "zzz@gmail"));
        studentManager.addStudent(new Student("a", "aaa@gmail"));

        assertEquals("a, 0", studentManager.getStudentListAsString().getFirst());
        assertEquals("b, 0", studentManager.getStudentListAsString().get(1));
        assertEquals("z, 0", studentManager.getStudentListAsString().getLast());
    }
}
*/