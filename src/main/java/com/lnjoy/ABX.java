package com.lnjoy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class ABX implements ABZ {
    private WebDriver driver;
    private FirefoxBinary firefoxBinary;
    private FirefoxOptions options;

    public ABX() {
        int cnt = 1;

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        firefoxBinary = new FirefoxBinary();
        options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);
        driver = new FirefoxDriver(options);

        try {
            driver.get(start_url);
            Thread.sleep(500);
            driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div/ul[1]/li[1]/div/button")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"btnConfirm2\"]")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"schul_name_input\"]")).click();
            Thread.sleep(200);
            Select select1 = new Select(driver.findElement(By.xpath("//*[@id=\"sidolabel\"]")));
            select1.selectByIndex(1);
            Thread.sleep(200);
            Select select2 = new Select(driver.findElement(By.xpath("//*[@id=\"crseScCode\"]")));
            select2.selectByIndex(4);
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"orgname\"]")).sendKeys(SchoolName);
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/table/tbody/tr[3]/td[2]/button")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[1]/ul/li/a")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/input")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"user_name_input\"]")).sendKeys(UserName);
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"birthday_input\"]")).sendKeys(BirthDay);
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"btnConfirm\"]")).click();
            Thread.sleep(200);
            driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[2]/div/div[2]/div/div[1]/table/tbody/tr/td/input")).sendKeys(PassWord);
            Thread.sleep(200);
            driver.findElement(By.xpath("//*[@id=\"btnConfirm\"]")).click();
            Thread.sleep(2000);
            WebElement btn = driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[2]/div/section[2]/div[2]/ul/li/a/button"));
            if(!btn.getText().equals("미참여")) {
                System.out.println("Already!!");
                return;
            }
            btn.click();
            Thread.sleep(500);
            while(cnt <= 3) {
                driver.findElement(By.xpath("//*[@id=\"survey_q" + cnt + "a1\"]")).click();
                cnt++;
                Thread.sleep(200);
            }
            driver.findElement(By.xpath("//*[@id=\"btnConfirm\"]")).click();
            Thread.sleep(500);
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }
}
