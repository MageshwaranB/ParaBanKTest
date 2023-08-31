package org.Elements;

import org.openqa.selenium.By;

public class LoginUserComponents {

    public By getUserNameTxtBox() {
        return By.id("user-name");
    }

    public By getPasswordTxtBox() {
        return By.id("password");
    }

    public By getLoginButton() {
        return By.id("login-button");
    }
}
