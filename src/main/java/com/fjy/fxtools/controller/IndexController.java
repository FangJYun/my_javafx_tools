package com.fjy.fxtools.controller;

import com.fjy.fxtools.service.IndexService;
import com.fjy.fxtools.view.IndexView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @apiNote  首页控制器
 * @author fangjy
 */
@FXMLController
@Slf4j
public class IndexController extends IndexView {
    @Resource
    private IndexService indexService;

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

    @FXML
    public void changeIndexView(ActionEvent actionEvent) {
        indexService.loadPage(mainPane,((MenuItem)actionEvent.getSource()).getId());
    }
}