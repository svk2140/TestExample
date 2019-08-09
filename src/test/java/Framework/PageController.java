package Framework;

import com.codeborne.selenide.Selenide;

import java.util.HashMap;

public class PageController
{
    private static HashMap<Class, Object> pagesHash = new HashMap();
    private static Object currentPage = null;

    public static <T> T getPage(Class<T> page)
    {
        if(pagesHash.containsKey(page))
        {
            currentPage = (T) pagesHash.get(page);
        }
        else
        {
            Object pageObject = null;
            try
            {
                pageObject = page.newInstance();
            }
            catch (Throwable t)
            {
                t.printStackTrace();
            }
            pagesHash.put(page, pageObject);
            currentPage = (T) pagesHash.get(page);
        }

        return (T) currentPage;
    }

    public static boolean isCurrentPage(Class page)
    {
        return page.isInstance(currentPage);
    }
}
