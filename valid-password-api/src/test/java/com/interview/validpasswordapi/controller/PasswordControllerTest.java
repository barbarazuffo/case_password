package com.interview.validpasswordapi.controller;

import com.interview.validpasswordapi.model.Input;
import com.interview.validpasswordapi.model.Output;
import com.interview.validpasswordapi.service.PasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PasswordControllerTest {
    @InjectMocks
    public PasswordController controller;
    @Mock
    PasswordServiceImpl service;
    @Mock
    ResponseEntity<Output> output;
    @Test
    public void testPasswordValidationTrueOk (){
        Input input = new Input("AbTp9!fok");
        ResponseEntity<Output> output = controller.passwordValidation(input);
        assertEquals("200 OK",output.getStatusCode().toString());
        assertEquals("Senha Compativel",output.getBody().getMessage());
    }
    @Test
    public void testePasswordValidationFalseOK (){
        Input input = new Input("AbcdE!23d");
        output = controller.passwordValidation(input);
        assertEquals("200 OK",output.getStatusCode().toString());
    }
}