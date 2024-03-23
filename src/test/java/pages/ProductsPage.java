package pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.*;

public class ProductsPage {
    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formalShoes_dropdown_xpath = "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoes_dropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakers_dropdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_tableBody = "/html/body/div[2]/table/tbody";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakers_firstShoeName = "/html/body/div[4]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle() throws IOException {
        String expectedTitleFS ="Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS,actualTitleFS);
        if(expectedTitleFS.equals(actualTitleFS)){
            test.log(Status.PASS, "Test passed for title verification of formal shoes.");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        } else{
            test.log(Status.FAIL, "Test Failed.");
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
    }
    public static void sportsShoes_verifyTitle(){
        String expectedTitleSS ="Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS,actualTitleSS);
        if(expectedTitleSS.equals(actualTitleSS)){
            test.log(Status.PASS, "Test passed for title verification of sports shoes.");
        }else{
            test.log(Status.FAIL, "Test Failed.");
        }
    }
    public static void sneakers_verifyTitle(){
        String expectedTitleS ="Sneakers";
        String actualTitleS = driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(expectedTitleS,actualTitleS);
        if(expectedTitleS.equals(actualTitleS)){
            test.log(Status.PASS, "Test passed for title verification of sneakers.");
        }else{
            test.log(Status.FAIL, "Test Failed.");
        }
    }

    public static void formalShoes_firstShoe_verify(){
        String expectedTitle = "Classic Cheltenham";
        driver.findElement(By.xpath(formalShoes_dropdown_xpath)).click();
        String actualTitle = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText().trim();;
        Assert.assertEquals(expectedTitle,actualTitle);
        if(expectedTitle.equals(actualTitle)){
            test.log(Status.PASS, "Test passed for title verification of the first formal shoe.");
        }else{
            test.log(Status.FAIL, "Test Failed.");
        }
    }
    public static void sportsShoes_firstShoe_verify(){
        String expectedTitle = "Ultimate";
        driver.findElement(By.xpath(sportsShoes_dropdown_xpath)).click();
        String actualTitle = driver.findElement(By.xpath(sportsShoes_firstShoeName)).getText().trim();;
        Assert.assertEquals(expectedTitle,actualTitle);
        if(expectedTitle.equals(actualTitle)){
            test.log(Status.PASS, "Test passed for title verification of the first sports shoe.");
        }else{
            test.log(Status.FAIL, "Test Failed.");
        }
    }
    public static void sneakers_firstShoe_verify(){
        String expectedTitle = "Archivo ";
        driver.findElement(By.xpath(sneakers_dropdown_xpath)).click();
        String actualTitle = driver.findElement(By.xpath(sneakers_firstShoeName)).getText().trim();;
        Assert.assertEquals(expectedTitle,actualTitle);
        if(expectedTitle.equals(actualTitle)){
            test.log(Status.PASS, "Test passed for title verification of the first sneakers.");
        }else{
            test.log(Status.FAIL, "Test Failed.");
        }
    }

}
