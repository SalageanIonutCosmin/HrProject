package com.sda.HRProject.service.exceptions;

public class SalaryNotFoundException extends RuntimeException {
    public SalaryNotFoundException(String msg) {
        super(msg);
    }
}
