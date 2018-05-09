import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tripadvisor.com/");
        WebElement element=driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_search_typeahead ui_column is-3 responsive_inline_priority search_typeahead wctx-tripsearch']/div[@class='ui_picker']/span[@class='typeahead_align ui_typeahead']/input[@class='typeahead_input']"));
        element.sendKeys("Marriott");

        WebElement button=driver.findElement(By.xpath("/html/body[@id='BODY_BLOCK_JQUERY_REFLOW']/div[@class='page']/div[@id='taplc_homepage_hero_0']/div[@class='homeHero default_home ']/div[@class='ui_container container']/div[@class='placement_wrap']/div[@class='placement_wrap_row']/div[@class='placement_wrap_cell']/div[@id='taplc_trip_search_home_default_0']/div[@class='ui_columns datepicker_box trip_search metaDatePicker  rounded_lockup easyClear usePickerTypeIcons preDates noDates']/div[@class='prw_rup prw_common_form_submit ui_column responsive_inline_hidden submit_wrap']/button[@id='SUBMIT_HOTELS']"));
        button.click();
    }
}