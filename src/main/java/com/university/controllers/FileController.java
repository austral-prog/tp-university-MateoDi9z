package com.university.controllers;

import com.university.CRUDRepository;
import com.university.common.Entities;
import com.university.models.Student;
import com.university.utils.FileIO;
import com.university.utils.fileStructure.Input1;
import com.university.utils.fileStructure.Input2;
import com.university.utils.fileStructure.Input3;

import java.util.List;

import static com.university.controllers.StudentController.getStudentsAsString;

public class FileController {
    CRUDRepository<?>[] repos = new CRUDRepository<?>[5];

    public FileController() {
        repos[Entities.STUDENT.ordinal()] = new StudentController();
        repos[Entities.PROFESSOR.ordinal()] = new ProfessorController();
        repos[Entities.COURSE.ordinal()] = new CourseController();
        repos[Entities.EXERCISE.ordinal()] = new ExerciseController();
        repos[Entities.CRITERIA.ordinal()] = new CriteriaController();
    }

    public CRUDRepository<?>[] getRepos() { return repos; }

    // ANDA!
    public static void Submit1(CRUDRepository<?>[] repos) {
        FileIO fileIo = new FileIO(1);

        CRUDRepository<Student> studentRepo = (StudentController) repos[Entities.STUDENT.ordinal()];
        List<String> result = fileIo.readInputFile();

        result.removeFirst();
        for (String x : result) {
            new Input1(x).register(repos);
        }

        List<String> studentList = getStudentsAsString(studentRepo.readAll());
        studentList.addFirst("Student_Name,Course_Count");
        fileIo.writeOutputList(studentList);
    }

    // Valores raros...
    public static void Submit2(CRUDRepository<?>[] repos) {
        FileIO fileIo = new FileIO(2);

        List<String> result = fileIo.readInputFile();

        result.removeFirst();
        for (String x : result) {
            new Input2(x).register(repos);
        }

        List<String> studentList = ((StudentController) repos[Entities.STUDENT.ordinal()]).getGradesList();
        
        studentList.addFirst("Subject_Name,Evaluation_Name,Student_Name,Grade");
        fileIo.writeOutputList(studentList);
    }

    public static void Submit3(CRUDRepository<?>[] repos) {
        System.out.println("-- WORKING WITH SUBMIT 3 --");
        FileIO fileIO2 = new FileIO(2);
        FileIO fileIO3 = new FileIO(3);
        
        List<String> result = fileIO2.readInputFile();
        result.removeFirst();
        for (String x : result) {
            new Input2(x).register(repos);
        }

        List<String> result2 = fileIO3.readInputFile();
        result2.removeFirst();

        for (String x : result2) {
            Input3 input3 = new Input3(x);
            if (input3.subject == null) continue;
            input3.register(repos);
        }

        List<String> resultList = ((StudentController) repos[Entities.STUDENT.ordinal()])
                .getCareerHistory(((CriteriaController) repos[Entities.CRITERIA.ordinal()]));
        resultList.addFirst("Subject_Name,Student_Name,State");

        fileIO3.writeOutputList(resultList);
    }
}
