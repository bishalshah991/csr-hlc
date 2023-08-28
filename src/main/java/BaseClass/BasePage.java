package BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class BasePage {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator +"TestData.pdf";
    WebDriverWait wait;

    public void DocumentUpload(By by_locator){
        PageDriver.getCurrentDriver()
                .findElement(by_locator)
                .sendKeys(path);
    }

    public void tab(By by_locator){
        PageDriver.getCurrentDriver()
                .findElement(by_locator).sendKeys(Keys.TAB);
    }
    public void clearTextBox(By by_locator){
        PageDriver.getCurrentDriver()
                .findElement(by_locator)
                .clear();
    }

    public void type(By by_locator, String text){
        PageDriver.getCurrentDriver()
                .findElement(by_locator)
                .sendKeys(text);
    }

    public WebElement getElement(By by_locator){
        return PageDriver.getCurrentDriver()
                .findElement(by_locator);
    }

    public List<WebElement> getEls(By by_locator){
        return PageDriver.getCurrentDriver()
                .findElements(by_locator);

    }
    public void click(By by_locator){
        PageDriver.getCurrentDriver()
                .findElement(by_locator)
                .click();
    }

    public String GetText(By by_locator){
        return PageDriver.getCurrentDriver()
                .findElement(by_locator)
                .getText();
    }

    public void WaitForPresenceOfElement(By byLocator,int timeout){
        wait = new WebDriverWait(PageDriver.getCurrentDriver(),Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    }

    public void ClickElement(By byLocator, By by_locator){
        boolean isDispalyed = true;
        try {
            isDispalyed = PageDriver.getCurrentDriver().findElement(byLocator).isDisplayed();
            System.out.println(PageDriver.getCurrentDriver().findElement(byLocator).getText()+ " is displayed");
            PageDriver.getCurrentDriver().findElement(byLocator).click();
        }
        catch (Exception ex){
            System.out.println("Element is not Found:"+ex);
            PageDriver.getCurrentDriver().findElement(by_locator).click();
        }
    }




    public void ClickElementIsDisplayed(By byLocator){
        boolean isDispalyed = true;
        try {
            isDispalyed = PageDriver.getCurrentDriver().findElement(byLocator).isDisplayed();
            System.out.println(PageDriver.getCurrentDriver().findElement(byLocator).getText()+ " is displayed");
            PageDriver.getCurrentDriver().findElement(byLocator).click();
        }
        catch (Exception ex){
            System.out.println("Element is not Found:"+ex);
        }
    }

    public void CheckElementIsDisplayed(By byLocator, String Text1){
        boolean isDispalyed = true;
        try {
            isDispalyed = PageDriver.getCurrentDriver().findElement(byLocator).isDisplayed();
            System.out.println(PageDriver.getCurrentDriver().findElement(byLocator).getText()+ " is displayed");
            PageDriver.getCurrentDriver().findElement(byLocator).sendKeys(Text1);
        }
        catch (Exception ex){
            System.out.println("Element is not Found:"+ex);
        }

    }

    public static synchronized boolean verifyElementPresent(By byLocator, String Text1, By by_locator, String Text2){
        boolean isDispalyed = true;
        try {
            isDispalyed = PageDriver.getCurrentDriver().findElement(byLocator).isDisplayed();
            System.out.println(PageDriver.getCurrentDriver().findElement(byLocator).getText()+ " is displayed");
            PageDriver.getCurrentDriver().findElement(byLocator).sendKeys(Text1);
        }
        catch(Exception ex) {
            System.out.println("Element is not Found:"+ex);
            PageDriver.getCurrentDriver().findElement(by_locator).sendKeys(Text2);
        }

        return isDispalyed;
    }
}
