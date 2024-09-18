package com.fjy.fxtools.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.tools.Utils;

/**
 * 错误提示tip工具
 *
 * @author fangjy
 * @since  2024-09-18 09:31
 **/
public class TooltipUtil {
    private static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public static void showToast(String message) {
        showToast((Node)null, message);
    }

    public static void showToast(Node node, String message) {
        Window window = Utils.getWindow(node);
        double x;
        double y;
        if (node != null) {
            x = GetScreenUtil.getScreenX(node) + GetScreenUtil.getWidth(node) / 2.0;
            y = GetScreenUtil.getScreenY(node) + GetScreenUtil.getHeight(node);
        } else {
            x = window.getX() + window.getWidth() / 2.0;
            y = window.getY() + window.getHeight();
        }

        showToast(window, message, 3000L, x, y);
    }

    public static void showToast(Window window, String message, long time, double x, double y) {
        final Tooltip tooltip = new Tooltip(message);
        tooltip.setAutoHide(true);
        tooltip.setOpacity(0.9);
        tooltip.setWrapText(true);
        tooltip.show(window, x, y);
        tooltip.setAnchorX(tooltip.getAnchorX() - tooltip.getWidth() / 2.0);
        tooltip.setAnchorY(tooltip.getAnchorY() - tooltip.getHeight());
        if (time > 0L) {
            executor.schedule(()->Platform.runLater(tooltip::hide)
                    ,time, TimeUnit.SECONDS);
        }

    }

    public static void showToast(String message, Pos pos) {
        showToast(null, message, null, 3.0, pos, null, null, true, true);
    }

    public static void showToast(String title, String message) {
        showToast(title, message, null, 3.0, Pos.BOTTOM_CENTER, null, null, true, true);
    }

    public static void showToast(String title, String message, Pos pos) {
        showToast(title, message, (Node)null, 3.0, pos, (EventHandler)null, (Object)null, true, true);
    }

    public static void showToast(String title, String message, Node graphic, double hideTime, Pos pos, EventHandler<ActionEvent> onAction, Object owner, boolean isHideCloseButton, boolean isDarkStyle) {
        Notifications notificationBuilder = Notifications.create().title(title).text(message).graphic(graphic).hideAfter(Duration.seconds(hideTime)).position(pos).onAction(onAction);
        if (owner != null) {
            notificationBuilder.owner(owner);
        }

        if (isHideCloseButton) {
            notificationBuilder.hideCloseButton();
        }

        if (isDarkStyle) {
            notificationBuilder.darkStyle();
        }

        Platform.runLater(() -> {
            notificationBuilder.show();
        });
    }
}
