package com.fjy.fxtools.service;

import cn.hutool.extra.spring.SpringUtil;
import com.fjy.fxtools.enums.IndexMenuPageEnum;
import de.felixroske.jfxsupport.AbstractFxmlView;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 主页service实现
 *
 * @author fangjy
 * @date 2024-09-18 10:53
 **/
@Service
@Slf4j
public class IndexService {
    public void loadPage(BorderPane centerPane,String menuId) {
        try {
            AbstractFxmlView bean = SpringUtil.getBean(IndexMenuPageEnum.getBeanNameByMenuItemId(menuId));
            centerPane.setCenter(bean.getView());
        } catch (Exception e) {
            log.error("页面切换失败",e);
        }
    }
}
