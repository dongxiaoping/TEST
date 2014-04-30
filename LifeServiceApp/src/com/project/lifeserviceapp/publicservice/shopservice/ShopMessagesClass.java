package com.project.lifeserviceapp.publicservice.shopservice;

import com.project.lifeserviceapp.R;

// +----------------------------------------------------------------------
// | Author: dxp
// +----------------------------------------------------------------------
// | Date：2014-4-27
// +----------------------------------------------------------------------
// | Function:一个通过商店ID来指定的一个商店对象，该对象中包括了指定商店的全部信息
// +----------------------------------------------------------------------
public class ShopMessagesClass {
	  public String shopName;//商店名称
	  public int shopId;//商店ID
	  public int GoodstotalNumber;//商品数量，这个在显示购物车上的数字时要使用
	  public String[] mercSortArray;//商品分类数组名称数组，id和分类名称是对应的
	  public ShopMessagesClass(int shopId){
		  this.shopName="品一轩";
		  this.shopId=shopId;
		  this.mercSortArray=new String[] {"日常用品", "熟食", "水果","蔬菜","办公用品","饮料","衣服","儿童玩具"};
	  }
	    /**
	     * 通过类别ID返回一个商品类对象，包括了该类的全部信息
	     * @param int 商店物品类别ID
	     **/
	  public GoodsInfoInSort getGoodsInfoInSort(int sortId){
		  String sortName;
		  int goods_number;
		  int[] goodsIdArray;
		  int[] goodsDrawIdArray;
		  String[] goodsNameArray;
		  float[] goodsPriceArray;
		  if(sortId==3){
			  sortName=this.mercSortArray[sortId];//这里的类别id要做判断，当不存在的时候怎么判断
			  goods_number=3;
			  goodsIdArray=new int[]{2,3,8};
			  goodsDrawIdArray=new int[]{R.drawable.chenhao,R.drawable.chenhao,R.drawable.chenhao}; 
			  goodsNameArray=new String[] {"鲜奶豆丝", "玉米", "花生条"};
			  goodsPriceArray=new float[]{6,3,8};	
		  }else{
			  sortName=this.mercSortArray[sortId];//这里的类别id要做判断，当不存在的时候怎么判断
			  goods_number=4;
			  goodsIdArray=new int[]{2,3,8,9};
			  goodsDrawIdArray=new int[]{R.drawable.chenhao,R.drawable.chenhao,R.drawable.chenhao,R.drawable.cart1}; 
			  goodsNameArray=new String[] {"鲜奶豆丝", "玉米", "花生条","一品豆浆"};
			  goodsPriceArray=new float[]{6,3,8,9};	
		  }
		return new GoodsInfoInSort(sortId,sortName,goods_number,goodsIdArray,goodsDrawIdArray,goodsNameArray,goodsPriceArray);
	  }
	  
	// +----------------------------------------------------------------------
	// | Author: dxp
	// +----------------------------------------------------------------------
	// | Date：2014-4-27
	// +----------------------------------------------------------------------
	// | Function:则是一个通过类别ID指定的商品类对象，包括了该类的全部信息
	// +----------------------------------------------------------------------
	  public class GoodsInfoInSort{
		  public int sortId;//类别ID
		  public String sortName;//类别名称
		  public int goods_number;//该类中的商品数量
		  public int[] goodsIdArray;//该类中商品id数组
		  public int[] goodsDrawIdArray;//该类中图标地址数组
		  public String[] goodsNameArray;//该类中商品名称数组
		  public float[] goodsPriceArray;//价格数组
		  public GoodsInfoInSort(int sortId,String sortName,int goods_number,int[] goodsIdArray,
				  int[] goodsDrawIdArray,String[] goodsNameArray,float[] goodsPriceArray){
			  this.sortId=sortId;
			  this.sortName=sortName;
			  this.goods_number=goods_number;
			  this.goodsIdArray=goodsIdArray;
			  this.goodsDrawIdArray=goodsDrawIdArray;
			  this.goodsDrawIdArray=goodsDrawIdArray;
			  this.goodsNameArray=goodsNameArray;
			  this.goodsPriceArray=goodsPriceArray;		  
		  }
	  }
}
