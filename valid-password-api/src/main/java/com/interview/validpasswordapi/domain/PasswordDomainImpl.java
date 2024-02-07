package com.interview.validpasswordapi.domain;

import com.interview.validpasswordapi.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.DataOutput;

@Service
public class PasswordDomainImpl implements PasswordDomain{

    @Value("${password-rule.validation.size}")
    private int passwordSize;
    @Override
    public boolean validatePassword(String password) throws InvalidPasswordException {
        // Lógica de validação da senha
        if (password == null || password.length() < passwordSize) {
            throw new InvalidPasswordException("Senha contem menos de 8 caracteres");
        }

        return true;  // Senha válida
    }
}
