import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FlightClassesTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // ALL PASSED
        //Test case for EC1-4 valid flight classes
        for (int i = 1; i <= 4; i++) {
            try {
                flightClasses(driver, i);
            } catch (Exception e) {
                System.out.println("Test case Failed");
            }
        }
    }

    //Passing tests for valid data
    private static void flightClasses(WebDriver driver, int input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");

        WebElement drop = driver.findElement(By.xpath("//*[@id=\"cos_ui_picker\"]"));
        drop.click();

        WebElement drop_down = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div/div[1]/div"));
        drop_down.click();

        driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[11]/div/ul[2]/li[" + input + "]")).click();

        WebElement find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[4]/button"));
        find.click();

        System.out.println("Test case Passed");
    }
}