package org.Elements;

import org.openqa.selenium.By;

public class LoginUserComponents {

    public By getUserNameTxtBox(){
        return By.name("username");
    }
    public By getPasswordTxtBox(){
        return By.name("password");
    }
   public By getLoginButton(){
        return By.xpath("//input[@value='Log In']");
   }
   public By getForgotPasswordLink(){
        return By.partialLinkText("Forgot login");
   }
   public By getRegisterLink(){
        return By.linkText("Register");
   }
}
