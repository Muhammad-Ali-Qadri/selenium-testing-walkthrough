import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class RoomSelectionTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, value of room between 1-8
        try {
            testRoomSelection(driver);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void testRoomSelection(WebDriver driver) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_trip_search_home_default_0\"]/div[2]/div[3]/div/div"));
        drop.click();

        WebElement room = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[1]/div/span[2]"));
        WebElement add_room = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[1]/div/span[1]/span[2]"));
        WebElement remove_room = driver.findElement(By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/span/div[3]/div/div[1]/div/span[1]/span[1]"));

        for (int i = 2; i <= 9; i++) {
            add_room.click();
            String val = room.getText().split(" ")[0];
            if (i == 9 && val.equals("8")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }
        for (int i = 7; i >= 0; i--) {
            remove_room.click();
            String val = room.getText().split(" ")[0];
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