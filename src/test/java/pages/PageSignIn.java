package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageSignIn
{
    public SelenideElement fieldLogin = $(By.id("new_session_username"));
    public SelenideElement fieldPassword = $(By.id("new_session_password"));
    public SelenideElement buttonSignIn = $(By.id("sign_in"));

    public PageMain logIn(String login, String password)
    {
        fieldLogin.sendKeys(login);
        fieldPassword.sendKeys(password);
        buttonSignIn.click();
        return page(PageMain.class);
    }
}
