package com.fjy.fxtools.controller.tools;

import com.fjy.fxtools.module.CreateDriverParam;
import com.fjy.fxtools.utils.SeleniumUtil;
import com.fjy.fxtools.utils.TooltipUtil;
import com.fjy.fxtools.utils.thread.ThreadPoolUtil;
import com.fjy.fxtools.view.tools.BingScriptToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

/**
 * @apiNote  selinuim测试
 * @author fangjy
 */
@FXMLController
public class BingScriptToolController extends BingScriptToolView {
    @Resource
    private ThreadPoolUtil<String> threadPoolUtil;

    @FXML
    protected void confirmButtonClick() {
        if (StringUtils.isAnyEmpty(accountTextField.getText(),passwdTextField.getText())) {
            TooltipUtil.boxTip(AlertType.WARNING,"帐号或密码不能为空！");
            return;
        }
        // 开始动画
        loadingImage.setVisible(true);
        rotateTransition.play();
        threadPoolUtil.async(()->{
            CreateDriverParam param = CreateDriverParam.builder().ifBackRun(true).ifQuit(false).build();
            SeleniumUtil.doWebDriverTask(param,d->{
                Platform.runLater(() -> {
                    loadingImage.setVisible(false);
                    rotateTransition.stop();
                });
                d.get("https://cn.bing.com/");
                SeleniumUtil.getWebElementByWait(null,By.id("id_s")).click();
                SeleniumUtil.getWebElementByWait(null,By.className("id_text_signin")).click();
                SeleniumUtil.getWebElementByWait(null,By.id("i0116")).sendKeys(accountTextField.getText());
                SeleniumUtil.getWebElementByWait(null,By.id("idSIButton9")).submit();
                SeleniumUtil.getWebElementByWait(null,By.id("i0118")).sendKeys(passwdTextField.getText());
                SeleniumUtil.getWebElementByWait(null,By.id("idSIButton9")).submit();
                SeleniumUtil.getWebElementByWait(null,By.id("acceptButton")).submit();
            });
            Platform.runLater(() -> {
                textValue.setText("success:"+SeleniumUtil.getWebElementByWait(null,By.id("id_n")).getText());
                SeleniumUtil.quitWebDriver();
            });
        });
    }
}