package pages.minipages;

import Framework.PageController;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.PageSearchPhotoResult;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MiniPageSelectSaveToBoard
{
    public List<SelenideElement> boards = $$(By.xpath("//li//div[contains(@class, 'board-name')]"));
    public SelenideElement body = $(By.xpath("//div[@class='modalBox save-to-new-board']"));
    public SelenideElement buttonChoiseBoard = $(By.xpath("//*[@class='choose-board']"));

    public PageSearchPhotoResult savePhotoToBoard(String boardName) throws InterruptedException
    {
        body.shouldBe(Condition.visible);
        if(buttonChoiseBoard.exists())
        {
            buttonChoiseBoard.click();
        }
        boards.stream().filter(it -> {
            return it.text().equals(boardName);
        }).findFirst().get().click();
        return PageController.getPage(PageSearchPhotoResult.class);
    }
}
