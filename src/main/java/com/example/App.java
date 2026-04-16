package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");           // run without UI
        options.addArguments("--no-sandbox");             // required in CI
        options.addArguments("--disable-dev-shm-usage");  // prevent crashes

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        
        driver.manage().window().maximize();

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit(); // ✅ important to close browser
    }
}
