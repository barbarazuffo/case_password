package com.interview.validpasswordapi.service;

import com.interview.validpasswordapi.domain.PasswordDomainImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private final PasswordDomainImpl passwordDomain;

    public PasswordServiceImpl(PasswordDomainImpl passwordDomain) {
        this.passwordDomain = passwordDomain;
    }

    @Override
    public boolean passwordValidation(String password) throws RuntimeException {
        log.info("Iniciando validação");
        return passwordDomain.validatePassword(password);
    }
}