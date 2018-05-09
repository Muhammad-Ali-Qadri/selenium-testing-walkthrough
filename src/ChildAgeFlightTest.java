import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChildAgeFlightTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // ALL PASSED
        //Test case for EC1-17 valid children age
        for (int i = 3; i <= 21; i++) {
            try {
                childFlightAge(driver, i);
            } catch (Exception e) {
                System.out.println("Test case Failed");
            }
        }
    }

    //Passing tests for valid data
    private static void childFlightAge(WebDriver driver, int input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"cos_ui_picker\"]"));
        drop.click();

        WebElement add_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div/div[4]/div[2]/span[2]"));
        add_child.click();

        WebElement drop_down = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span[2]/div[3]/div/div/div[7]/div[1]/div[2]/div"));
        drop_down.click();

        WebElement item = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span[1]/div/div[" + input + "]"));
        item.click();

        WebElement find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[4]/button"));
        find.click();

        System.out.println("Test case Passed");
    }
}