package com.fjy.fxtools.utils;

import com.fjy.fxtools.enums.BrowserDriverEnum;
import java.time.Duration;
import java.util.function.Consumer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * selenium的工具类
 *
 * @author fangjy
 * @date 2024-09-24 14:56
 **/
@Slf4j
@Data
public class SeleniumUtil {

    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * 创建新的驱动
     */
    public static WebDriver createWebDriver(BrowserDriverEnum driverEnum){
        if (BrowserDriverEnum.chrome == driverEnum){
            webDriver = new ChromeDriver();
        }
        else if (BrowserDriverEnum.firefox == driverEnum){
            webDriver = new FirefoxDriver();
        }else {
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }

    /**
     * 退出驱动
     */
    public static void quitWebDriver(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
    public static void closeWebDriver(){
        if (webDriver != null){
            webDriver.close();
        }
    }

    /**
     * 执行浏览器操作
     */
    public static void doWebDriverTask(BrowserDriverEnum driverEnum,Boolean ifQuit, Consumer<WebDriver> consumer){
        WebDriver driver;
        try {
            driver = SeleniumUtil.createWebDriver(driverEnum);
            consumer.accept(driver);
        } catch (Exception e) {
            log.error("处理selenium脚本异常",e);
        }finally {
            if (ifQuit==null || ifQuit){
                SeleniumUtil.quitWebDriver();
            }
        }
    }

    /**
     * 使用等待的方式获取页面元素
     * @param seconds 最大等待时间，默认5s
     * @param by 页面元素
     */
    public static WebElement getWebElementByWait(Long seconds,By by){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds==null?10:seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
