package pages;

import Framework.PageController;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class PageStockPhoto
{
    public SelenideElement fieldSearch = $(By.xpath("//input[@class='non-default phrase']"));

    public PageSearchPhotoResult searchPhotos(String request)
    {
        fieldSearch.setValue(request).pressEnter();
        return PageController.getPage(PageSearchPhotoResult.class);
    }
}
