import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChildrenSelectionFlightTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, value of children between 0-5
        try {
            testChildrenNumber(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void testChildrenNumber(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/CheapFlightsHome");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"cos_ui_picker\"]"));
        drop.click();

        WebElement child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span[2]/div[3]/div/div/div[5]/div[1]/span[2]"));
        WebElement add_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span[2]/div[3]/div/div/div[5]/div[2]/span[2]"));
        WebElement remove_child = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span[2]/div[3]/div/div/div[5]/div[2]/span[1]"));

        for (int i = 1; i <= 6; i++) {
            add_child.click();
            String val = child.getText().split(" ")[0];
            if (i == 6 && val.equals("5")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        for (int i = 5; i >= -1; i--) {
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