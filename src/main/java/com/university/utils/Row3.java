package com.university.utils;

import java.util.Arrays;
import java.util.List;

import static com.university.utils.Column3.*;

public class Row3 {
    String subject,
        criteriaType,
        criteriaValue,
        evaluationName;

    List<String> rest;

    public Row3(String row) {
        String[] data = row.split(",");

        subject = data[SUBJECT.ordinal()];
        criteriaType = data[CRITERIA.ordinal()];
        criteriaValue = data[CRITERIA_VALUE.ordinal()];
        evaluationName = data[EVALUATION_NAME.ordinal()];
        rest = Arrays.stream(data).toList().subList(EVALUATION_NAME.ordinal(), data.length);
    }
}
