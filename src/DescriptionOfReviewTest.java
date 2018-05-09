import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class DescriptionOfReviewTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        StringBuilder in = new StringBuilder();
        for (int i = 0; i < 200; i++) in.append("a");

        // PASSED
        //Test case for EC1, add review
        try {
            descriptionOfReview(driver, in.toString(), false);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC2, leave review < 200
        try {
            descriptionOfReview(driver, "asdasdasd", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC2, leave review empty
        try {
            descriptionOfReview(driver, "", true);
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for valid data
    private static void descriptionOfReview(WebDriver driver, String input, boolean empty) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/UserReview");

        WebElement drop = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div"));
        drop.click();

        if (!empty) {
            WebElement title = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[3]/form/label[2]/textarea"));
            title.sendKeys(input);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement sub = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[3]/form/div/input"));
        sub.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement new_sub = driver.findElement(By.xpath("//*[@id=\"taplc_quick_review_0\"]/div/div[3]/form/div/input"));
        new_sub.click();

        System.out.println("Test case Passed");
    }

}