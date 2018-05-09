import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class AdultSelectionFlightTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, value of adults between 0-6
        try {
            testAdultNumber(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void testAdultNumber(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"cos_ui_picker\"]"));
        drop.click();

        WebElement adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div/div[3]/div[1]/span[2]"));
        WebElement add_adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div/div[3]/div[2]/span[2]"));
        WebElement remove_adult = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div/div[3]/div[2]/span[1]"));

        for (int i = 2; i <= 7; i++) {
            add_adult.click();
            String val = adult.getText().split(" ")[0];
            if (i == 7 && val.equals("6")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        for (int i = 6; i >= 0; i--) {
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