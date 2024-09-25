package com.fjy.fxtools.controller.tools;

import com.fjy.fxtools.utils.SeleniumUtil;
import com.fjy.fxtools.utils.thread.ThreadPoolUtil;
import com.fjy.fxtools.view.tools.SeleniumTestToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javax.annotation.Resource;
import org.openqa.selenium.By;

/**
 * @apiNote  selinuim测试
 * @author fangjy
 */
@FXMLController
public class SeleniumTestToolController extends SeleniumTestToolView {

    @Resource
    private ThreadPoolUtil<String> threadPoolUtil;

    @FXML
    protected void confirmButtonClick() {
        // 开始动画
        loadingImage.setVisible(true);
        rotateTransition.play();
        threadPoolUtil.async(()->{
            SeleniumUtil.doWebDriverTask(null,false,d->{
                Platform.runLater(() -> {
                    loadingImage.setVisible(false);
                    rotateTransition.stop();
                });
                d.get("https://cn.bing.com/");
                SeleniumUtil.getWebElementByWait(null,By.id("id_s")).click();
                SeleniumUtil.getWebElementByWait(null,By.className("id_text_signin")).click();
                SeleniumUtil.getWebElementByWait(null,By.id("i0116")).sendKeys("fjy1071875401@outlook.com");
                SeleniumUtil.getWebElementByWait(null,By.id("idSIButton9")).submit();
                SeleniumUtil.getWebElementByWait(null,By.id("i0118")).sendKeys("fjy199202073018");
                SeleniumUtil.getWebElementByWait(null,By.id("idSIButton9")).submit();
                SeleniumUtil.getWebElementByWait(null,By.id("acceptButton")).submit();
            });
            return "success";
        },true);
        threadPoolUtil.get();
        textValue.setText("success"+SeleniumUtil.getWebElementByWait(null,By.id("id_n")).getText());
        SeleniumUtil.quitWebDriver();
    }
}