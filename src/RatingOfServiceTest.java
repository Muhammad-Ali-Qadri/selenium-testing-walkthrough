import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class RatingOfServiceTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, add rating
        try {
            ratingOfService(driver, false);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC2, leave rarting empty
        try {
            ratingOfService(driver, true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void ratingOfService(WebDriver driver, boolean empty) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");

        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div"));
        drop.click();

        if (empty) {
            WebElement rating = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[2]/div[3]/span[1]"));
            rating.click();
        }

        WebElement sub = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[3]/form/div/input"));
        sub.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement new_sub = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[3]/form/div/input"));
        new_sub.click();

        System.out.println("Test case Passed");
    }

}