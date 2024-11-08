package com.university.utils.fileStructure;

import com.university.CRUDRepository;
import com.university.common.Entities;
import com.university.controllers.CriteriaController;
import com.university.models.Criteria;

import java.util.Arrays;
import java.util.List;

import static com.university.models.Criteria.getCriteriaType;

public class Input3 extends InputFile {
    public String subject,
        criteriaType,
        criteriaValue;

    public List<String> evaluationNames;

    public enum Columns {
        SUBJECT,
        CRITERIA,
        CRITERIA_VALUE,
        EVALUATION_NAMES,
    }

    public Input3(String row) {
        String[] data = row.split(",");
        if (data.length < 4) return;

        subject = data[Columns.SUBJECT.ordinal()];
        criteriaType = data[Columns.CRITERIA.ordinal()];
        criteriaValue = data[Columns.CRITERIA_VALUE.ordinal()];
        evaluationNames = Arrays.stream(data).toList().subList(Columns.EVALUATION_NAMES.ordinal(), data.length);
    }

    public void register(CRUDRepository<?>[] repos) {
        CRUDRepository<Criteria> criteriaRepo = (CriteriaController) repos[Entities.CRITERIA.ordinal()];

        for (String evaluationName : this.evaluationNames) {
            criteriaRepo.create(new Criteria(
                    this.subject,
                    getCriteriaType(this.criteriaType),
                    Float.parseFloat(this.criteriaValue),
                    evaluationName
            ));
        }
    }
}
