package com.interview.validpasswordapi.service;

public interface PasswordService {
        boolean passwordValidation(String password) throws RuntimeException;
}
