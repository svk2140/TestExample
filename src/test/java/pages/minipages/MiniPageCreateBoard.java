package pages.minipages;

import Framework.PageController;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.PageMain;

import static com.codeborne.selenide.Selenide.$;

public class MiniPageCreateBoard
{
    SelenideElement buttonCreate = $(By.xpath("//div[contains(@ng-class, 'for-first-board')]//a[text()='Create']"));
    SelenideElement fieldName = $(By.xpath("//div[contains(@ng-class, 'for-first-board')]//input[@name='boardname']"));

    public PageMain createBoard(String name)
    {
        fieldName.sendKeys(name);
        buttonCreate.click();
        return PageController.getPage(PageMain.class);
    }
}
