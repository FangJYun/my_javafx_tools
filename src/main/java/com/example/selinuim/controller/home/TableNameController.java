package com.example.selinuim.controller.home;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
public class TableNameController {

    @FXML
    private Label userRechargeTable;
    @FXML
    private TextField taxNumTextField;

    @FXML
    protected void onHelloButtonClick() {
        String taxNum = taxNumTextField.getText();
        userRechargeTable.setText("充值记录表：sys_user_recharge_"+ Math.abs(taxNum.hashCode()) % 32);
    }
}