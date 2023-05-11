import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class SimpleFormDemo {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "D:\\Melinda\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
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
    public void singleInputFieldIsEmpty() {
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(false, yourMessage.isDisplayed());
    }

    @Test
    public void singleInputFieldIsAlphanumerical() { // verify that input field is alphanumerical
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("user-message")).sendKeys("test1234");
        driver.findElement(By.id("showInput")).click();
        WebElement yourMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(yourMessage.getText(), "test1234");
    }

    @Test
    public void twoInputFieldsAddTwoNumbers() { //adding two integers
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("4");
        driver.findElement(By.id("sum2")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "5");
    }

    @Test
    public void twoInputFieldsAddNumberAndString() { //adding an integer and a string
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("4");
        driver.findElement(By.id("sum2")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "NaN");
    }

    @Test
    public void twoInputFieldsAddNegativeNumbers() { //adding two negative numbers
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("-5");
        driver.findElement(By.id("sum2")).sendKeys("-1");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "-6");
    }

    @Test
    public void twoInputFieldsLeaveOneFieldEmpty() { //leaving one field empty
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "NaN");
    }

    @Test
    public void twoInputFieldsAddingNonIntegers() { //adding two non integers
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
        driver.findElement(By.id("sum1")).sendKeys("2.5");
        driver.findElement(By.id("sum2")).sendKeys("3.5");
        driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
        WebElement yourMessage = driver.findElement(By.id("addmessage"));
        Assert.assertEquals(yourMessage.getText(), "6");
    }

    @Test
    public void singleCheckbox() { //verify that checkbox can be checked by clicking on it
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        WebElement button = driver.findElement(By.id("isAgeSelected"));
        button.click();
        WebElement yourMessage = driver.findElement(By.id("txtAge"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
        Assert.assertEquals(true, button.isSelected());
    }

    @Test
    public void singleCheckboxIsNotChecked() { //verify that checkbox is not checked by default
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        WebElement yourMessage = driver.findElement(By.id("txtAge"));
        Assert.assertEquals(!true, yourMessage.isDisplayed());
    }

    @Test
    public void singleCheckboxClickOnText() { //verify that clicking on the text also checks the checkbox
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[1]/div[2]/div[1]/label")).click();
        WebElement yourMessage = driver.findElement(By.id("txtAge"));
        Assert.assertEquals(true, yourMessage.isDisplayed());
    }

    @Test
    public void multipleCheckbox() { //verify that button says 'Check all' by default
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        WebElement button = driver.findElement(By.id("box"));
        Assert.assertEquals(button.getAttribute("value"), "check all");
    }
    @Test
    public void multipleCheckboxCheckAllManually() { //verify that button changes to 'uncheck all' after manually checking the checkboxes
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");

        WebElement button = driver.findElement(By.id("box"));
        List<WebElement> checkboxList = driver.findElements(By.cssSelector("input[id^=ex1-check]"));

        for (WebElement checkbox : checkboxList) {
            checkbox.click();
        }
        Assert.assertEquals(button.getAttribute("value"), "uncheck all");
    }

    @Test
    public void multipleCheckboxCheckAllButton() { //verify that 'check all' button checks all the checkboxes
        driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
        WebElement button = driver.findElement(By.id("box"));
        button.click();

        List<WebElement> checkboxList = driver.findElements(By.cssSelector("input[id^=ex1-check]"));
        boolean isAllChecked = true;
        for (WebElement checkbox : checkboxList) {
            if (!checkbox.isSelected()) {
                isAllChecked = false;
            }
        }
        Assert.assertTrue(isAllChecked);
    }

    @Test
    public void radioButtonMale() { //verify that 'Male' radio button is functional
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.cssSelector("input[type='radio'][value='Male'][name='optradio']")).click();
        driver.findElement(By.id("buttoncheck")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[1]/div[2]/p[2]"));
        Assert.assertEquals(yourMessage.getText(), "Radio button 'Male' is checked");
    }

    @Test
    public void radioButtonFemale() { //verify that 'Female' radio button is functional
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.cssSelector("input[type='radio'][value='Female'][name='optradio']")).click();
        driver.findElement(By.id("buttoncheck")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[1]/div[2]/p[2]"));
        Assert.assertEquals(yourMessage.getText(), "Radio button 'Female' is checked");
    }

    @Test
    public void radioButtonNoButtonIsSelected() { //no radio button is selected
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.id("buttoncheck")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[1]/div[2]/p[2]"));
        Assert.assertEquals(yourMessage.getText(), "Radio button is Not checked");
    }

    @Test
    public void groupRadioButtonsNoButtonsAreSelected() { //no radio buttons are selected
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[1]/span"));
        WebElement yourMessage2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[2]/span"));
        Assert.assertEquals(false, yourMessage.isDisplayed());
        Assert.assertEquals(false, yourMessage2.isDisplayed());
    }

    @Test
    public void groupRadioButtonsOnlyGenderIsSelected() { //only gender radio button is selected
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.cssSelector("input[type='radio'][value='Male'][name='gender']")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[1]/span"));
        WebElement yourMessage2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[2]/span"));
        Assert.assertEquals(yourMessage.getText(), "Male");
        Assert.assertEquals(false, yourMessage2.isDisplayed());
    }

    @Test
    public void groupRadioButtonsBothAreSelected() { //both gender and age button is selected
        driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
        driver.findElement(By.cssSelector("input[type='radio'][value='Female'][name='gender']")).click();
        driver.findElement(By.cssSelector("input[type='radio'][value='5 - 15'][name='ageGroup']")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[1]/button")).click();
        WebElement yourMessage = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[1]/span"));
        WebElement yourMessage2 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[2]/div[2]/div[2]/div/div[2]/p[2]/span"));
        Assert.assertEquals(yourMessage.getText(), "Female");
        Assert.assertEquals(yourMessage2.getText(), "5 - 15");
    }
}


