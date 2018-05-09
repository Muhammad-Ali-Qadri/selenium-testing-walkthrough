import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SigninTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC2, sign up from facebook
        try {
            signInFacebookTest(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC1, sign up from site
        try {
            signInSiteTest(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC3, sign up from google
        try {
            signInGoogleTest(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void signInFacebookTest(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");

        WebElement join = driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/a[2]"));
        join.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"coreReg\"]")));

        WebElement fb_button = driver.findElement(By.xpath("//*[@id=\"facebookBtn\"]"));
        fb_button.click();

        System.out.println("Test case Passed");
    }

    //Passing tests for valid data
    private static void signInSiteTest(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");

        WebElement join = driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/a[2]"));
        join.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"coreBody\"]")));

        WebElement site_button = driver.findElement(By.xpath("//*[@id=\"ssoButtons\"]/span[2]"));
        site_button.click();

        WebElement email = driver.findElement(By.xpath("//*[@id=\"regSignUp.email\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"regSignUp.password\"]"));
        WebElement new_join = driver.findElement(By.xpath("//*[@id=\"regSignUp\"]/div[3]"));

        System.out.println("Test case Passed");
    }

    //Passing tests for valid data
    private static void signInGoogleTest(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");

        WebElement join = driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/a[2]"));
        join.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"coreBody\"]")));

        WebElement google_btn = driver.findElement(By.xpath("//*[@id=\"googleBtn\"]"));
        google_btn.click();

        System.out.println("Test case Passed");
    }

}