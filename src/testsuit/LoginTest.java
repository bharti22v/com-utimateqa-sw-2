package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //find SignIn button and click on Sign In link
        WebElement linkText = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        linkText.click();
        String expectedMessage = "Welcome Back!";
        String actualMessage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //find SignIn button and click on Sign In link
        WebElement linkText = driver.findElement(By.xpath("//li[@class='header_nav-item header_nav-sign-in']"));
        linkText.click();
        //find username field and enter invalid username
        WebElement username = driver.findElement(By.xpath("//input[@id='user[email]']"));
        username.sendKeys("bhakti@gmail.com");
        //find password field and enter invalid password
        WebElement password = driver.findElement(By.xpath("//input[@id='user[password]']"));
        password.sendKeys("papamummy");
        //find loginbutton and click on Signin link
        WebElement signIn = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        signIn.click();
        //verify that six products are displayed on page.
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.className("form-error__list-item")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @After
    //close the browser
    public void tearDown(){
        closeBrowser();
    }
}
