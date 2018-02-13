package com.jdk8.complexStreamOpt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;

/**
 * @author haze
 * @date created at 2018/1/27 上午9:51
 */
public class ItemUtil {
    private static Logger logger = LoggerFactory.getLogger(ItemUtil.class);
    // 这个配置含有新老itemId映射的信息以及获取orderNo, sID 的字段信息
    private static List<String>
            itemBaseDataConf = Arrays.asList("item:", "item:item_core_id",
            "item:order_no", "item:s_id");

    private static Map<String, String> itemIdConf = new HashMap() {
        {
            put("item", "item:item_core_id");
            put("item_core", "item_core:id");
            put("item_price", "item_price:item_id");
            put("item_price_change_log", "item_price_change_log:item_id");
        }
    };

    /**
     * 聚合一个订单下的所有商品信息
     *
     * @param itemIndexMap 一个订单所有商品的信息映射
     * @return 一个订单下的所有商品信息
     * <p>
     * key 是 sID + order_no + item_id ;
     */
    private static Map<String, Map<String, Object>> mergeOrderItemMap(Map<String, Map<String, String>> itemIndexMap) {

        if (itemIndexMap == null || itemIndexMap.isEmpty()) {
            return new HashMap<>();
        }

        // Map[oldItemId, newItemId]
        Map<String, String> old2newItemIdMap = new HashMap<>();
        Map<String, String> new2oldItemIdMap = new HashMap<>();

        Set<Map.Entry<String, Map<String, String>>> entries = itemIndexMap.entrySet();
        String orderNo = "";
        String kdtId = "";

        // 构建itemID映射
        for (Map.Entry<String, Map<String, String>> entry : entries) {
            String indexKey = entry.getKey();
            Map<String, String> value = entry.getValue();

            if (indexKey.startsWith(itemBaseDataConf.get(0))) {
                old2newItemIdMap.put(indexKey, value.get(itemBaseDataConf.get(1)));
                new2oldItemIdMap.put(value.get(itemBaseDataConf.get(1)), indexKey);
                orderNo = value.get(itemBaseDataConf.get(2));
                kdtId = value.get(itemBaseDataConf.get(3));
            }
        }

        Map<String, Map<String, Object>> newItemIndexMap = aggregationAllInfoOfEachItem(itemIndexMap, new2oldItemIdMap);
        return buildFinalOrderItemMap(newItemIndexMap, old2newItemIdMap, orderNo, kdtId);

    }

    /*
     * 聚合每个商品的所有信息
     *
     * Map[item:id, Map[table:field, value]]
     */
    private static Map<String, Map<String, Object>> aggregationAllInfoOfEachItem(Map<String, Map<String, String>> itemIndexMap, Map<String, String> new2oldItemIdMap) {

        Map<String, Map<String, Object>> newItemIndexMap = new HashMap<>();

        itemIndexMap.forEach(
                (indexKey, value) -> {

                    String table = indexKey.split(":")[0];
                    if (itemIdConf.containsKey(table)) {
                        String itemCoreIdField = itemIdConf.get(table);
                        String itemCoreId = itemIndexMap.get(indexKey).get(itemCoreIdField);
                        putNewIndexMap(newItemIndexMap, indexKey, value,
                                key -> new2oldItemIdMap.get(itemCoreId));
                    }
                }
        );

        return newItemIndexMap;

    }

    /*
     * 将各商品信息聚合到相应的原itemId的键下
     */
    private static void putNewIndexMap(Map<String, Map<String, Object>> newItemIndexMap,
                                       String indexKey, Map<String, String> value, Function<String, String> getOriginItemIdFunc) {
        String originItemId = getOriginItemIdFunc.apply(indexKey);
        if (newItemIndexMap.get(originItemId) == null) {
            newItemIndexMap.put(originItemId, new HashMap<>());
        }
//        Map<String, Object> srcMap = newItemIndexMap.get(originItemId);
//        newItemI
    }

    /**
     * 构建最终的订单商品信息
     *
     * @param itemIndexMap     商品信息
     * @param old2newItemIdMap 新老itemId映射
     * @param orderNo          订单号
     * @param sID              店铺号
     * @return 订单商品扩展信息
     */
    private static Map<String, Map<String, Object>> buildFinalOrderItemMap(Map<String, Map<String, Object>> itemIndexMap,
                                                                           Map<String, String> old2newItemIdMap,
                                                                           String orderNo, String sID) {
        Map<String, Map<String, Object>> finalResult = new HashMap<>();

        Set<Map.Entry<String, Map<String, Object>>> entries = itemIndexMap.entrySet();

        for (Map.Entry<String, Map<String, Object>> entry : entries) {
            String indexKey = entry.getKey();
            Map<String, Object> value = entry.getValue();

            String itemId = indexKey.split(":")[1];

            String itemKey = sID + "_" + orderNo + "_" + itemId;
            finalResult.put(itemKey, value);
        }
        return finalResult;
    }

    /**
     * 构建一个订单的所有商品级别的信息以及映射
     *
     * @param itemInfoMap 商品级别的信息
     * @return 一个订单的所有商品的信息
     * <p>
     * NOTE: itemInfoMap 是对应一个订单的所有商品的信息的映射，不要传多个订单的信息进来，可能重复
     * <p>
     * key = table:table_unique_id , value = map [ table:field, value ]
     * <p>
     * eg. map [ item:goods_type:1800888 = 0 , item:num:1800888 = 8 ]
     * will be transformed into map[item:1800888 = map[item:goods_type=0 , item:num=8]]
     */
    public static Map<String, Map<String, String>> buildItemIndexMap(Map<String, String> itemInfoMap) {
        Map<String, Map<String, String>> itemIndexMap = new HashMap<>();

        itemInfoMap.forEach(
                (key, value) -> {
                    String[] keyparts = key.split(":");

                    // 只考虑三段式 tablename:field:id
                    if (keyparts != null && keyparts.length == 3) {
                        String table = keyparts[0];
                        String field = keyparts[1];
                        String index = keyparts[2];

                        String indexKey = table + ":" + index;
                        String fieldKey = table + ":" + field;
                        if (itemIndexMap.get(indexKey) == null) {
                            itemIndexMap.put(indexKey, new HashMap<>());
                        }
                        itemIndexMap.get(indexKey).put(fieldKey, String.valueOf(value));
                    }
                }
        );

        return itemIndexMap;
    }

}
