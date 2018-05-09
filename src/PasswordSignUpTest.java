import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class PasswordSignUpTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tripadvisor.com/");

        WebElement join = driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/a[2]"));
        join.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement site_button = driver.findElement(By.xpath("//*[@id=\"ssoButtons\"]/span[2]"));
        site_button.click();

        WebElement email = driver.findElement(By.xpath("//*[@id=\"regSignUp.email\"]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"regSignUp.password\"]"));
        WebElement new_join = driver.findElement(By.xpath("//*[@id=\"regSignUp\"]/div[3]"));

        // PASSED
        //Test case for EC1, sign up from site with valid credentials
        try {
            signInSiteTest(driver, email, pass, new_join, "12345678", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC2, sign up from site with invalid email
        try {
            signInSiteTest(driver, email, pass, new_join, "asdasdasd", false);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC3, sign up from site with empty email
        try {
            signInSiteTest(driver, email, pass, new_join, "", false);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void signInSiteTest(WebDriver driver, WebElement email, WebElement pass, WebElement join, String input, boolean prove_valid) throws NoSuchElementException, TimeoutException {

        email.sendKeys("abc@gmail.com");
        pass.sendKeys(input);
        join.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/div[1]/span[2]")).getText().equals("abc@s") && prove_valid)
            System.out.println("Test case Passed");
        else if (!driver.findElement(By.xpath("//*[@id=\"taplc_global_nav_action_profile_0\"]/div/div[1]/span[2]")).getText().equals("abc@s") && !prove_valid)
            System.out.println("Test case Passed");
        else
            System.out.println("Test case Failed");
    }
}