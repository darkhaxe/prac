package com.unittest;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;

//import org.apache.commons.io.IOUtils;
public class JsonDiff {
    public static void main(String[] args) {
        String carV1 = "{\n" +
                "    \"result\": \"000\",\n" +
                "    \"desc\": \"操作成功！\",\n" +
                "    \"data\": {\n" +
                "        \"shopCarList\": [\n" +
                "            {\n" +
                "                \"shopId\": \"f3767d2d23e246488524c0ac6ea81f11\",\n" +
                "                \"shopName\": \"1111分位分位\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"64f225686ac5466e849dac76111761fd\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"1fefae39a3554c25bcb1284de09a03df\",\n" +
                "                        \"productId\": \"677264b8df904a2386ea4c84a4decf4d\",\n" +
                "                        \"productName\": \"休闲西装男-分销代发7.55xx\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1501\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 20,\n" +
                "                        \"activityPrice\": 20,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/image/pft/2017/12/15/5200dcae22fe4b4b9a61cbd1340cc01d.jpg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"59c73a3d1cb743dd952e1a4fd01c3114\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"5195930d771b42b3b553ecca6ae40a72\",\n" +
                "                        \"productId\": \"b8c8ee5825c34fca8a0374496b2812cb\",\n" +
                "                        \"productName\": \"马甲\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"18\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 20,\n" +
                "                        \"activityPrice\": 60,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/2017/07/26/68197a14-de10-48b7-b399-6beee7ebab74.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": [\n" +
                "                    {\n" +
                "                        \"promotionId\": \"ad46d62763bd4505a4178245603bbdb0\",\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"couponHint\": \"以下商品每满60.00减5.00\",\n" +
                "                        \"seeMoreUrl\": \"https://apptest.zhidianlife.com/mobilemall/platform_aty/fullReduction/index.html?sessionId=9cb7bd5c3090480585856f21106cd83c@10287c1bc4bd4eb4b03aa38d75d7562e\",\n" +
                "                        \"couponInfo\": [\n" +
                "                            {\n" +
                "                                \"couponId\": \"91f2c505f18f4aa7907c2720b5cdb500\",\n" +
                "                                \"useAmount\": 5,\n" +
                "                                \"amount\": 60,\n" +
                "                                \"status\": \"1\",\n" +
                "                                \"startTime\": \"2018.08.22\",\n" +
                "                                \"endTime\": \"2018.08.31\",\n" +
                "                                \"remark\": \"测试测试\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"carProdsBelongTo\": [\n" +
                "                            \"64f225686ac5466e849dac76111761fd\"\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"da672b550a4747dc952f41bf6d9483fc\",\n" +
                "                \"shopName\": \"蜘点直营商城\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"1\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"141b1b01d0ee4c8a92b0c05ea4583afd\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"套\",\n" +
                "                        \"skuId\": \"b749a43da6394b7c9d2c96fba6203ff1\",\n" +
                "                        \"productId\": \"03e00da1fd94489091b5685843ab65af\",\n" +
                "                        \"productName\": \"预售Xoxoxo西服\",\n" +
                "                        \"commodityType\": \"13\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1501\",\n" +
                "                        \"titleTag\": [\n" +
                "                            7\n" +
                "                        ],\n" +
                "                        \"price\": 62.5,\n" +
                "                        \"activityPrice\": 62.5,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"productTagList\": [\n" +
                "                            {\n" +
                "                                \"width\": \"70\",\n" +
                "                                \"tagPicUrl\": \"http://img.zhidianlife.com/image/2018/01/25/2ef8ca3d1cf44acf9ba289d7c1839d37.png\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": true,\n" +
                "                        \"superMarket\": true,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/03/30/4e2ea3c5-b46d-443a-b9ff-c08eb0e0c59d.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"3f2ba85ba94749be87116afa7833cb87\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"e5908f0976fc43ba9640b76ea151cfeb\",\n" +
                "                        \"productId\": \"ef2f858aab364a4c8a4abc3fa06c259c\",\n" +
                "                        \"productName\": \"透明玻璃水杯\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 29.9,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 987,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/05/14/eaf93476-6314-407f-abb5-df27faf6332b.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:藏青色;尺寸:S\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"84512995a2894eeca4a9a7df96d66b64\",\n" +
                "                        \"quantity\": 6,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"a95164cf90bc456e92b8adea80ddc685\",\n" +
                "                        \"productId\": \"b9c3e1e4286d48a690601d805eff2cc5\",\n" +
                "                        \"productName\": \"异常铺货商品001\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 11,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 42,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/image/2017/07/18/8eb482743c664c6fa0247c3bc780204f.jpg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": [\n" +
                "                    {\n" +
                "                        \"promotionId\": \"ad46d62763bd4505a4178245603bbdb0\",\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"couponHint\": \"以下商品每满60.00减5.00\",\n" +
                "                        \"seeMoreUrl\": \"https://apptest.zhidianlife.com/mobilemall/platform_aty/fullReduction/index.html?sessionId=9cb7bd5c3090480585856f21106cd83c@10287c1bc4bd4eb4b03aa38d75d7562e\",\n" +
                "                        \"couponInfo\": [\n" +
                "                            {\n" +
                "                                \"couponId\": \"91f2c505f18f4aa7907c2720b5cdb500\",\n" +
                "                                \"useAmount\": 5,\n" +
                "                                \"amount\": 60,\n" +
                "                                \"status\": \"1\",\n" +
                "                                \"startTime\": \"2018.08.22\",\n" +
                "                                \"endTime\": \"2018.08.31\",\n" +
                "                                \"remark\": \"测试测试\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"carProdsBelongTo\": [\n" +
                "                            \"141b1b01d0ee4c8a92b0c05ea4583afd\"\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"ccfb844415a549f2b3a33d032cc054c0\",\n" +
                "                \"shopName\": \"lmz-综合仓\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"8\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"b9507c53cf5e4793bc5c6bdf0efdf0fa\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"9782884f46ff4ca585c95035d09ef97e\",\n" +
                "                        \"productId\": \"35fc9986ec814399bfbfc3b0fe9959e9\",\n" +
                "                        \"productName\": \"虎牙-T恤\",\n" +
                "                        \"commodityType\": \"8\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 70,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 88,\n" +
                "                        \"terminal\": \"2\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/2017/07/07/671b5b40-9097-4290-8adb-21b6de3afc0d.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": \"下列商品仅配送本仓附近3km,下单2小时送达\",\n" +
                "                    \"preSale\": \"下列商品不限制配送距离,下单次日送达\"\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"e4181bae0a5744fd90cfbd1cdd06c467\",\n" +
                "                \"shopName\": \"游戏币的移动商城\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"7\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"ca90491aeb844a6cb0e983fa55c8bc4a\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"2f3bbfa0c5ac477e9b49520e3a7afd9f\",\n" +
                "                        \"productId\": \"5fb50d944642447da6d643b9a9c08870\",\n" +
                "                        \"productName\": \"奥丝蓝黛\",\n" +
                "                        \"commodityType\": \"7\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 60,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/2017/06/12/992c677c-7e59-4106-abf2-c34bf8716c28.jpg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"c818f380670f49f4aba02a96d6bb5f69\",\n" +
                "                \"shopName\": \"lmz\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"253032f2ec57403db42a5fcc52d21fc1\",\n" +
                "                        \"quantity\": 3,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"ae04f9ec9fcc41f5a82109adb014d51d\",\n" +
                "                        \"productId\": \"096acaa228ad485e9eae10c67309773e\",\n" +
                "                        \"productName\": \"休闲裤4.3\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"18\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 70,\n" +
                "                        \"activityPrice\": 50,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/04/03/2cb337ed-07c3-480f-a350-a92015667b83.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"e27248f94aef4177af4b3f2c2651b928\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"84bb268c55fc4e6186f20f14ee7c8241\",\n" +
                "                        \"productId\": \"da3dd7f90fd243e8bcf1ea7cbf99b2a8\",\n" +
                "                        \"productName\": \"kuku---裤子\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"18\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 50,\n" +
                "                        \"activityPrice\": 40,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/04/2f316cd7-fe8c-44c2-80b2-58867098103f.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"e698a83ba6a14a55b86235ca6a69507f\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"31d16c1d53664e21a15f301328f6e4ba\",\n" +
                "                        \"productId\": \"31d16c1d53664e21a15f301328f6e4ba\",\n" +
                "                        \"productName\": \"雅培亲体金装喜康力幼儿配方奶粉三段900g（1-3岁）\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 196,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/12/1001512.jpg\",\n" +
                "                        \"saleattr\": \"\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"7d136fb2d379464a9e694ed1b9be1ba8\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"19dcbd61444c45bfbc33d37056eece1a\",\n" +
                "                        \"productId\": \"19dcbd61444c45bfbc33d37056eece1a\",\n" +
                "                        \"productName\": \"美赞臣安儿健A+儿童配方奶粉四段三连装1200g（3岁以上）\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 176,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/12/1001541.jpg\",\n" +
                "                        \"saleattr\": \"\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"0118f342aae9475e9ee6801ada53f5ee\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"d3252fc88b5a48548cd5d6f915327b7f\",\n" +
                "                        \"productId\": \"dc5c5a1ff55d4cc1a6bf2d1124980ca1\",\n" +
                "                        \"productName\": \"美Tshirt\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"18\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 150,\n" +
                "                        \"activityPrice\": 60,\n" +
                "                        \"stock\": 585,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/03/30/ecc15576-b700-405f-8a38-eb4ab7a07b94.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黄色;尺寸:XXL\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            }\n" +
                "        ],\n" +
                "        \"expiredList\": [\n" +
                "            {\n" +
                "                \"shopId\": \"c818f380670f49f4aba02a96d6bb5f69\",\n" +
                "                \"shopName\": \"lmz\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"4dbaa79e437a4f209c920651a55ff829\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"2a1ab0d34c7d472c9189422a31bb6123\",\n" +
                "                        \"productId\": \"14d1547ea379425684dea20890205df4\",\n" +
                "                        \"productName\": \"喵喵奥卫衣\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 45,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"1\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": null,\n" +
                "                        \"activityTagList\": null,\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": \"440000\",\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/07/05/a21b4ab2-e5c8-4f9a-963f-0db71d4d898d.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": null,\n" +
                "                \"couponList\": []\n" +
                "            }\n" +
                "        ],\n" +
                "        \"notice\": {\n" +
                "            \"noticeId\": null,\n" +
                "            \"noticeLeftIcon\": \"http://img.zhidianlife.com/image/2017/03/07/9974690e1a5b4915aa754ba3f0b4d907.png\",\n" +
                "            \"noticeContent\": \"蜘点到家购物，两小时送达！\",\n" +
                "            \"noticeUrl\": \"https://m.zhidianlife.com/mm_aty/aty_201611/act_announcement.html\"\n" +
                "        },\n" +
                "        \"count\": 24\n" +
                "    }\n" +
                "}";

        String carV2 = "{\n" +
                "    \"result\": \"000\",\n" +
                "    \"desc\": \"操作成功！\",\n" +
                "    \"data\": {\n" +
                "        \"shopCarList\": [\n" +
                "            {\n" +
                "                \"shopId\": \"da672b550a4747dc952f41bf6d9483fc\",\n" +
                "                \"shopName\": \"蜘点直营商城\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"1\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"141b1b01d0ee4c8a92b0c05ea4583afd\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"套\",\n" +
                "                        \"skuId\": \"b749a43da6394b7c9d2c96fba6203ff1\",\n" +
                "                        \"productId\": \"03e00da1fd94489091b5685843ab65af\",\n" +
                "                        \"productName\": \"预售Xoxoxo西服\",\n" +
                "                        \"commodityType\": \"13\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 62.5,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [\n" +
                "                            {\n" +
                "                                \"width\": \"70\",\n" +
                "                                \"tagPicUrl\": \"http://img.zhidianlife.com/image/2018/01/25/2ef8ca3d1cf44acf9ba289d7c1839d37.png\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": true,\n" +
                "                        \"superMarket\": true,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/03/30/4e2ea3c5-b46d-443a-b9ff-c08eb0e0c59d.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"3f2ba85ba94749be87116afa7833cb87\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"e5908f0976fc43ba9640b76ea151cfeb\",\n" +
                "                        \"productId\": \"ef2f858aab364a4c8a4abc3fa06c259c\",\n" +
                "                        \"productName\": \"透明玻璃水杯\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 29.9,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 987,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/05/14/eaf93476-6314-407f-abb5-df27faf6332b.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:藏青色;尺寸:S\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"84512995a2894eeca4a9a7df96d66b64\",\n" +
                "                        \"quantity\": 6,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"a95164cf90bc456e92b8adea80ddc685\",\n" +
                "                        \"productId\": \"b9c3e1e4286d48a690601d805eff2cc5\",\n" +
                "                        \"productName\": \"异常铺货商品001\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 11,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 42,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/image/2017/07/18/8eb482743c664c6fa0247c3bc780204f.jpg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": [\n" +
                "                    {\n" +
                "                        \"promotionId\": \"ad46d62763bd4505a4178245603bbdb0\",\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"couponHint\": \"以下商品每满60.00减5.00\",\n" +
                "                        \"seeMoreUrl\": \"https://apptest.zhidianlife.com/mobilemall/platform_aty/fullReduction/index.html?sessionId=9cb7bd5c3090480585856f21106cd83c@10287c1bc4bd4eb4b03aa38d75d7562e\",\n" +
                "                        \"couponInfo\": [\n" +
                "                            {\n" +
                "                                \"couponId\": \"91f2c505f18f4aa7907c2720b5cdb500\",\n" +
                "                                \"useAmount\": 5,\n" +
                "                                \"amount\": 60,\n" +
                "                                \"status\": \"1\",\n" +
                "                                \"startTime\": \"2018.08.22\",\n" +
                "                                \"endTime\": \"2018.08.31\",\n" +
                "                                \"remark\": \"测试测试\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"carProdsBelongTo\": [\n" +
                "                            \"141b1b01d0ee4c8a92b0c05ea4583afd\"\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"e4181bae0a5744fd90cfbd1cdd06c467\",\n" +
                "                \"shopName\": \"游戏币的移动商城\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"7\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"ca90491aeb844a6cb0e983fa55c8bc4a\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"2f3bbfa0c5ac477e9b49520e3a7afd9f\",\n" +
                "                        \"productId\": \"5fb50d944642447da6d643b9a9c08870\",\n" +
                "                        \"productName\": \"奥丝蓝黛\",\n" +
                "                        \"commodityType\": \"7\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 60,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/2017/06/12/992c677c-7e59-4106-abf2-c34bf8716c28.jpg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"c818f380670f49f4aba02a96d6bb5f69\",\n" +
                "                \"shopName\": \"lmz\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"253032f2ec57403db42a5fcc52d21fc1\",\n" +
                "                        \"quantity\": 3,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"ae04f9ec9fcc41f5a82109adb014d51d\",\n" +
                "                        \"productId\": \"096acaa228ad485e9eae10c67309773e\",\n" +
                "                        \"productName\": \"休闲裤4.3\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 70,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/04/03/2cb337ed-07c3-480f-a350-a92015667b83.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"e27248f94aef4177af4b3f2c2651b928\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"84bb268c55fc4e6186f20f14ee7c8241\",\n" +
                "                        \"productId\": \"da3dd7f90fd243e8bcf1ea7cbf99b2a8\",\n" +
                "                        \"productName\": \"kuku---裤子\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 50,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/04/2f316cd7-fe8c-44c2-80b2-58867098103f.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"e698a83ba6a14a55b86235ca6a69507f\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"31d16c1d53664e21a15f301328f6e4ba\",\n" +
                "                        \"productId\": \"31d16c1d53664e21a15f301328f6e4ba\",\n" +
                "                        \"productName\": \"雅培亲体金装喜康力幼儿配方奶粉三段900g（1-3岁）\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 196,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/12/1001512.jpg\",\n" +
                "                        \"saleattr\": \"\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"7d136fb2d379464a9e694ed1b9be1ba8\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"19dcbd61444c45bfbc33d37056eece1a\",\n" +
                "                        \"productId\": \"19dcbd61444c45bfbc33d37056eece1a\",\n" +
                "                        \"productName\": \"美赞臣安儿健A+儿童配方奶粉四段三连装1200g（3岁以上）\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 176,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/06/12/1001541.jpg\",\n" +
                "                        \"saleattr\": \"\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"0118f342aae9475e9ee6801ada53f5ee\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"d3252fc88b5a48548cd5d6f915327b7f\",\n" +
                "                        \"productId\": \"dc5c5a1ff55d4cc1a6bf2d1124980ca1\",\n" +
                "                        \"productName\": \"美Tshirt\",\n" +
                "                        \"commodityType\": \"1\",\n" +
                "                        \"belongType\": \"0\",\n" +
                "                        \"belongName\": \"直营\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 150,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 585,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/03/30/ecc15576-b700-405f-8a38-eb4ab7a07b94.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黄色;尺寸:XXL\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"ccfb844415a549f2b3a33d032cc054c0\",\n" +
                "                \"shopName\": \"lmz-综合仓\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"8\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"b9507c53cf5e4793bc5c6bdf0efdf0fa\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"9782884f46ff4ca585c95035d09ef97e\",\n" +
                "                        \"productId\": \"35fc9986ec814399bfbfc3b0fe9959e9\",\n" +
                "                        \"productName\": \"虎牙-T恤\",\n" +
                "                        \"commodityType\": \"8\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 70,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 88,\n" +
                "                        \"terminal\": \"2\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/2017/07/07/671b5b40-9097-4290-8adb-21b6de3afc0d.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": \"下列商品仅配送本仓附近3km,下单2小时送达\",\n" +
                "                    \"preSale\": \"下列商品不限制配送距离,下单次日送达\"\n" +
                "                },\n" +
                "                \"couponList\": []\n" +
                "            },\n" +
                "            {\n" +
                "                \"shopId\": \"f3767d2d23e246488524c0ac6ea81f11\",\n" +
                "                \"shopName\": \"1111分位分位\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"64f225686ac5466e849dac76111761fd\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"1fefae39a3554c25bcb1284de09a03df\",\n" +
                "                        \"productId\": \"677264b8df904a2386ea4c84a4decf4d\",\n" +
                "                        \"productName\": \"休闲西装男-分销代发7.55xx\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 20,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"http://img2.zhidianlife.com/image/pft/2017/12/15/5200dcae22fe4b4b9a61cbd1340cc01d.jpg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"carId\": \"59c73a3d1cb743dd952e1a4fd01c3114\",\n" +
                "                        \"quantity\": 2,\n" +
                "                        \"unit\": \"件\",\n" +
                "                        \"skuId\": \"5195930d771b42b3b553ecca6ae40a72\",\n" +
                "                        \"productId\": \"b8c8ee5825c34fca8a0374496b2812cb\",\n" +
                "                        \"productName\": \"马甲\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 20,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"0\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/2017/07/26/68197a14-de10-48b7-b399-6beee7ebab74.jpeg\",\n" +
                "                        \"saleattr\": \"颜色:黑色;尺寸:S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": {\n" +
                "                    \"normal\": null,\n" +
                "                    \"preSale\": null\n" +
                "                },\n" +
                "                \"couponList\": [\n" +
                "                    {\n" +
                "                        \"promotionId\": \"ad46d62763bd4505a4178245603bbdb0\",\n" +
                "                        \"couponType\": \"1\",\n" +
                "                        \"couponHint\": \"以下商品每满60.00减5.00\",\n" +
                "                        \"seeMoreUrl\": \"https://apptest.zhidianlife.com/mobilemall/platform_aty/fullReduction/index.html?sessionId=9cb7bd5c3090480585856f21106cd83c@10287c1bc4bd4eb4b03aa38d75d7562e\",\n" +
                "                        \"couponInfo\": [\n" +
                "                            {\n" +
                "                                \"couponId\": \"91f2c505f18f4aa7907c2720b5cdb500\",\n" +
                "                                \"useAmount\": 5,\n" +
                "                                \"amount\": 60,\n" +
                "                                \"status\": \"1\",\n" +
                "                                \"startTime\": \"2018.08.22\",\n" +
                "                                \"endTime\": \"2018.08.31\",\n" +
                "                                \"remark\": \"测试测试\"\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"carProdsBelongTo\": [\n" +
                "                            \"64f225686ac5466e849dac76111761fd\"\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ],\n" +
                "        \"expiredList\": [\n" +
                "            {\n" +
                "                \"shopId\": \"c818f380670f49f4aba02a96d6bb5f69\",\n" +
                "                \"shopName\": \"lmz\",\n" +
                "                \"shopLogo\": \"\",\n" +
                "                \"shopType\": \"5\",\n" +
                "                \"products\": [\n" +
                "                    {\n" +
                "                        \"carId\": \"4dbaa79e437a4f209c920651a55ff829\",\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unit\": \"4\",\n" +
                "                        \"skuId\": \"2a1ab0d34c7d472c9189422a31bb6123\",\n" +
                "                        \"productId\": \"14d1547ea379425684dea20890205df4\",\n" +
                "                        \"productName\": \"喵喵奥卫衣\",\n" +
                "                        \"commodityType\": \"5\",\n" +
                "                        \"belongType\": \"1\",\n" +
                "                        \"belongName\": \"加盟\",\n" +
                "                        \"saleType\": \"1\",\n" +
                "                        \"titleTag\": [],\n" +
                "                        \"price\": 45,\n" +
                "                        \"activityPrice\": null,\n" +
                "                        \"stock\": 999,\n" +
                "                        \"terminal\": \"1\",\n" +
                "                        \"isEnable\": \"1\",\n" +
                "                        \"minSale\": null,\n" +
                "                        \"couponType\": null,\n" +
                "                        \"productTagList\": [],\n" +
                "                        \"activityTagList\": [],\n" +
                "                        \"agentShopId\": null,\n" +
                "                        \"provinceCode\": null,\n" +
                "                        \"advancePreSale\": false,\n" +
                "                        \"superMarket\": false,\n" +
                "                        \"image\": \"https://img2.zhidianlife.com/image/2018/07/05/a21b4ab2-e5c8-4f9a-963f-0db71d4d898d.jpeg\",\n" +
                "                        \"saleattr\": \"尺寸:S;颜色:黑色\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"distributionHint\": null,\n" +
                "                \"couponList\": []\n" +
                "            }\n" +
                "        ],\n" +
                "        \"notice\": {\n" +
                "            \"noticeId\": null,\n" +
                "            \"noticeLeftIcon\": \"http://img.zhidianlife.com/image/2017/03/07/9974690e1a5b4915aa754ba3f0b4d907.png\",\n" +
                "            \"noticeContent\": \"蜘点到家购物，两小时送达！\",\n" +
                "            \"noticeUrl\": \"https://m.zhidianlife.com/mm_aty/aty_201611/act_announcement.html\"\n" +
                "        },\n" +
                "        \"count\": 24\n" +
                "    }\n" +
                "}";
        JSONObject json1 = JSONObject.fromObject(carV1);
        JSONObject json2 = JSONObject.fromObject(carV2);
        compareJson(json1, json2, null);
    }

    public static void compareJson(JSONObject json1, JSONObject json2, String key) {
        Iterator i = json1.keys();
        while (i.hasNext()) {
            try {
                key = (String) i.next();
                compareJson(json1.get(key), json2.get(key), key);
            } catch (Exception e) {
                System.out.println("error:" + i.next() + " error:" + e.getMessage());
            }
        }
    }

    public static void compareJson(Object json1, Object json2, String key) {
        if (json1 instanceof JSONObject) {
            compareJson((JSONObject) json1, (JSONObject) json2, key);
        } else if (json1 instanceof JSONArray) {
            compareJson((JSONArray) json1, (JSONArray) json2, key);
        } else if (json1 instanceof String) {
            compareJson((String) json1, (String) json2, key);
        } else {
            compareJson(json1.toString(), json2.toString(), key);
        }
    }

    public static void compareJson(String str1, String str2, String key) {
        if (!str1.equals(str2)) {
            System.out.println("key:[" + key + "] old:" + str1 + ",new:" + str2);
        }
    }

    public static void compareJson(JSONArray json1, JSONArray json2, String key) {
        Iterator i1 = json1.iterator();
        Iterator i2 = json2.iterator();
        while (i1.hasNext()) {
            compareJson(i1.next(), i2.next(), key);
        }
    }

    public static JSONObject getJson(String url) {
        try {
            URL url1 = new URL(url);
            InputStream in = url1.openStream();
            OutputStream out = new ByteArrayOutputStream();
//            IOUtils.copyCurrentSolution(in, out);
            String aa = out.toString();
            in.close();
            out.close();
            return JSONObject.fromObject(aa);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }
}