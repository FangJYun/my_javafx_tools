package com.fjy.fxtools.utils;

import com.fjy.fxtools.enums.BrowserDriverEnum;
import com.fjy.fxtools.module.CreateDriverParam;
import java.time.Duration;
import java.util.function.Consumer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
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
    public static WebDriver createWebDriver(CreateDriverParam param){
        if (BrowserDriverEnum.chrome == param.getDriverEnum()){
            webDriver = new ChromeDriver((ChromeOptions)getDriverOptions(param));
        }
        else if (BrowserDriverEnum.firefox == param.getDriverEnum()){
            webDriver = new FirefoxDriver((FirefoxOptions)getDriverOptions(param));
        }else {
            webDriver = new ChromeDriver((ChromeOptions)getDriverOptions(param));
        }
        return webDriver;
    }

    public static AbstractDriverOptions<?> getDriverOptions(CreateDriverParam param){
        if (param.getDriverEnum()==null || BrowserDriverEnum.chrome == param.getDriverEnum()){
            ChromeOptions chromeOptions = new ChromeOptions();
            if (param.getIfBackRun()){
                chromeOptions.addArguments("--headless");
            }
            return chromeOptions;
        }
        if (BrowserDriverEnum.firefox == param.getDriverEnum()){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (param.getIfBackRun()){
                firefoxOptions.addArguments("--headless");
            }
            return firefoxOptions;
        }
        return new ChromeOptions();
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
    public static void doWebDriverTask(CreateDriverParam param, Consumer<WebDriver> consumer){
        WebDriver driver;
        try {
            driver = SeleniumUtil.createWebDriver(param);
            consumer.accept(driver);
        } catch (Exception e) {
            log.error("处理selenium脚本异常",e);
        }finally {
            if (param.getIfQuit()){
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
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(seconds==null?5:seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
