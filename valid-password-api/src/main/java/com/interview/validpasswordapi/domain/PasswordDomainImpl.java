package com.interview.validpasswordapi.domain;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.interview.validpasswordapi.exception.InvalidPasswordException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class PasswordDomainImpl implements PasswordDomain{
//    public PasswordDomainImpl(@Value("${password-rule.validation.size}")int passwordSize,@Value("${password-rule.validation.characters}") String passwordCharacters, @Value("${password-rule.validation.lower}")String passwordLower,@Value("${password-rule.validation.upper}") String passwordUpper,@Value("${password-rule.validation.number}") String passwordNumber,@Value("${password-rule.validation.space}") String passwordSpace,@Value("${password-rule.validation.repeat}") String passwordRepeat) {
//        this.passwordSize = passwordSize;
//        this.passwordCharacters = passwordCharacters;
//        this.passwordLower = passwordLower;
//        this.passwordUpper = passwordUpper;
//        this.passwordNumber = passwordNumber;
//        this.passwordSpace = passwordSpace;
//        this.passwordRepeat = passwordRepeat;
//    }

    @Value("${password-rule.validation.size}")
    private int passwordSize;
    @Value("${password-rule.validation.characters}")
    private String passwordCharacters;
    @Value("${password-rule.validation.lower}")
    private String passwordLower;
    @Value("${password-rule.validation.upper}")
    private String passwordUpper;
    @Value("${password-rule.validation.number}")
    private String passwordNumber;
    @Value("${password-rule.validation.space}")
    private String passwordSpace;
    @Value("${password-rule.validation.repeat}")
    private String passwordRepeat;
    @Override
    public boolean validatePassword(String password) throws InvalidPasswordException {

        if (password == null || password.length() <= passwordSize) {
            throw new InvalidPasswordException("Senha contem menos de 8 caracteres");
        } else if (!Pattern.matches(passwordNumber, password)){
            throw new InvalidPasswordException("Senha nâo contem número");
        } else if (!Pattern.matches(passwordLower, password)){
            throw new InvalidPasswordException("Senha nâo contem letras minusculas");
        } else if (!Pattern.matches(passwordUpper, password)) {
            throw new InvalidPasswordException("Senha nâo contem letras maiusculas");
        } else if (!Pattern.matches(passwordCharacters, password)){
            throw new InvalidPasswordException("Senha nâo contem caracteres especiais");
        } else if (password.contains(" ")){
            throw new InvalidPasswordException("Senha contem espaço");
        } else if (Pattern.matches(passwordRepeat,password)){
            throw new InvalidPasswordException("Senha contem caractere repetido");
        }
        return true;  // Senha válida
    }
}