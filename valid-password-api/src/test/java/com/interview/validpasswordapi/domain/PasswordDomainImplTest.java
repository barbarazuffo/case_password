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
    @DisplayName("testValidPassword")
    public void testValidPassword() {

        boolean output = domain.validatePassword("aeBFD123!");
        assertTrue(output);

    }
    @Test
    @DisplayName("testInvalidPasswordSize")
    public void testInvalidPasswordSize() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("aa"));
        assertEquals("Senha contem menos de 9 caracteres", excecao.getMessage());

    }
    @Test
    @DisplayName("testInvalidPasswordLower")
    public void testInvalidPasswordLower() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("ABCD1234!"));
        assertEquals("Senha nâo contem letras minusculas", excecao.getMessage());
    }
    @Test
    @DisplayName("testInvalidPasswordUpper")
    public void testInvalidPasswordUpper() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("ascv1234!"));
        assertEquals("Senha nâo contem letras maiusculas", excecao.getMessage());
    }
    @Test
    @DisplayName("testInvalidPasswordCharacters")
    public void testInvalidPasswordCharacters() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("Asdf12! R"));
        assertEquals("Senha contem espaço", excecao.getMessage());
    }
    @Test
    @DisplayName("testInvalidPasswordNumber")
    public void testInvalidPasswordNumber() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("abcDEF!@hi"));
        assertEquals("Senha nâo contem número", excecao.getMessage());
    }
    @Test
    @DisplayName("testInvalidPasswordSpace")
    public void testInvalidPasswordSpace() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("123abcABC"));
        assertEquals("Senha nâo contem caracteres especiais", excecao.getMessage());
    }
    @Test
    @DisplayName("testInvalidPasswordRepeat")
    public void testInvalidPasswordRepeat() {
        InvalidPasswordException excecao = assertThrows(InvalidPasswordException.class, () -> domain.validatePassword("aba@21csAs"));
        assertEquals("Senha contem caractere repetido", excecao.getMessage());
    }
}
