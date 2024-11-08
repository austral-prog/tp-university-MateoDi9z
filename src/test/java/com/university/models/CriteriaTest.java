//package com.university.models;
//
//import com.university.models.Course.Evaluation.*;
//import com.university.models.Course.Exercise;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class CriteriaTest {
//    private Criteria criteria;
//    private WrittenExam writtenExam;
//    private OralExam oralExam;
//    private PracticalWork practicalWork;
//    private FinalPracticalWork finalPracticalWork;
//
//    @BeforeEach
//    void setUp() {
//        // Crear instancias concretas de cada tipo de Evaluation para pruebas
//        writtenExam = new WrittenExam("Midterm Written Exam");
//        oralExam = new OralExam("Oral Exam");
//        practicalWork = new PracticalWork("Lab Practical Work");
//        finalPracticalWork = new FinalPracticalWork("Final Project");
//    }
//
//    @Test
//    void testWrittenExamCriteria() {
//        criteria = new Criteria("Math", Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, 85.5f, writtenExam);
//        assertEquals("Math", criteria.getSubject());
//        assertEquals(Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, criteria.getCriteria());
//        assertEquals(85.5f, criteria.getCriteriaValue());
//        assertEquals(writtenExam, criteria.getEvaluation());
//    }
//
//    @Test
//    void testOralExamCriteria() {
//        criteria = new Criteria("Physics", Criteria.CriteriaType.MAX_ABOVE_VALUE, 90.0f, oralExam);
//        assertEquals("Physics", criteria.getSubject());
//        assertEquals(Criteria.CriteriaType.MAX_ABOVE_VALUE, criteria.getCriteria());
//        assertEquals(90.0f, criteria.getCriteriaValue());
//        assertEquals(oralExam, criteria.getEvaluation());
//    }
//
//    @Test
//    void testPracticalWorkCriteria() {
//        criteria = new Criteria("Chemistry", Criteria.CriteriaType.MIN_ABOVE_VALUE, 75.0f, practicalWork);
//        assertEquals("Chemistry", criteria.getSubject());
//        assertEquals(Criteria.CriteriaType.MIN_ABOVE_VALUE, criteria.getCriteria());
//        assertEquals(75.0f, criteria.getCriteriaValue());
//        assertEquals(practicalWork, criteria.getEvaluation());
//    }
//
//    @Test
//    void testFinalPracticalWorkCriteria() {
//        criteria = new Criteria("Biology", Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, 88.0f, finalPracticalWork);
//        assertEquals("Biology", criteria.getSubject());
//        assertEquals(Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, criteria.getCriteria());
//        assertEquals(88.0f, criteria.getCriteriaValue());
//        assertEquals(finalPracticalWork, criteria.getEvaluation());
//    }
//
//    @Test
//    void testSetAndGetId() {
//        criteria = new Criteria("Math", Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, 85.5f, writtenExam);
//        criteria.setId(10);
//        assertEquals(10, criteria.getId());
//    }
//
//    @Test
//    void testOralExamGradeCalculation() {
//        oralExam.addExercise(new Exercise("Oral Question 1", 85));
//        criteria = new Criteria("Physics", Criteria.CriteriaType.MIN_ABOVE_VALUE, 90.0f, oralExam);
//        assertEquals(85, oralExam.getGrade());
//    }
//
//    @Test
//    void testPracticalWorkGradeCalculation() {
//        practicalWork.addExercise(new Exercise("Lab 1", 70));
//        practicalWork.addExercise(new Exercise("Lab 2", 80));
//        criteria = new Criteria("Chemistry", Criteria.CriteriaType.MAX_ABOVE_VALUE, 75.0f, practicalWork);
//        assertEquals(80, practicalWork.getGrade());
//    }
//
//    @Test
//    void testFinalPracticalWorkGradeCalculation() {
//        finalPracticalWork.addExercise(new Exercise("Project Part 1", 60));
//        finalPracticalWork.addExercise(new Exercise("Project Part 2", 70));
//        criteria = new Criteria("Biology", Criteria.CriteriaType.AVERAGE_ABOVE_VALUE, 88.0f, finalPracticalWork);
//        assertEquals(130, finalPracticalWork.getGrade());
//    }
//}
