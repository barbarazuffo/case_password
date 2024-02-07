package com.interview.validpasswordapi.domain;

public interface PasswordDomain {
    boolean validatePassword(String password) throws RuntimeException;

}
