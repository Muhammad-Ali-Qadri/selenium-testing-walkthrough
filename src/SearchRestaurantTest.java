import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchRestaurantTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // PASSED
        //Test case for EC1, add name of restaurant
        try {
            testRestaurantName(driver, "Barcelona");
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC2, add invalid numbers
        try {
            testRestaurantNameInvalid(driver, "3.433.435");
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC3, add invalid numbers
        try {
            testRestaurantNameInvalid(driver, "1344511");
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

        // PASSED
        //Test case for EC4, add invalid characters
        try {
            testRestaurantNameInvalid(driver, "#$$%232#@");
        } catch (Exception e) {
            System.out.println("Test case Failed");
        }

    }

    //Passing tests for valid data
    private static void testRestaurantName(WebDriver driver, String input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/Restaurants");
        WebElement restaurant = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero restaurants_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_restaurants_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_search_typeahead ui_column is-3 responsive_inline_priority search_typeahead wctx-tripsearch']/div[@class='ui_picker']/span[@class='typeahead_align ui_typeahead']/input[@class='typeahead_input']"));
        restaurant.sendKeys(input);

        WebElement find_restaurant = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero restaurants_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_restaurants_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_common_form_submit ui_column responsive_inline_hidden submit_wrap']/button[@id='SUBMIT_RESTAURANTS']"));
        find_restaurant.click();

        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@id='PAGE']/div[@class=' hotels_lf_redesign ui_container is-mobile responsive_body']/div[@class='restaurants_list ']/div[@id='taplc_hotels_redesign_header_0']/div[@id='hotels_lf_header']/div[@id='p13n_tag_header_wrap']/div[@id='p13n_tag_header']/div[@id='p13n_welcome_message']/h1[@id='HEADING']")));

        WebElement list_item = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@id='PAGE']/div[@class=' hotels_lf_redesign ui_container is-mobile responsive_body']/div[@class='restaurants_list ']/div[@id='taplc_hotels_redesign_header_0']/div[@id='hotels_lf_header']/div[@id='p13n_tag_header_wrap']/div[@id='p13n_tag_header']/div[@id='p13n_welcome_message']/h1[@id='HEADING']"));

        if (!list_item.getText().isEmpty()) {
            System.out.println("Test case Passed");
        } else {
            System.out.println("Test case Failed");
        }
    }

    //Passing tests for invalid data
    private static void testRestaurantNameInvalid(WebDriver driver, String input) throws NoSuchElementException, TimeoutException {
        driver.get("https://www.tripadvisor.com/Restaurants");
        WebElement restaurant = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero restaurants_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_restaurants_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_search_typeahead ui_column is-3 responsive_inline_priority search_typeahead wctx-tripsearch']/div[@class='ui_picker']/span[@class='typeahead_align ui_typeahead']/input[@class='typeahead_input']"));
        restaurant.sendKeys(input);

        WebElement find_restaurant = driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero restaurants_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_restaurants_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons hasDates']/div[@class='prw_rup prw_common_form_submit ui_column responsive_inline_hidden submit_wrap']/button[@id='SUBMIT_RESTAURANTS']"));
        find_restaurant.click();

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