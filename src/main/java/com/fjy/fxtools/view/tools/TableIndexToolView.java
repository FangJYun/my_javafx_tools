package com.fjy.fxtools.view.tools;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import lombok.Data;

/**
 * 表索引视图控件
 *
 * @author fangjy
 * @date 2024-09-18 09:57
 **/
@Data
public abstract class TableIndexToolView implements Initializable {

    @FXML
    protected Label resultTable;
    @FXML
    protected TextField keyTextField;
    @FXML
    protected TextField countTextField;
    @FXML
    protected RadioButton hashCode;
    protected ToggleGroup algorithmGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindingGroup();
    }

    private void bindingGroup() {
        algorithmGroup = new ToggleGroup();
        hashCode.setToggleGroup(algorithmGroup);
    }
}
