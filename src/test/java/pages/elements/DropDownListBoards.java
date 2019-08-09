package pages.elements;

import Framework.PageController;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.PageBoard;
import pages.PageMain;
import pages.PageSearchPhotoResult;
import pages.minipages.MiniPageCreateBoard;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class DropDownListBoards
{
    public SelenideElement buttonOpen = $(By.xpath("//li[@id='open_board']/a"));
    public SelenideElement buttonCreateBoard = $(By.className("create-board-link"));
    public By boards = By.xpath("//span[@class='board-title']");

    public SelenideElement buttonGoToBoard = $(By.xpath("//a[@class='button open-board']"));

    public MiniPageCreateBoard goToCreateBoard()
    {
        buttonOpen.click();
        buttonCreateBoard.click();
        return PageController.getPage(MiniPageCreateBoard.class);
    }

    public boolean isBoardExist(String name)
    {
        buttonOpen.click();

        try
        {
            List<SelenideElement> boards = $$(this.boards).shouldBe(CollectionCondition.sizeGreaterThan(0));
            return boards.stream().anyMatch(it -> it.text().equals(name));
        }
        catch (Throwable t)
        {
            return false;
        }
    }

    public PageBoard goToPageBoard(String name)
    {
        buttonOpen.click();
        List<SelenideElement> boards = $$(this.boards).shouldBe(CollectionCondition.sizeGreaterThan(0));

        boards.stream().filter(it -> it.text().equals(name)).findFirst().get().click();
        if(PageController.isCurrentPage(PageSearchPhotoResult.class))//If present board minibar
        {
            buttonGoToBoard.shouldBe(Condition.visible);
            buttonGoToBoard.click();
        }
        return PageController.getPage(PageBoard.class);
    }
}
