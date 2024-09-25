package com.fjy.fxtools.view.tools;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import lombok.Data;

/**
 * 表索引视图控件
 *
 * @author fangjy
 * @date 2024-09-18 09:57
 **/
@Data
public abstract class BingScriptToolView implements Initializable {

    @FXML
    protected Label textValue;
    @FXML
    public StackPane loadingPane;
    @FXML
    public ImageView loadingImage;
    @FXML
    public TextField accountTextField;
    @FXML
    public TextField passwdTextField;
    protected RotateTransition rotateTransition;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 初始化动画
        rotateTransition = new RotateTransition(Duration.seconds(1), loadingImage);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        rotateTransition.pause();
    }

}
