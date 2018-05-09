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
        WebElement drop = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests ui_column wctx-tripsearch']"));
        drop.click();

        WebElement child = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='childrenPlaceholder']/div[@class='picker children-picker']/span[@class='picker-label']"));
        WebElement add_child = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='childrenPlaceholder']/div[@class='picker children-picker']/span[@class='ui_selector']/span[@class='ui_icon plus-circle']"));
        WebElement remove_child = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='childrenPlaceholder']/div[@class='picker children-picker']/span[@class='ui_selector']/span[@class='ui_icon minus-circle']"));

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

        for (int i = 19; i >= -1; i++) {
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