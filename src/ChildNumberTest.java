import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChildNumberTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, value of children between 0-20
        try {
            testChildNumber(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void testChildNumber(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]/div[2]/div[3]/div/div"));
        drop.click();

        WebElement child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[3]/div/span[2]"));
        WebElement add_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[3]/div/span[1]/span[2]"));
        WebElement remove_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[3]/div/span[1]/span[1]"));

        for (int i = 1; i <= 21; i++) {
            add_child.click();
            String val = child.getText().split(" ")[0];
            if (i == 21 && val.equals("20")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        for (int i = 19; i >= -1; i--) {
            remove_child.click();
            String val = child.getText().split(" ")[0];
            if (i == -1 && val.equals("0")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        System.out.println("Test case Passed");
    }

}