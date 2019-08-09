package pages;

import Framework.PageController;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.elements.DropDownListBoards;
import pages.elements.LeftAccountMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class PageMain
{
    public DropDownListBoards dropDownListBoards = new DropDownListBoards();

    public SelenideElement buttonSignIn = $(By.xpath("//a[@class='account']"));
    public SelenideElement buttonGoToPhotos = $(By.xpath("//ul[@class='nav-root']//a[text()='Photos']"));

    public PageSignIn goToSignIn()
    {
        buttonSignIn.click();
        return PageController.getPage(PageSignIn.class);
    }

    public PageStockPhoto goToPhotos()
    {
        buttonGoToPhotos.click();
        return PageController.getPage(PageStockPhoto.class);
    }
}
