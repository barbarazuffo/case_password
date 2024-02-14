package com.interview.validpasswordapi.domain;

import com.interview.validpasswordapi.exception.InvalidPasswordException;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource("classpath:/application.properties")
class PasswordDomainImplTest {

    @InjectMocks
    public PasswordDomainImpl domain = new PasswordDomainImpl(8,"^(?=.*[!@#$%^&*()-+]).*$", "^(?=.*[a-z]).*$", "^(?=.*[A-Z]).*$", "^(?=.*[0-9]).*$", "  ", ".*(.).*\\1.*");

    @Test
    @DisplayName("Senha contem menos de 8 caracteres")
    public void testInvalidPasswordSize() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("aa"));
        assertEquals("Senha contem menos de 8 caracteres", excecao.getMessage());

    }
    @Test
    @DisplayName("Senha nâo contem letras minusculas")
    public void testInvalidPasswordLower() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("ABCD1234!"));

        assertEquals("Senha nâo contem letras minusculas", excecao.getMessage());
    }
    @Test
    @DisplayName("Senha nâo contem letras maiusculas")
    public void testInvalidPasswordUpper() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("ascv1234!"));

        assertEquals("Senha nâo contem letras maiusculas", excecao.getMessage());
    }
    @Test
    @DisplayName("Senha contem espaço")
    public void testInvalidPasswordCharacters() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("Asdf12! R"));

        assertEquals("Senha contem espaço", excecao.getMessage());
    }
    @Test
    @DisplayName("Senha nâo contem número")
    public void testInvalidPasswordNumber() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("abcDEF!@hi"));

        assertEquals("Senha nâo contem número", excecao.getMessage());
    }
    @Test
    @DisplayName("Senha nâo contem caracteres especiais")
    public void testInvalidPasswordSpace() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("123abcABC"));

        assertEquals("Senha nâo contem caracteres especiais", excecao.getMessage());
    }
    @Test
    @DisplayName("Senha contem caractere repetidos")
    public void testInvalidPasswordRepeat() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("aba@21csAs"));

        assertEquals("Senha contem caractere repetido", excecao.getMessage());
    }
}
