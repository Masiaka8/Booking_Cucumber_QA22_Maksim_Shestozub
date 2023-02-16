package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingSearchPage extends BasePage{

    private final static By SEARCH_BUTTON_LOCATOR = By.cssSelector("button[type='submit']");
    private final static By SEARCH_INPUT_LOCATOR = By.cssSelector(".ce45093752");
    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }

    public void clickSearchButton(){
        driver.findElement(SEARCH_BUTTON_LOCATOR).click();
    }

    public void setSearchValue(String value){
        driver.findElement(SEARCH_INPUT_LOCATOR).sendKeys(value);
    }
}
