package com.fjy.fxtools.controller.tools;

import com.fjy.fxtools.enums.BrowserDriverEnum;
import com.fjy.fxtools.utils.SeleniumUtil;
import com.fjy.fxtools.utils.thread.ThreadPoolUtil;
import com.fjy.fxtools.view.tools.SeleniumTestToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javax.annotation.Resource;

/**
 * @apiNote  selinuim测试
 * @author fangjy
 */
@FXMLController
public class SeleniumTestToolController extends SeleniumTestToolView {

    @Resource
    private ThreadPoolUtil<?> threadPoolUtil;

    @FXML
    protected void confirmButtonClick() {
        // 开始动画
        loadingImage.setVisible(true);
        rotateTransition.play();
        threadPoolUtil.async(()->{
            SeleniumUtil.doWebDriverTask(BrowserDriverEnum.chrome,d->{
                Platform.runLater(() -> {
                    loadingImage.setVisible(false);
                    rotateTransition.stop();
                });
                d.get("https://www.baidu.com");
            });
        });
        textValue.setText("success");
    }
}