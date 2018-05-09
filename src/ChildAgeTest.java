import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChildAgeTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // ALL PASSED
        //Test case for EC1 to EC17, value of childrens age from 0-1... upto 17
        for (int i = 1; i <= 18; i++) {
            try {
                testChildAge(driver, i);
            } catch (Exception e) {
                System.out.println("Test case Failed");
            }
        }
    }

    //Passing tests for valid data
    private static void testChildAge(WebDriver driver, int input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");

        WebElement place = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]/div[2]/div[1]/div/span/input"));
        place.sendKeys("Barcelona");

        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]/div[2]/div[3]/div/div"));
        drop.click();

        WebElement add_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[3]/div/span[1]/span[2]"));
        add_child.click();

        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[4]/span/span/span[2]"));
        dropdown.click();//*[@id="BODY_BLOCK_JQUERY_REFLOW"]/span/div[3]/div/div[4]/span/span/div/span/ul[2]/li[2]

        WebElement age = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[4]/span/span/div/span/ul[2]/li[" + input + "]"));
        age.click();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"SUBMIT_HOTELS\"]"));
        button.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"taplc_hsx_hotel_list_lite_dusty_hotels_combined_sponsored_0\"]/div[1]/div/div[1]")));

        System.out.println("Test case Passed");
    }

}