package com.fjy.fxtools.utils;

import com.fjy.fxtools.enums.BrowserDriverEnum;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * selenium的工具类
 *
 * @author fangjy
 * @date 2024-09-24 14:56
 **/
@Slf4j
public class SeleniumUtil {

    public static WebDriver getWebDriver(BrowserDriverEnum driverEnum){
        if (BrowserDriverEnum.chrome == driverEnum){
            return new ChromeDriver();
        }
        else if (BrowserDriverEnum.firefox == driverEnum){
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }

    public static void quitWebDriver(WebDriver driver){
        if (driver != null){
            driver.quit();
        }
    }

    public static void doWebDriverTask(BrowserDriverEnum driverEnum, Consumer<WebDriver> consumer){
        WebDriver driver = null;
        try {
            driver = SeleniumUtil.getWebDriver(driverEnum);
            consumer.accept(driver);
        } catch (Exception e) {
            log.error("处理selenium脚本异常",e);
        }finally {
            SeleniumUtil.quitWebDriver(driver);
        }
    }
}
