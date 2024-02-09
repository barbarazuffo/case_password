package com.interview.validpasswordapi.domain;

import com.interview.validpasswordapi.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class PasswordDomainImpl implements PasswordDomain{

    @Value("${password-rule.validation.size}")
    private int passwordSize;
    @Value("${password-rule.validation.characters}")
    private String passwordCharacters;
    @Value("${password-rule.validation.lower}")
    private String passwordLower;
    @Value("${password-rule.validation.lower}")
    private String passwordUpper;
    @Value("${password-rule.validation.lower}")
    private String passwordNumber;
    @Value("${password-rule.validation.space}")
    private String passwordSpace;
    @Value("${password-rule.validation.repeat}")
    private String passwordRepeat;
    @Override
    public boolean validatePassword(String password) throws InvalidPasswordException {
        // Lógica de validação da senha
        if (password == null || password.length() <= passwordSize) {
            throw new InvalidPasswordException("Senha contem menos de 8 caracteres");
        } else if (Pattern.matches(passwordNumber, password)){
            throw new InvalidPasswordException("Senha nâo contem número");
        } else if (Pattern.matches(passwordLower, password)){
            throw new InvalidPasswordException("Senha nâo contem letras minusculas");
        } else if (Pattern.matches(passwordUpper, password)) {
            throw new InvalidPasswordException("Senha nâo contem letras maiusculas");
        } else if (Pattern.matches(passwordCharacters, password)){
            throw new InvalidPasswordException("Senha nâo contem caracteres especiais");
        } else if (password.contains(passwordSpace)){
            throw new InvalidPasswordException("Senha contem espaço");
        } else if (Pattern.matches("^(?!.*(.).*\1).+$",password)){
            throw new InvalidPasswordException("Senha contem caractere repetido");
        }
        return true;  // Senha válida
    }
}