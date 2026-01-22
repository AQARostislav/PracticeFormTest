package otp;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class Loginpass {
    @Test

    public void LoginWithUsernameAndPassword(String username, String password) {
        $("#username").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();
   }
}
