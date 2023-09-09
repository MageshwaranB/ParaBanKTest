package org.Elements;

import org.SeleniumUtitlies.SeleniumMethods;
import org.openqa.selenium.By;

public class LoginUserComponents {
    SeleniumMethods seleniumMethods;
    LoginUserComponents loginUserComponents;
    public LoginUserComponents(){
    }
    public SeleniumMethods getUserNameTxtBox() {
        return new SeleniumMethods(By.id("user-name"));
    }

    public SeleniumMethods getPasswordTxtBox() {
        return new SeleniumMethods(By.id("password"));
    }

    public SeleniumMethods getLoginButton() {
         return new SeleniumMethods(By.id("login-button"));
    }
}
