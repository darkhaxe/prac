package com.refactor.composite;

import java.util.List;

/**
 * @author haze
 * @date created at 2017/12/12 上午11:45
 */
public class CompositeSpec extends Spec {
    private List<Spec> specs;

    public CompositeSpec(List<Spec> specs) {
        this.specs = specs;
    }

    @Override
    boolean isSatisfiedBy(Product product) {
        return false;
    }

    public List<Spec> getSpecs() {
        return specs;
    }
}
