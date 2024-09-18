package com.fjy.fxtools.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.OutputStreamAppender;
import com.fjy.fxtools.utils.TooltipUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;


/**
 * @author fangjy
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class ConsoleLogAppender extends OutputStreamAppender<ILoggingEvent> {
    public final static List<TextArea> TEXT_AREA_LIST = new ArrayList<>();

    @Override
    public void start() {
        OutputStream targetStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                for (TextArea textArea : TEXT_AREA_LIST) {
                    textArea.appendText(b + "\n");
                }
            }

            @Override
            public void write(byte[] b) throws IOException {
                for (TextArea textArea : TEXT_AREA_LIST) {
                    textArea.appendText(new String(b) + "\n");
                }
            }
        };
        setOutputStream(targetStream);
        super.start();
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (eventObject.getLevel() == Level.ERROR) {
            try {
                TooltipUtil.showToast("发生错误:\n" + eventObject.getFormattedMessage());
            } catch (Exception e) {
                log.error("提示方法报错",e);
            }
        }
        super.append(eventObject);
    }
}
