package com.example.selinuim.controller.home;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
@FXMLController
public class HomeController {


    /**
     * 打开文件
     */
    @FXML
    protected void handleOpen() {
        System.out.println("打开文件...");
    }

    /**
     * 退出软件
     */
    @FXML
    protected void handleExit() {
        System.out.println("退出软件...");
        System.exit(0);
    }
}