import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TemaLab18 {

    public String baseUrl = "http://www.google.com/";
    public WebDriver driver = new ChromeDriver();


    @Test(priority = 1)
    public void searchImages() {
        driver.get(baseUrl);

        WebElement cookies = driver.findElement(By.id("L2AGLb"));
        cookies.click();

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("chocolate cake");
        element.submit();

        WebElement images = driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a"));
        images.click();
    }

    @Test(priority = 2)
    public void firstResult() {
        driver.get(baseUrl);

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("cheesecake");
        element.submit();

        WebElement result = driver.findElement(By.className("LC20lb"));
        result.click();
    }

    @Test(priority = 3)
    public void clearSearch() {

        driver.get(baseUrl);

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("carrot cake");
        element.submit();

        WebElement clear = driver.findElement(By.className(("BKRPef")));
        clear.click();

        driver.quit();
    }
}
