package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookingResultPage extends BasePage{

    private final static By SEARCH_RESULTS_LOCATOR = By.xpath("//div[@data-testid='property-card']//div[@data-testid='title']");
    private final static By SEARCH_RESULTS_RATING_LOCATOR = By.xpath("//div[contains(@aria-label,'Scored')]");

    public BookingResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS_LOCATOR).get(index - 1).getText();
    }

    public String getSearchResulRatingByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS_RATING_LOCATOR).get(index - 1).getText();
    }

}
