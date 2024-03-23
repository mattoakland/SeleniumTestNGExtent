package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {
    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    @BeforeSuite
    public static void launchBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        HomePage.click_hamburger_menu();
        HomePage.click_onlineProducts_link();
    }

    public static String capture(WebDriver driver) throws IOException, IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(srcFile, Dest);
        return errflpath;
    }
    @Test
    void validateTitles_OnlineProducts() throws IOException {
        test = extent.createTest("Validate Shoe Titles on Products Page", "This test validates that on the products page, the titles of shoe categories are correct.");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
    }

    @Test
    void validateFormalShoesTitle(){
        test = extent.createTest("Validate the first shoe's title from formal shoes", "This test validates that on the dropdown section for formal shoes, the titles of shoe categories are correct.");
        ProductsPage.formalShoes_firstShoe_verify();
    }
    @Test
    void validateSportsShoesTitle(){
        test = extent.createTest("Validate the first shoe's title from sports shoes", "This test validates that on the dropdown section for sports shoes, the titles of shoe categories are correct.");
        ProductsPage.sportsShoes_firstShoe_verify();
    }
    @Test
    void validateSneakersTitle(){
        test = extent.createTest("Validate the first shoe's title from sneakers", "This test validates that on the dropdown section for sneakers, the title of the first sneaker is correct.");
        ProductsPage.sneakers_firstShoe_verify();
    }

    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }
}
