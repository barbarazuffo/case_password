package com.interview.validpasswordapi.controller;

import com.interview.validpasswordapi.exception.InvalidPasswordException;
import com.interview.validpasswordapi.model.Input;
import com.interview.validpasswordapi.model.Output;
import com.interview.validpasswordapi.service.PasswordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordController {
    @Autowired
    private PasswordServiceImpl service;

    @PostMapping("/validation")
    public ResponseEntity<Output> passwordValidation(@RequestBody Input input) {

        try {
            boolean output = service.passwordValidation(input.getPassword());
            return ResponseEntity.ok(new Output(output,"Sucess"));
        } catch (InvalidPasswordException e) {
            return ResponseEntity.ok(new Output(false, e.getMessage()));
        }
    }
}
