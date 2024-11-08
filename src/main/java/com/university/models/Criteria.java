package com.university.models;

import com.university.Entity;
import com.university.models.Course.Evaluation.Evaluation;

public class Criteria implements Entity {
    private Integer id;
    private String subject;
    private CriteriaType criteria;
    private Float criteriaValue;
    private String evaluationName;

    private static int idCounter = 0;

    public enum CriteriaType {
        AVERAGE_ABOVE_VALUE,
        MAX_ABOVE_VALUE,
        MIN_ABOVE_VALUE,
    }

    public Criteria(String subject, CriteriaType criteria, Float criteriaValue, String evaluation) {
        this.id = ++idCounter;
        this.subject = subject;
        this.criteria = criteria;
        this.criteriaValue = criteriaValue;
        this.evaluationName = evaluation;
    }

    public String getSubject() { return subject; }
    public CriteriaType getCriteria() { return criteria; }
    public Float getCriteriaValue() { return criteriaValue; }
    public String getEvaluation() { return evaluationName; }

    public void setSubject(String subject) { this.subject = subject; }
    public void setCriteria(CriteriaType criteria) { this.criteria = criteria; }
    public void setCriteriaValue(Float criteriaValue) { this.criteriaValue = criteriaValue; }
    public void setEvaluation(String evaluation) { this.evaluationName = evaluation; }

    public static CriteriaType getCriteriaType(String strCriteria) {
        return CriteriaType.valueOf(strCriteria);
    }

    public boolean getApprove(Evaluation evaluation) {
        return switch (criteria) {
            case AVERAGE_ABOVE_VALUE -> evaluation.getAverageGrade() >= criteriaValue;
            case MAX_ABOVE_VALUE -> evaluation.getMaxGrade() >= criteriaValue;
            case MIN_ABOVE_VALUE -> evaluation.getMinGrade() >= criteriaValue;
        };
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Criteria cCriteria)) {
            return false;
        }
        return this.getCriteria().equals(cCriteria.getCriteria()) &&
                this.getSubject().equals(cCriteria.getSubject()) &&
                this.getEvaluation().equals(cCriteria.getEvaluation());
    }

    @Override
    public String toString() {
        return " - %d %s %s";
    }
}
