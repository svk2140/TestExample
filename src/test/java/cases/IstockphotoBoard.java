package cases;

import Framework.PageController;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PageBoard;
import pages.PageMain;
import pages.PageSearchPhotoResult;
import pages.PageStockPhoto;

import static org.testng.Assert.*;

public class IstockphotoBoard
{
    String photoId = null;

    @BeforeTest
    public void setUp()
    {
        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
    }

    @Test(priority = 0)
    public void main() throws Throwable
    {
        Selenide.open("https://www.istockphoto.com/");

        PageMain mainPage = PageController.getPage(PageMain.class)
                .goToSignIn()
                .logIn("svk21400@gmail.com", "SuperPass888")
                .dropDownListBoards.goToCreateBoard()
                .createBoard("Board");

        assertTrue(mainPage.dropDownListBoards.isBoardExist("Board"));

        PageSearchPhotoResult pageSearchPhotoResult = mainPage
                .goToPhotos()
                .searchPhotos("Test");

        String photoId = pageSearchPhotoResult.getPhotoId(0);

        PageBoard pageBoard = pageSearchPhotoResult
                .goToAddPhotoToBoard(0)
                .savePhotoToBoard("Board")
                .dropDownListBoards.goToPageBoard("Board");

        assertTrue(pageBoard.isPhotoExist(photoId));
        pageBoard
                .deletePhoto(photoId);
        assertFalse(pageBoard.isPhotoExist(photoId));

        pageBoard
                .deleteBoard();

        assertFalse(pageBoard.boardsList.isBoardExist("Board"));

        pageBoard.leftAccountMenu
                .clickSignOut();
    }

    @Test(priority = 1)
    public void logIn()
    {
        Selenide.open("https://www.istockphoto.com/");

        PageController.getPage(PageMain.class)
                .goToSignIn()
                .logIn("svk21400@gmail.com", "SuperPass888");
    }

    @Test(priority = 2)
    public void createBoard()
    {
        assertTrue(PageController.getPage(PageMain.class)
                .dropDownListBoards.goToCreateBoard()
                .createBoard("Board")
                .dropDownListBoards.isBoardExist("Board"));
    }

    @Test(priority = 3)
    public void goToPhotos()
    {
        PageController.getPage(PageMain.class)
                .goToPhotos();
    }

    @Test(priority = 4)
    public void copyPhotoToBoard() throws InterruptedException
    {
        PageSearchPhotoResult pageSearchPhotoResult = PageController.getPage(PageStockPhoto.class)
                .searchPhotos("Test");

        photoId = pageSearchPhotoResult
                .getPhotoId(0);

        PageBoard pageBoard = pageSearchPhotoResult
                .goToAddPhotoToBoard(0)
                .savePhotoToBoard("Board")
                .dropDownListBoards.goToPageBoard("Board");

        assertTrue(pageBoard.isPhotoExist(photoId));
    }

    @Test(priority = 5)
    public void deletePhotoFromBoard() throws InterruptedException
    {
        assertFalse(PageController.getPage(PageBoard.class)
                .deletePhoto(photoId)
                .isPhotoExist(photoId));
    }

    @Test(priority = 6)
    public void deleteBoard() throws InterruptedException
    {
        assertFalse(PageController.getPage(PageBoard.class)
                .deleteBoard()
                .boardsList.isBoardExist("Board"));
    }

    @Test(priority = 7)
    public void logout() throws InterruptedException
    {
        PageController.getPage(PageBoard.class)
                .leftAccountMenu
                .clickSignOut();
    }

    @AfterTest
    public void tearDown()
    {
        Selenide.close();
    }
}
