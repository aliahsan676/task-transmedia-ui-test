package com.ui.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

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
        Thread.sleep(3000);

        // Add 1 item to the basket

        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span")).click();
        Thread.sleep(3000);

        // Go to checkout

        driver.findElement(By.cssSelector("button[class='mat-focus-indicator buttons mat-button mat-button-base ng-star-inserted']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button#checkoutButton")).click();

        // Add a new address & Fill in the address form

        driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-address-select/div/app-address/mat-card/div/button/span[1]/span")).click();

        WebElement webElement3 = driver.findElement(By.cssSelector("input#mat-input-3"));
        webElement3.click();
        webElement3.clear();
        webElement3.sendKeys("Bangladesh");
        Thread.sleep(3000);

        WebElement webElement4 = driver.findElement(By.cssSelector("input#mat-input-4"));
        webElement4.clear();
        webElement4.sendKeys("Ali Ahsan");
        Thread.sleep(3000);

        WebElement webElement5 = driver.findElement(By.cssSelector("input#mat-input-5"));
        webElement5.clear();
        webElement5.sendKeys("01681572023");
        Thread.sleep(3000);

        WebElement webElement6 = driver.findElement(By.cssSelector("input#mat-input-6"));
        webElement6.clear();
        webElement6.sendKeys("1212");
        Thread.sleep(3000);

        WebElement webElement7 = driver.findElement(By.cssSelector("#address"));
        webElement7.clear();
        webElement7.sendKeys("Badda");
        Thread.sleep(3000);

        WebElement webElement8 = driver.findElement(By.cssSelector("input#mat-input-8"));
        webElement8.clear();
        webElement8.sendKeys("DhakaCity");
        Thread.sleep(3000);

        WebElement webElement9 = driver.findElement(By.cssSelector("input#mat-input-9"));
        webElement9.clear();
        webElement9.sendKeys("Dhaka");
        Thread.sleep(3000);

        // Click on submit

        driver.findElement(By.cssSelector("#submitButton")).click();
        Thread.sleep(3000);



        // Verify search button

        WebElement searchButton = driver.findElement(By.cssSelector("#searchQuery"));

        verifyTrue("Search button is not displayed", searchButton.isDisplayed());

        // Search for apple

        WebElement webElement10 = driver.findElement(By.cssSelector("#searchQuery"));
        webElement10.click();
        Actions actions = new Actions(driver);
        actions.sendKeys("A").perform();
        actions.sendKeys("P").perform();
        actions.sendKeys("P").perform();
        actions.sendKeys("L").perform();
        actions.sendKeys("E").perform();
        Thread.sleep(3000);

        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);

        // verify that 2 apple products show up

        List<WebElement> appleProducts = driver.findElements(By.xpath("//*[contains(text(),'apple')]"));
        if (appleProducts.size() >= 2) {
            System.out.println("At least two apple products are displayed.");
        } else {
            System.out.println("Less than two apple products are displayed.");
        }

        // Verify Banana product doesn't show up

        List<WebElement> bananaProducts = driver.findElements(By.xpath("//*[contains(text(),'banana')]"));
        if (bananaProducts.isEmpty()) {
            System.out.println("No banana products are displayed.");
        } else {
            System.out.println("Banana products are displayed.");
        }

        Thread.sleep(3000);

        driver.quit();





    }

    private static void verifyTrue(String search_button_is_not_displayed, boolean displayed) {
    }
}
