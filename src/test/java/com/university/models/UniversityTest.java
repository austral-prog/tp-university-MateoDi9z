//package com.university.models;
//
//import java.util.ArrayList;
//import java.util.List;
//
//// Models
//import com.university.models.Course.*;
//import com.university.models.Course.Evaluation.Evaluation;
//
//import static com.university.models.Course.Evaluation.Evaluation.EvaluationType.FINAL_PRACTICAL_WORK;
//
//// Testing
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class UniversityTest {
//    private University university;
//    private University university2;
//
//    @BeforeEach
//    public void setUp() throws Exception {
//        this.university = new University("Universidad Austral");
//        this.university2 = new University("Universidad 2");
//    }
//
//    @Test
//    public void testUniversityAttr() {
//        assertEquals("Universidad Austral", university.getName());
//        assertEquals(new ArrayList<Student>(), university.getStudents());
//        assertEquals(new ArrayList<Professor>(), university.getProfessors());
//        assertEquals(new ArrayList<Course>(), university.getCourses());
//    }
//
////    @Test
////    public void testRegisterRow1() {
////        String studentName = "Liam Magenta",
////                profName = "Prof. Hank",
////                classroom = "562";
////        String example = classroom+",Mathematics,"+studentName+",liam.magenta@email.com,"+profName;
////
////        this.university.registerRow1(example);
////
////        assertEquals(1, university.getStudents().size());
////        assertEquals(1, university.getProfessors().size());
////        assertEquals(1, university.getCourses().size());
////
////        assertEquals(studentName, university.getStudents().getFirst().getName());
////        assertEquals(profName, university.getProfessors().getFirst().getName());
////        assertEquals(Integer.parseInt(classroom), university.getCourses().getFirst().getClassroom());
////    }
//
//    @Test
//    public void testRegisterRow2() {
//        String studentName = "Alice Blue",
//                subject = "Geography",
//                evaluationName = "TP3",
//                exercise = "Ej10";
//
//        Integer grade = 5;
//
//        String example = "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej10,5";
//
//        this.university.registerRow2(example);
//
//        Course course = university.getCourses().getFirst();
//        Evaluation evaluation = course.getEvaluations().getFirst();
//        Exercise exercise1 = evaluation.getExercises().getFirst();
//
//        assertEquals(studentName, university.getStudents().getFirst().getName());
//        assertEquals(subject, course.getSubject());
//        assertEquals(evaluationName, evaluation.getName());
//        assertEquals(FINAL_PRACTICAL_WORK, evaluation.getType());
//        assertEquals(exercise, exercise1.getName());
//        assertEquals(grade, exercise1.getGrade());
//    }
//
//    @Test
//    public void testGradeCalculation() {
//        List<String> input = List.of("Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej10,5",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej9,1",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej5,1",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej4,6",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej7,5",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej1,10",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej8,2",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej3,8",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej2,3",
//                "Alice Blue,Geography,FINAL_PRACTICAL_WORK,TP3,Ej6,9");
//
//        for (String row : input) {
//            university2.registerRow2(row);
//        }
//        Course course = university2.getCourse("Geography", university2.getStudent("Alice Blue"));
//
//        String expected = "Geography,TP3,Alice Blue,5.0";
//        String result = course.Serialize("Alice Blue").getFirst();
//
//        assertEquals(expected, result);
//    }
//
////    @Test
////    public void testGetStudentsAsString() {
////
////        this.university.registerRow1("438,Psychology,Paul Black,paul.black@email.com,Prof. Jack");
////        this.university.registerRow1("288,Anthropology,Charlie Beige,charlie.beige@student.org,Prof. Rita");
////        this.university.registerRow1("339,Economics,Bob Cyan,bob.cyan@student.org,Prof. Dana");
////
////        List<String> result = this.university.getStudentsAsString();
////
////        assertEquals("Paul Black,1", result.getLast());
////    }
////
////    @Test
////    public void testGetGradesList() {
////        this.university2.registerRow2("Paul Beige,Anatomy,WRITTEN_EXAM,Segundo Parcial,Ej2,7");
////        this.university2.registerRow2("Paul Beige,Anatomy,WRITTEN_EXAM,Segundo Parcial,Ej1,5");
////        this.university2.registerRow2("Rita Teal,English,WRITTEN_EXAM,Primer Parcial,Ej16,0");
////        this.university2.registerRow2("Mona Azure,Physics,WRITTEN_EXAM,Examen Final,Ej8,1");
////        this.university2.registerRow2("Paul Beige,Biology,WRITTEN_EXAM,Examen Final,Ej9,9");
////
////        List<String> result = this.university2.getGradesList();
////        assertEquals("Anatomy,Segundo Parcial,Paul Beige,6.0", result.getFirst());
////    }
//}
