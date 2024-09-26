package com.fjy.fxtools.module;

import com.fjy.fxtools.enums.BrowserDriverEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建浏览器参数
 *
 * @author fangjy
 * @date 2024-09-26 09:30
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateDriverParam {

    /**
     * 驱动枚举
     */
    private BrowserDriverEnum driverEnum;
    /**
     * 执行完是否退出浏览器
     */
    @Builder.Default
    private Boolean ifQuit = true;
    /**
     * 是否后台运行
     */
    @Builder.Default
    private Boolean ifBackRun = true;
}
