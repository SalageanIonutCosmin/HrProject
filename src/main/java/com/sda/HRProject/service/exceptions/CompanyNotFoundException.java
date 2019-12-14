package com.sda.HRProject.service.exceptions;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String msg) {
        super(msg);
    }
}
