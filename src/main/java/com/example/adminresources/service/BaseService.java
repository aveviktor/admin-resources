package com.example.adminresources.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
public class BaseService {

    public final String ERROR = "error";
    public final String SUCCESS = "success";

    public static final String ADMIN_PAGE = "adminPage";

    public String getErrors(BindingResult result) {
        if (result.getAllErrors().isEmpty()) {
            return "unidentified error";
        }
        StringBuilder errorMessage = new StringBuilder();
        for ( ObjectError error : result.getAllErrors()) {
            errorMessage.append(error.getDefaultMessage()).append("; ");
        }
        return errorMessage.toString();
    }
}
