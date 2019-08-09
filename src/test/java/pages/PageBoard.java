package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.elements.DropDownListBoards;
import pages.elements.LeftAccountMenu;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class PageBoard
{
    public DropDownListBoards boardsList = new DropDownListBoards();
    public LeftAccountMenu leftAccountMenu = new LeftAccountMenu();

    By photos = By.xpath("//div[@class='board-item-content']/span/parent::*");//Не подразумивает наличие больше чем двух страниц
    By getPhotoIdLabel = By.xpath(".//span[contains(@class, 'asset-id')]");
    By buttonDeletePhoto = By.xpath(".//span[@class='remove']");

    SelenideElement buttonDeleteBoard = $(By.className("delete-board"));
    SelenideElement pager = $(By.xpath("//section[@class='board-pager']//input[@type='number']"));

    public boolean isPhotoExist(String photoId)
    {
        return searchPhoto(photoId) != null;
    }

    public PageBoard deletePhoto(String photoId)
    {
        SelenideElement photo = searchPhoto(photoId).$(buttonDeletePhoto);
        photo.hover().click();
        photo.shouldBe(Condition.not(Condition.exist));
        return this;
    }

    public SelenideElement searchPhoto(String photoId)
    {
        if(isEmpty()) return null;

        for(SelenideElement photo : $$(photos).shouldBe(CollectionCondition.sizeGreaterThan(0)))
        {
            if(photo.$(getPhotoIdLabel).text().equals(photoId)) return photo;
        }

        return null;
    }

    public PageBoard deleteBoard()
    {
        buttonDeleteBoard.click();
        Selenide.confirm();
        return this;
    }

    public boolean isEmpty()
    {
        return !pager.exists();
    }
}
