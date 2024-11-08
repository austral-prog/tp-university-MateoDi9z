package com.university.utils.fileStructure;

import com.university.CRUDRepository;
import com.university.common.Entities;
import com.university.controllers.CourseController;
import com.university.controllers.ExerciseController;
import com.university.controllers.StudentController;
import com.university.models.Course.Course;
import com.university.models.Course.Evaluation.*;
import com.university.models.Course.Evaluation.Evaluation.EvaluationType;
import com.university.models.Course.Exercise;
import com.university.models.Student;

public class Input2 extends InputFile {
    public String studentName,
                    subject,
                    evaluationType,
                    evaluationName,
                    exerciseName;

    public Integer grade;

    public enum Columns {
        STUDENT,
        SUBJECT,
        EVALUATION_TYPE,
        EVALUATION_NAME,
        EXERCISE_NAME,
        GRADE,
    }

    public Input2(String row) {
        String[] data = row.split(",");

        studentName = data[Columns.STUDENT.ordinal()];
        subject = data[Columns.SUBJECT.ordinal()];
        evaluationType = data[Columns.EVALUATION_TYPE.ordinal()];
        evaluationName = data[Columns.EVALUATION_NAME.ordinal()];
        exerciseName = data[Columns.EXERCISE_NAME.ordinal()];
        grade = Integer.parseInt(data[Columns.GRADE.ordinal()]);
    }

    /**
     * (Student,Subject,Evaluation_Type,Evaluation_Name,Exercise_Name,Grade)
     * @param repos Controllers
     */
    public void register(CRUDRepository<?>[] repos) {
            CRUDRepository<Student> studentRepo = (StudentController) repos[Entities.STUDENT.ordinal()];
            CRUDRepository<Course> courseRepo = (CourseController) repos[Entities.COURSE.ordinal()];
            CRUDRepository<Exercise> exerciseRepo = (ExerciseController) repos[Entities.EXERCISE.ordinal()];

            int studentId = studentRepo.create(new Student(this.studentName));
            int courseId = courseRepo.create(new Course(this.subject, studentRepo.read(studentId)));
            Course course = courseRepo.read(courseId);

            boolean found = false;
            Evaluation evaluation;

            switch (getEvaluationType()) {
                case ORAL_EXAM -> evaluation = new OralExam(evaluationName);
                case FINAL_PRACTICAL_WORK -> evaluation = new FinalPracticalWork(evaluationName);
                case PRACTICAL_WORK -> evaluation = new PracticalWork(evaluationName);
                case WRITTEN_EXAM -> evaluation = new WrittenExam(evaluationName);
                default -> {
                    return;
                }
            }

            if (course.getSubject() == null) return;

            for (Evaluation e : course.getEvaluations()) {
                if (e.equals(evaluation) && course.getSubject().equals(this.subject)) {
                    evaluation = e;
                    found = true;
                    break;
                }
            }

            int exerciseId = exerciseRepo.create(new Exercise(this.exerciseName, this.grade));
            evaluation.addExercise(exerciseRepo.read(exerciseId));

            if (found) return;
            course.addEvaluation(evaluation);
    }

    public EvaluationType getEvaluationType() {
        return EvaluationType.valueOf(evaluationType);
    }
}
