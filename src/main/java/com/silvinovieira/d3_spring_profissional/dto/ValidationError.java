package com.silvinovieira.d3_spring_profissional.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    List<FieldMessage> fieldMessages = new ArrayList<>();

    public ValidationError() {}

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldMessages() {
        return fieldMessages;
    }

    public void addFieldMessage(String fieldName, String message) {
        fieldMessages.add(new FieldMessage(fieldName, message));
    }
}
