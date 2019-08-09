package pages.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LeftAccountMenu
{
    public SelenideElement buttonSignOut = $(By.xpath("//a[contains(@data-nav, 'nav_Account_SignOut')]"));
    public SelenideElement buttonOpenMeny = $(By.xpath("//nav[@class='actions']//*[text()='Account']"));

    public void clickSignOut()
    {
        buttonOpenMeny.click();
    }
}
