package com.help.reward.shop.datastore.translate;

/**
 * Created by richsjeson
 * {
 "code": 200,
 "msg": "操作成功",
 "data": {
 "goods_info": {
 "goods_name": "美特斯邦威 黑 L 羽绒",
 "goods_jingle": "锋菲恋 谢霆锋款",
 "gc_id_1": "1",
 "gc_id_2": "5",
 "gc_id_3": "40",
 "spec_name": {
 "1": "颜色",
 "15": "尺码",
 "16": "材质"
 },
 "spec_value": {
 "1": {
 "438": "黑"
 },
 "15": {
 "439": "M",
 "440": "L"
 },
 "16": {
 "441": "羽绒"
 }
 },
 "goods_attr": {
 "211": {
 "3090": "长袖",
 "name": "袖长"
 },
 "212": {
 "3097": "纯色",
 "name": "花型"
 },
 "213": {
 "3119": "修身",
 "name": "版式"
 },
 "214": {
 "3124": "短款(35-50CM)",
 "name": "衣长"
 },
 "215": {
 "3128": "圆领",
 "name": "领型"
 }
 },
 "mobile_body": "",
 "goods_specname": "",
 "goods_price": "2.00",
 "goods_marketprice": "3.00",
 "goods_costprice": "1.00",
 "goods_discount": "50",
 "goods_serial": "",
 "goods_storage_alarm": "0",
 "transport_id": "0",
 "transport_title": "",
 "goods_freight": "0.00",
 "goods_vat": "0",
 "areaid_1": "0",
 "areaid_2": "0",
 "goods_stcids": ",1,2,",
 "plateid_top": "0",
 "plateid_bottom": "0",
 "is_virtual": "0",
 "virtual_indate": "0",
 "virtual_limit": "0",
 "virtual_invalid_refund": "0",
 "is_fcode": "0",
 "is_appoint": "0",
 "appoint_satedate": "0",
 "is_presell": "0",
 "presell_deliverdate": "0",
 "is_own_shop": "0",
 "goods_id": "257",
 "goods_promotion_price": "2.00",
 "goods_promotion_type": "0",
 "goods_click": 23,
 "goods_salenum": "0",
 "goods_collect": "0",
 "goods_spec": {
 "438": "黑",
 "440": "L",
 "441": "羽绒"
 },
 "goods_storage": "1",
 "color_id": "438",
 "evaluation_good_star": "5",
 "evaluation_count": "0",
 "have_gift": "0",
 "goods_barcode": null,
 "cart": true,
 "goods_url": "http://192.168.3.2/shop/item-257.html"
 },
 "spec_image": {
 "438": "http://210.72.13.135/data/upload/shop/store/goods/2/2_05374699586285225_60.jpg"
 },
 "mansong_info": null,
 "gift_array": [],
 "goods_commend_list": [
 {
 "goods_id": "236",
 "goods_name": "nikon数码相机",
 "goods_price": null,
 "goods_promotion_price": "1.00",
 "goods_image_url": "http://210.72.13.135/data/upload/shop/store/goods/2/2_05374432671127592_240.jpg"
 },
 {
 "goods_id": "256",
 "goods_name": "美特斯邦威 黑 M 羽绒",
 "goods_price": null,
 "goods_promotion_price": "1.00",
 "goods_image_url": "http://210.72.13.135/data/upload/shop/store/goods/2/2_05374699586285225_240.jpg"
 }
 ],
 "store_info": {
 "store_id": "2",
 "store_name": "我知道",
 "member_id": "2",
 "member_name": "liyanhong",
 "is_own_shop": "0",
 "goods_count": "3",
 "store_huodaofk": "1",
 "store_quick_refund": "0",
 "store_xiaoxie": "1",
 "store_zhping": "1",
 "store_qtian": "1",
 "store_credit": {
 "store_desccredit": {
 "text": "描述相符",
 "credit": 5,
 "percent": "----",
 "percent_class": "equal",
 "percent_text": "平"
 },
 "store_servicecredit": {
 "text": "服务态度",
 "credit": 5,
 "percent": "----",
 "percent_class": "equal",
 "percent_text": "平"
 },
 "store_deliverycredit": {
 "text": "发货速度",
 "credit": 5,
 "percent": "----",
 "percent_class": "equal",
 "percent_text": "平"
 }
 }
 },
 "spec_list": {
 "438|439|441": "256",
 "438|440|441": "257"
 },
 "goods_image": "http://210.72.13.135/data/upload/shop/store/goods/2/2_05374699586285225_360.jpg,http://210.72.13.135/data/upload/shop/store/goods/2/2_05374625157993957_360.jpg,http://210.72.13.135/data/upload/shop/store/goods/2/2_05374625106649572_360.jpg",
 "goods_eval_list": [],
 "goods_evaluate_info": {
 "good": 0,
 "normal": 0,
 "bad": 0,
 "all": 0,
 "good_percent": 100,
 "normal_percent": 0,
 "bad_percent": 0,
 "good_star": 5,
 "star_average": 5
 },
 "goods_hair_info": {
 "content": "免运费",
 "if_store_cn": "有货",
 "if_store": true,
 "area_name": "全国"
 }
 }
 }
 */

public class   ShopInfoKey {
    public static final String GOODS_INFO="goods_info";
    public static final String STORE_INFO="store_info";
    public static final String GOODS_HAIR_INFO="goods_hair_info";
    public static final String GOODS_COMMEND_LIST="goods_commend_list";
    public static final String SPEC_NAME = "spec_name";
    public static final String SPEC_VALUE = "spec_value";


    public static final   class GoodsKey{
        public static final String GOODS_ID="goods_id";
        public static final String GOODS_JINGLE="goods_jingle";
        public static final String GOODS_PRICE="goods_price";
        public static final String GOODS_COSTPRICE="goods_costprice";
        public static final String GOODS_CLICK="goods_click";
        public static final String GOODS_PROMOTIONPRICE="goods_promotion_price";
        public static final String GOODS_SALENUM="goods_salenum";
        public static final String GOODS_IMAGE="goods_image";
        public static final String GOOD_NAME ="goods_name" ;
        public static final String GOODS_MARKET_PRICE = "goods_marketprice";
        public static final String GOODS_CONTENT="content";
        public static final String GOODS_AREA_NAME="area_name";
    }


    public static  final  class StoreKey{
        public static final String STORE_ID="store_id";
        public static final String STORE_NAME="store_name";
        public static final String MEMBER_ID="member_id";
        public static final String STORE_CREDIT="store_credit";
        public static final String STORE_DESCCREDIT="store_desccredit";
        public static final String STORE_SERVICECREDIT="store_servicecredit";
        public static final String STORE_DELIVECREDIT="store_deliverycredit";
        public static final String CREDIT="credit";
    }

    public static final class GoodCommend{
        public static final String GOOD_COMMEND_ID="goods_id";
        public static final String GOOD_COMMEND_NAME="goods_name";
        public static final String GOOD_COMMEND_PROMOTIONPRICE="goods_promotion_price";
    }
}
