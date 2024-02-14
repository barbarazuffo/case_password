package com.interview.validpasswordapi.controller;

import com.interview.validpasswordapi.model.Input;
import com.interview.validpasswordapi.model.Output;
import com.interview.validpasswordapi.service.PasswordServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
class PasswordControllerTest {
    @InjectMocks
    public PasswordController controller;
    @Mock
    PasswordServiceImpl service;
    @Mock
    ResponseEntity<Output> output;
    @Test
    @DisplayName("testPasswordValidationTrueOk")
    public void testPasswordValidationTrueOk (){
        Input input = new Input("AbTp9!fok");
        ResponseEntity<Output> output = controller.passwordValidation(input);
        assertEquals("200 OK",output.getStatusCode().toString());
        assertEquals("Senha Compativel",output.getBody().getMessage());
    }
    @Test
    @DisplayName("testPasswordValidationFalseOK")
    public void testPasswordValidationFalseOK (){
        Input input = new Input("AbcdE!23d");
        output = controller.passwordValidation(input);
        assertEquals("200 OK",output.getStatusCode().toString());
    }
 }