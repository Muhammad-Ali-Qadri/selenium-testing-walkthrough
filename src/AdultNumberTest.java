import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdultNumberTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, value of adults between 1-32
        try {
            testAdultNumber(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void testAdultNumber(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]/div[2]/div[3]/div/div"));
        drop.click();

        WebElement adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[2]/div/span[2]"));
        WebElement add_adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[2]/div/span[1]/span[2]"));
        WebElement remove_adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[2]/div/span[1]/span[1]"));

        for (int i = 2; i <= 33; i++) {
            add_adult.click();
            String val = adult.getText().split(" ")[0];
            if (i == 33 && val.equals("32")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        for (int i = 31; i >= 0; i--) {
            remove_adult.click();
            String val = adult.getText().split(" ")[0];
            if (i == 0 && val.equals("1")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        System.out.println("Test case Passed");
    }

}