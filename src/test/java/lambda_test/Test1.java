package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");

        WebElement table = driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
        table.click();

        WebElement numOfRows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(numOfRows, "Show ALL Rows", "text");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i<allNames.size(); i++){
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));

        }
        System.out.println("map = " + map);

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground");


        WebElement table = driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
        table.click();
        Thread.sleep(2000);

        WebElement numOfRows = driver.findElement(By.cssSelector("#maxRows"));
        BrowserUtils.selectBy(numOfRows, "Show ALL Rows", "text");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allNumber = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, Long> map = new HashMap<>();
        for(int i = 0; i<allNames.size(); i++){
            Thread.sleep(2000);
            map.put(BrowserUtils.getText(allNames.get(i)), Long.parseLong(BrowserUtils.getText(allNumber.get(i)).replace("-", "")));
        }

        System.out.println(map);

    }

}
