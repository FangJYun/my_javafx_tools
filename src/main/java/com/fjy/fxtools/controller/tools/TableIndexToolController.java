package com.fjy.fxtools.controller.tools;

import com.fjy.fxtools.view.tools.TableIndexToolView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
@FXMLController
public class TableIndexToolController extends TableIndexToolView {


    @FXML
    protected void onHelloButtonClick() {
        String taxNum = taxNumTextField.getText();
        userRechargeTable.setText("充值记录表：sys_user_recharge_"+ Math.abs(taxNum.hashCode()) % 32);
    }
}