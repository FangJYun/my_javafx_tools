package com.fjy.fxtools.view.tools;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lombok.Data;

/**
 * 表索引视图控件
 *
 * @author fangjy
 * @date 2024-09-18 09:57
 **/
@Data
public abstract class TableIndexToolView {

    @FXML
    protected Label userRechargeTable;
    @FXML
    protected TextField taxNumTextField;
}
