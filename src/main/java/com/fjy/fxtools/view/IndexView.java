package com.fjy.fxtools.view;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import lombok.Data;

/**
 * 主页视图控件
 *
 * @author fangjy
 * @date 2024-09-18 09:52
 **/
@Data
public abstract class IndexView {
    @FXML
    protected BorderPane mainPane;
    @FXML
    protected MenuItem tableIndexItemId;
    @FXML
    protected MenuItem selinuimTestItemId;
}
