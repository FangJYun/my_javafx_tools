package com.fjy.fxtools.utils;

import javafx.scene.Node;

/**
 * 获取屏幕坐标大小工具
 *
 * @author fangjy
 * @date 2024-09-18 09:35
 **/
public class GetScreenUtil {
    public GetScreenUtil() {
    }

    public static double getScreenX(Node control) {
        return control.getScene().getWindow().getX() + control.getScene().getX() + control.localToScene(0.0, 0.0).getX();
    }

    public static double getScreenY(Node control) {
        return control.getScene().getWindow().getY() + control.getScene().getY() + control.localToScene(0.0, 0.0).getY();
    }

    public static double getWidth(Node control) {
        return control.getBoundsInParent().getWidth();
    }

    public static double getHeight(Node control) {
        return control.getBoundsInParent().getHeight();
    }
}
