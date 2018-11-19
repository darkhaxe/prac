package com.ddd.badcase;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:51
 */
@Data
@AllArgsConstructor
public class TemplateReplacement {
    private int rowIndex;
    private int cellNum;
    private String replaceValue;
}
