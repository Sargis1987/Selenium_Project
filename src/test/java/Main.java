import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//drivers//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.imdb.com/");
        String LandingPageTitle="IMDb: Ratings, Reviews, and Where to Watch the Best Movies & TV Shows";
        String LandingPage=driver.getTitle();
        System.out.println(LandingPage);
        if (LandingPage.equals(LandingPageTitle)){
            System.out.println("LandingPageTitle Test is Passed");
        }else{
            System.out.println("LandingPageTitle Test is Failed");
        }
        driver.findElement(By.xpath("//div[text()='Sign In']")).click();
        driver.findElement(By.xpath("//span[text()='Sign in with IMDb']")).click();
        driver.findElement(By.id("ap_email")).click();
        driver.findElement(By.id("ap_email")).sendKeys("test_100@internet.ru");
        driver.findElement(By.id("ap_password")).click();
        driver.findElement(By.id("ap_password")).sendKeys("wireless++");
        driver.findElement(By.id("signInSubmit")).click();
        String HomePageTitle="IMDb Sign-In";
        String HomePage= driver.getTitle();
        Assert.assertEquals(HomePage, HomePageTitle);
        System.out.println(HomePage);
        js.executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.xpath("//div[text()='Watch Guide']")).click();
        String WatchGuideTitle="What to Watch - IMDb";
        String WatchGuide=driver.getTitle();
        if (WatchGuide.equals(WatchGuideTitle)){
            System.out.println("WatchGuideTitle Test is Passed");
        }else{
            System.out.println("WatchGuideTitle Test is Failed");
        }
        System.out.println(WatchGuide);
        String MovieTitle="The Batman";
        driver.findElement(By.id("suggestion-search")).sendKeys(MovieTitle);
        driver.findElement(By.id("suggestion-search")).sendKeys(Keys.ENTER);
        String MovieSearch=driver.findElement(By.linkText(MovieTitle)).getText();
        System.out.println(MovieSearch);
        Assert.assertEquals(MovieSearch,MovieTitle);
        driver.quit();
    }
}