package com.kgc.goods;
//工厂类，根据用户提供的条件返回相应商品
//简单工厂模式（Simple Factory）
//工厂类，抽象产品类
public class Factory {
	public static Goods getGoods(String type){
		Goods goods=null;
		if (type.equals("TV")) {
			goods=new Tvs();
		}else {
			goods=new Foods();
		}
		return goods;
	}
}