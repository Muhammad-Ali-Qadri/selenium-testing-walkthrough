import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchHotelTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        // PASSED
//        //Test case for EC1, add name of city
//        testHotelName(driver, "Barcelona");
//
//        // PASSED
//        //Test case for EC2, add name of city
//        testHotelNameInvalid(driver, "3.433.435");
//
//        // PASSED
//        //Test case for EC3, add name of city
//        testHotelNameInvalid(driver, "1344511");

        // PASSED
        //Test case for EC4, add name of city
        try {
            testHotelNameInvalid(driver, "#$$%232#@");
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

    }

    private static void testHotelName(WebDriver driver, String input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");
        WebElement city = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_search_typeahead ui_column is-3 responsive_inline_priority search_typeahead wctx-tripsearch']/div[@class='ui_picker']/span[@class='typeahead_align ui_typeahead']/input[@class='typeahead_input']"));
        city.sendKeys(input);

        WebElement find_hotels = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_common_form_submit ui_column responsive_inline_hidden submit_wrap']/button[@id='SUBMIT_HOTELS']"));
        find_hotels.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@class='delineation']/div[@id='MAINWRAP']/div[@id='MAIN']/div[@id='BODYCON']/div[@class='bodycon_main']/div[@class='relWrap']/div[@id='taplc_hsx_hotel_list_lite_dusty_hotels_combined_sponsored_0']/div[@class='prw_rup prw_meta_hsx_responsive_listing ui_section listItem'][1]")));

        WebElement list_item = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@class='delineation']/div[@id='MAINWRAP']/div[@id='MAIN']/div[@id='BODYCON']/div[@class='bodycon_main']/div[@class='relWrap']/div[@id='taplc_hsx_hotel_list_lite_dusty_hotels_combined_sponsored_0']/div[@class='prw_rup prw_meta_hsx_responsive_listing ui_section listItem'][1]"));

        if (!list_item.getText().isEmpty()) {
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed");
        }
    }

    private static void testHotelNameInvalid(WebDriver driver, String input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/");
        WebElement city = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_search_typeahead ui_column is-3 responsive_inline_priority search_typeahead wctx-tripsearch']/div[@class='ui_picker']/span[@class='typeahead_align ui_typeahead']/input[@class='typeahead_input']"));
        city.sendKeys(input);

        WebElement find_hotels = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_common_form_submit ui_column responsive_inline_hidden submit_wrap']/button[@id='SUBMIT_HOTELS']"));
        find_hotels.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@id='PAGE']/div[@class='srp_content results']/div[@class='search_page_wrapper easyClear']/div[@class='search_results_column scrollAdMain']/div/div[@id='taplc_search_results_0']/div[@id='search_result']/div[@class='error-message']/div[@class='error-heading']")));

        WebElement sorry_msg = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@id='PAGE']/div[@class='srp_content results']/div[@class='search_page_wrapper easyClear']/div[@class='search_results_column scrollAdMain']/div/div[@id='taplc_search_results_0']/div[@id='search_result']/div[@class='error-message']/div[@class='error-heading']"));

        if (sorry_msg.getText().contains("Sorry")) {
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed");
        }
    }

}