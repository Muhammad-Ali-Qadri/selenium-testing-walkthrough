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
        WebElement drop = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests ui_column wctx-tripsearch']"));
        drop.click();

        WebElement room = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='roomsPlaceholder']/div[@class='picker rooms-picker']/span[@class='picker-label']"));
        WebElement add_room = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='roomsPlaceholder']/div[@class='picker rooms-picker']/span[@class='ui_selector']/span[@class='ui_icon plus-circle']"));
        WebElement remove_room = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/span[@class='ui_overlay ui_popover arrow_top rooms_guests_children no_x no_padding']/div[@class='body_text']/div[@class='prw_rup prw_ibex_trip_search_rooms_guests popup_content pickers']/div[@class='roomsPlaceholder']/div[@class='picker rooms-picker']/span[@class='ui_selector']/span[@class='ui_icon minus-circle']"));

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

        for (int i = 7; i >= 0; i++) {
            remove_room.click();
            String val = room.getText().split(" ")[0];
            if (i == 0 && room.getText().split(" ")[0].equals("1")) {
                break;
            }
            if (!val.equals(String.valueOf(i))) {
                throw new NoSuchElementException("exception");
            }
        }

        System.out.println("Test case Passed");
    }

}