package com.mycompany.chatapp_part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserNameValid() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameInvalid() {
        Login login = new Login();
        assertFalse(login.checkUserName("kyleusername"));
    }

    @Test
    public void testCheckPasswordComplexityValid() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch3sse&sea21!"));
    }

    @Test
    public void testCheckPasswordComplexityInvalid() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testLoginUserSuccess() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch3sse&sea21!", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch3sse&sea21!"));
    }

    @Test
    public void testLoginUserFailure() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch3sse&sea21!", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "WrongPassword!"));
    }
}