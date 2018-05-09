import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TravelOptionsSelectionTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1 to EC3, travel flight options
        for (int i = 1; i <= 3; i++) {
            try {
                travelOptions(driver, i);
            } catch (Exception e) {
                System.out.println("Test case Failed");
            }
        }
    }

    //Passing tests for valid data
    private static void travelOptions(WebDriver driver, int input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");

        WebElement trip = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/div[1]/ul/li[" + input + "]/div/a"));
        trip.click();

        WebElement find;

        if (input != 3)
            find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[" + input + "]/div/div[4]/button"));
        else
            find = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/span/div[3]/div[5]/div[3]/span"));
        find.click();

        System.out.println("Test case Passed");
    }


}