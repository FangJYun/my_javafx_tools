package com.fjy.fxtools.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import lombok.extern.slf4j.Slf4j;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
@FXMLController
@Slf4j
public class IndexController {


    /**
     * 打开文件
     */
    @FXML
    protected void handleOpen() {
        log.error("dddd");
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