package Steps;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;

import io.cucumber.java.en.*;

public class stepdefinition {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @Before
    public void start() {
        System.out.println("Browser started");
    }

    @BeforeStep
    public void screenshot() {
        System.out.println("Screenshot taken");
    }

    @After
    public void teardown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    @Given("User should start {string}")
    public void user_should_start(String browser) {
        WebDriver localDriver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            localDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            localDriver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new FirefoxDriver();
        }
        driver.set(localDriver);
    }

    @Given("user should open the app using url {string}")
    public void user_should_open_the_app_using_url(String url) {
        getDriver().get(url);
    }

    @When("user enters username {string} by using xpath {string}")
    public void user_enters_username_by_using_xpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @When("user enters password {string} by using xapth {string}")
    public void user_enters_password_by_using_xapth(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Then("user clicks on button using xapth {string}")
    public void user_clicks_on_button_using_xapth(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("user verifies the title {string}")
    public void user_verifies_the_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, getDriver().getTitle());
    }

    @When("user clicks on register user using xpath {string}")
    public void user_clicks_on_register_user_using_xpath(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @When("user re-enters password {string} by using xapth {string}")
    public void user_re_enters_password_by_using_xapth(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @When("user enters fullname {string} by using xapth {string}")
    public void user_enters_fullname_by_using_xapth(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @When("user enters text {string} by using xapth {string}")
    public void user_enters_text_by_using_xapth(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    @Then("user clicks on checkbox using xapth {string}")
    public void user_clicks_on_checkbox_using_xapth(String xpath) {
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("user enter details in registration form")
    public void user_enter_details_in_registration_form(DataTable dataTable) {
        List<Map<String, String>> listdata = dataTable.asMaps();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(listdata.get(0).get("username"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(listdata.get(0).get("password"));
        getDriver().findElement(By.xpath("//input[@name='re_password']")).sendKeys(listdata.get(0).get("re-password"));
        getDriver().findElement(By.xpath("//input[@name='full_name']")).sendKeys(listdata.get(0).get("fullname"));
        getDriver().findElement(By.xpath("//input[@name='email_add']")).sendKeys(listdata.get(0).get("mail"));
    }

    @Then("user enters details in search hotel form")
    public void user_enters_details_in_registration_form(DataTable dataTabletwo) {
        List<Map<String, String>> hoteldata = dataTabletwo.asMaps();
        new Select(getDriver().findElement(By.id("location"))).selectByVisibleText(hoteldata.get(0).get("location"));
        new Select(getDriver().findElement(By.id("hotels"))).selectByVisibleText(hoteldata.get(0).get("hotel"));
        new Select(getDriver().findElement(By.id("room_type"))).selectByVisibleText(hoteldata.get(0).get("room type"));
        new Select(getDriver().findElement(By.id("room_nos"))).selectByVisibleText(hoteldata.get(0).get("no of rooms"));
        
        WebElement checkin = getDriver().findElement(By.id("datepick_in"));
        checkin.clear();
        checkin.sendKeys(hoteldata.get(0).get("checkin date"));

        WebElement checkout = getDriver().findElement(By.id("datepick_out"));
        checkout.clear();
        checkout.sendKeys(hoteldata.get(0).get("check out date"));

        new Select(getDriver().findElement(By.id("adult_room"))).selectByVisibleText(hoteldata.get(0).get("adults"));
        new Select(getDriver().findElement(By.id("child_room"))).selectByVisibleText(hoteldata.get(0).get("children"));
        
        try {
            Thread.sleep(3000); // Just for demo; ideally avoid sleep in real frameworks
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("User submit the form")
    public void user_submit_the_form() {
        getDriver().findElement(By.id("Submit")).click();
    }

    @Then("User verifies the hotel name in select hotel page")
    public void user_verifies_the_hotel_name_in_select_hotel_page(DataTable data) {
        List<Map<String, String>> hotelnames = data.asMaps();
        Assert.assertEquals("Adactin.com - Select Hotel", getDriver().getTitle());
        System.out.println("Page title matched");

        String actHotel = getDriver().findElement(By.id("hotel_name_0")).getAttribute("value");
        Assert.assertEquals(hotelnames.get(0).get("hotel"), actHotel);
    }

    @Then("user validate the error message using {string}")
    public void user_validate_the_error_message_using(String expError) {
        String actError = getDriver().findElement(By.id("checkout_span")).getText();
        Assert.assertEquals(expError, actError);
    }

}
