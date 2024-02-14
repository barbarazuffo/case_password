package com.interview.validpasswordapi.service;

import com.interview.validpasswordapi.domain.PasswordDomainImpl;
import com.interview.validpasswordapi.exception.InvalidPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private final PasswordDomainImpl domain;

    public PasswordServiceImpl(PasswordDomainImpl domain) {
        this.domain = domain;
    }

    @Override
    public boolean passwordValidation(String password) throws InvalidPasswordException {
        log.info("Iniciando validação");
        return domain.validatePassword(password);
    }
}