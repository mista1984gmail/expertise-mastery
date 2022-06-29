package com.godeltech.mastery.expertise.expertisemastery.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionErrorResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String error;
}
