package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BookingSearchSteps {
    WebDriver driver;
    BookingSearchPage bookingSearchPage;
    BookingResultPage bookingResultPage;

    @Before
    public void before_all() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingResultPage = new BookingResultPage(driver);
    }

    @After
    public void after_all() {
        driver.quit();
    }


    @Given("I am on www.booking.com page")
    public void navigateToBookingSearchPage() {
        new BookingSearchPage(driver).open();
    }

    @When("I set city {string} into search bar")
    public void iSetCityLondonIntoSearchBar(String value) {
        bookingSearchPage.setSearchValue(value);
    }

    @And("I click search button")
    public void iClickSearchButton() {
        new BookingSearchPage(driver).clickSearchButton();
    }

    @Then("Should be present {string} with {int}")
    public void shouldBePresentHotel(String value, int index) {
        String result = bookingResultPage.getSearchResultByIndex(index);
        Assert.assertTrue(result.equals(value));
    }

    @Then("Hotel with {int} should have been {string}")
    public void hotelWithIndexShouldHaveBeenRating(int index, String value) {
        String rating = bookingResultPage.getSearchResulRatingByIndex(index);
        Assert.assertTrue(rating.equals(value));
    }
}
