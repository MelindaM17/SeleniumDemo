import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GoogleSearchTest  {

    public String baseUrl= "http://www.google.com/";
    public WebDriver driver = new ChromeDriver();

    @Test
    public void verifyHomePageTitle() {
        driver.get(baseUrl);
        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
