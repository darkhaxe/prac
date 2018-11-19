package com.ddd.badcase;

import java.util.List;

/**
 * @author haze
 * @date created at 2018/9/30 下午4:51
 */
abstract class BaseBillReviewExportTemplate<T> {
    public final List<TemplateReplacement> queryAndComposeTemplateReplacementsBy(
            String billNumber) {
        T t = queryFilledDataBy(billNumber);
        return composeTemplateReplacements(t);
    }

    protected abstract T queryFilledDataBy(String billNumber);
    protected abstract List<TemplateReplacement> composeTemplateReplacements(T t);
}