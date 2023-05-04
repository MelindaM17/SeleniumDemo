import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleFormDemo {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "D:\\Melinda\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        //driver.quit();
    }

    @Test
    public void singleInputField() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("test");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
    }

    @Test
    public void checkThatTheInputFieldIsEmpty() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(false, yourMessage.isDisplayed());
    }

    @Test
    public void checkThatTheInputFieldIsAlphanumerical() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("test1234");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
    }

    @Test
    public void twoInputFieldsAddTwoNumbers() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("4");
        driver.findElement(By.id("sum2")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "5");
    }

    @Test
    public void twoInputFieldsAddNumberAndString() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("4");
        driver.findElement(By.id("sum2")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "NaN");
    }
    @Test
    public void twoInputFieldsAddNegativeNumbers() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("-5");
        driver.findElement(By.id("sum2")).sendKeys("-1");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "-6");
    }
    @Test
    public void twoInputFieldsLeaveOneFieldEmpty() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "NaN");
    }


}