package com.fjy.fxtools.enums;

import com.fjy.fxtools.fxmlview.tools.BingScriptViewBean;
import com.fjy.fxtools.fxmlview.tools.TableIndexViewBean;
import de.felixroske.jfxsupport.AbstractFxmlView;
import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

/**
 * 首页菜单跳转页面枚举
 *
 * @author fangjy
 * @date 2024-09-18 13:34
 **/
@Getter
public enum IndexMenuPageEnum {

    /**
     * 菜单页面枚举
     */
    TableIndexPageEnum("tableIndexItemId","查表索引", TableIndexViewBean.class),

    SelinuimTestPageEnum("bingScriptItemId","selinuim测试页面", BingScriptViewBean.class),
    ;
    /**
     * 菜单id
     */
    private final String menuItemId;
    /**
     * 菜单名称
     */
    private final String menuItemName;
    /**
     * 菜单id对应的fxmlview的bean
     */
    private final Class<? extends AbstractFxmlView> fxmlViewClass;

    IndexMenuPageEnum(String menuItemId, String menuItemName, Class<? extends AbstractFxmlView> fxmlViewClass) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.fxmlViewClass = fxmlViewClass;
    }

    public static Class<? extends AbstractFxmlView> getBeanNameByMenuItemId(String menuItemId){
        Optional<IndexMenuPageEnum> first = Arrays.stream(values()).filter(v -> v.getMenuItemId().equals(menuItemId)).findFirst();
        return first.<Class<? extends AbstractFxmlView>>map(indexMenuPageEnum -> indexMenuPageEnum.fxmlViewClass).orElse(null);
    }
}
