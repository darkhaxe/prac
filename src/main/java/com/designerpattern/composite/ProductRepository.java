package com.designerpattern.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author haze
 * @date created at 2017/12/12 上午11:29
 */
@Data
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    /**
     * 查询单规格
     */
    public List selectBy(Spec spec) {
        ArrayList<Product> foundProds = new ArrayList<>();
        Iterator<Product> prods = iterator();
        while (prods.hasNext()) {
            Product prod = prods.next();
            if (spec.isSatisfiedBy(prod)) {

            }
        }
        return null;
    }

    /**
     * 查询多组规格
     */
    public List selectBy(List<Spec> specs) {
        ArrayList<Product> foundProds = new ArrayList<>();
        Iterator<Product> prods = iterator();
        while (prods.hasNext()) {
            Product prod = prods.next();
            Iterator<Spec> specIterator = specs.iterator();
            boolean satisfiesAllSpecs = true;
            if (specIterator.hasNext()) {
                Spec spec = specIterator.next();
                satisfiesAllSpecs &= spec.isSatisfiedBy(prod);
            }
            if (satisfiesAllSpecs) {
                foundProds.add(prod);
            }
        }
        return foundProds;
    }
}
