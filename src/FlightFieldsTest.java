import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FlightFieldsTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1,2 valid flight
        try {
            flightFields(driver, "Lahore", "Islamabad", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC3, integer in both
        try {
            flightFields(driver, "121212", "12121212", false);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC4, floating
        try {
            flightFields(driver, "121.11212", "1231.22", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC5, empty
        try {
            flightFields(driver, "", "", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

    }

    //Passing tests for valid data
    private static void flightFields(WebDriver driver, String to, String from, boolean proof_valid) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");

        WebElement to_field = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[1]/div/div[1]/input[2]"));
        to_field.sendKeys(to);

        WebElement from_field = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[1]/div/div[2]/input[2]"));
        from_field.sendKeys(from);

        WebElement find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[4]/button"));
        find.click();

        try {
            Thread.sleep(5000);
            WebElement new_find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[1]/div/div[4]/button"));
        } catch (Exception e) {
            if (proof_valid)
                System.out.println("Test case Passed");
            else System.out.println("Test case Failed");
            return;
        }
        if (!proof_valid)
            System.out.println("Test case Passed");
        else System.out.println("Test case Failed");
    }
}