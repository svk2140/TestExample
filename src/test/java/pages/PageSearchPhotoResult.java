package pages;

import Framework.PageController;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pages.elements.DropDownListBoards;
import pages.minipages.MiniPageSelectSaveToBoard;

import java.nio.IntBuffer;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PageSearchPhotoResult
{
    public List<SelenideElement> photos = $$(By.xpath("//section[@class='image-section']"));
    public By actionsFromPhoto = By.className("actions-overlay");
    public By photoId = By.xpath("./a");

    public SelenideElement toolbox = $(By.className("action-toolbox"));

    public DropDownListBoards dropDownListBoards = new DropDownListBoards();

    public MiniPageSelectSaveToBoard goToAddPhotoToBoard(int position) throws InterruptedException
    {
        photos.get(position)
                .hover()
                .$(actionsFromPhoto)
                .hover();

        toolbox.click();
        return PageController.getPage(MiniPageSelectSaveToBoard.class);
    }

    public String getPhotoId(int position)
    {
        return photos.get(position)
                .$(photoId)
                .getAttribute("data-asset-id");
    }
}
