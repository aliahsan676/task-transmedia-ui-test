package com.ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class UITest {
    public static void main(String[] args) throws InterruptedException {

        //Browser Launch

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();


        // Navigate to designated url
        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Minimizing the pop up
        driver.findElement(By.cssSelector("button[class='mat-focus-indicator close-dialog mat-raised-button mat-button-base mat-primary ng-star-inserted']")).click();



        // Log in to account
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();

        WebElement webElement1 = driver.findElement(By.cssSelector("#email"));
        webElement1.clear();
        webElement1.sendKeys("ahsansayel@gmail.com");

        WebElement webElement2 = driver.findElement(By.cssSelector("#password"));
        webElement2.clear();
        webElement2.sendKeys("Ahsan@1234");

        driver.findElement(By.cssSelector("button#loginButton")).click();

        // Add 1 item to the basket

        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span")).click();

        // Go to checkout

        driver.findElement(By.cssSelector("button[class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']")).click();

        driver.findElement(By.cssSelector("button#checkoutButton")).click();

        // Add a new address & Fill in the address form

        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-address-select/div/app-address/mat-card/div/button/span[1]/span")).click();

        WebElement webElement3 = driver.findElement(By.cssSelector("input#mat-input-9"));
        webElement3.clear();
        webElement3.sendKeys("Bangladesh");

        WebElement webElement4 = driver.findElement(By.cssSelector("input#mat-input-10"));
        webElement4.clear();
        webElement4.sendKeys("Ali Ahsan");

        WebElement webElement5 = driver.findElement(By.cssSelector("input#mat-input-11"));
        webElement5.clear();
        webElement5.sendKeys("01681572023");

        WebElement webElement6 = driver.findElement(By.cssSelector("input#mat-input-12"));
        webElement6.clear();
        webElement6.sendKeys("1212");

        WebElement webElement7 = driver.findElement(By.cssSelector("#address"));
        webElement7.clear();
        webElement7.sendKeys("Badda");

        WebElement webElement8 = driver.findElement(By.cssSelector("input#mat-input-14"));
        webElement8.clear();
        webElement8.sendKeys("Dhaka City");

        WebElement webElement9 = driver.findElement(By.cssSelector("input#mat-input-15"));
        webElement9.clear();
        webElement9.sendKeys("Dhaka");

        // Click on submit

        driver.findElement(By.cssSelector("#submitButton")).click();




        Thread.sleep(19000);















        driver.quit();





    }
}
