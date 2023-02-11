package com.google;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;


public class FaceBookRegister {
    ChromeDriver driver;

    @BeforeTest
    public void OpenFacebook ()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
    }

    @BeforeTest
    public void OpenRegistrationPage (){

        // Locate the new account creation button
        WebElement buttonRegister = driver.findElement(By.xpath("//*[text()='Create new account']"));
        buttonRegister.click();

        // wait a period of time until the form load, in order to selenuim not fail
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // locate the field and send data in it
        driver.findElement(By.name("firstname")).sendKeys("HRcom");
        driver.findElement(By.name("lastname")).sendKeys("HRcom");
        driver.findElement(By.name("reg_email__")).sendKeys("ABC@gmail.com");

        //Confirm Email field appears after entering a valid email address , so we have to wait to prevent selenuim from falling
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("ABC@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("ABC@123456");

        // selecting day from dropdown list
         Select Day = new Select(driver.findElement(By.name("birthday_day")));
         Day.selectByValue("1");
        // selecting Month from dropdown list
        Select Month = new Select(driver.findElement(By.name("birthday_month")));
        Month.selectByVisibleText("Jan");
        // selecting Year from dropdown list
        Select Year = new Select(driver.findElement(By.name("birthday_year")));
        Year.selectByValue("1993");

        //Selecting gender
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        //Click on signup button
        driver.findElement(By.name("websubmit")).click();
        ;

        System.out.println("Register Completed Successfully ");
    }



}
