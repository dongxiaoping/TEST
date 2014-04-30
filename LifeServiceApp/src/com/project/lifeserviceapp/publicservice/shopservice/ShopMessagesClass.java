package com.project.lifeserviceapp.publicservice.shopservice;

import com.project.lifeserviceapp.R;

// +----------------------------------------------------------------------
// | Author: dxp
// +----------------------------------------------------------------------
// | Date��2014-4-27
// +----------------------------------------------------------------------
// | Function:һ��ͨ���̵�ID��ָ����һ���̵���󣬸ö����а�����ָ���̵��ȫ����Ϣ
// +----------------------------------------------------------------------
public class ShopMessagesClass {
	  public String shopName;//�̵�����
	  public int shopId;//�̵�ID
	  public int GoodstotalNumber;//��Ʒ�������������ʾ���ﳵ�ϵ�����ʱҪʹ��
	  public String[] mercSortArray;//��Ʒ���������������飬id�ͷ��������Ƕ�Ӧ��
	  public ShopMessagesClass(int shopId){
		  this.shopName="Ʒһ��";
		  this.shopId=shopId;
		  this.mercSortArray=new String[] {"�ճ���Ʒ", "��ʳ", "ˮ��","�߲�","�칫��Ʒ","����","�·�","��ͯ���"};
	  }
	    /**
	     * ͨ�����ID����һ����Ʒ����󣬰����˸����ȫ����Ϣ
	     * @param int �̵���Ʒ���ID
	     **/
	  public GoodsInfoInSort getGoodsInfoInSort(int sortId){
		  String sortName;
		  int goods_number;
		  int[] goodsIdArray;
		  int[] goodsDrawIdArray;
		  String[] goodsNameArray;
		  float[] goodsPriceArray;
		  if(sortId==3){
			  sortName=this.mercSortArray[sortId];//��������idҪ���жϣ��������ڵ�ʱ����ô�ж�
			  goods_number=3;
			  goodsIdArray=new int[]{2,3,8};
			  goodsDrawIdArray=new int[]{R.drawable.chenhao,R.drawable.chenhao,R.drawable.chenhao}; 
			  goodsNameArray=new String[] {"���̶�˿", "����", "������"};
			  goodsPriceArray=new float[]{6,3,8};	
		  }else{
			  sortName=this.mercSortArray[sortId];//��������idҪ���жϣ��������ڵ�ʱ����ô�ж�
			  goods_number=4;
			  goodsIdArray=new int[]{2,3,8,9};
			  goodsDrawIdArray=new int[]{R.drawable.chenhao,R.drawable.chenhao,R.drawable.chenhao,R.drawable.cart1}; 
			  goodsNameArray=new String[] {"���̶�˿", "����", "������","һƷ����"};
			  goodsPriceArray=new float[]{6,3,8,9};	
		  }
		return new GoodsInfoInSort(sortId,sortName,goods_number,goodsIdArray,goodsDrawIdArray,goodsNameArray,goodsPriceArray);
	  }
	  
	// +----------------------------------------------------------------------
	// | Author: dxp
	// +----------------------------------------------------------------------
	// | Date��2014-4-27
	// +----------------------------------------------------------------------
	// | Function:����һ��ͨ�����IDָ������Ʒ����󣬰����˸����ȫ����Ϣ
	// +----------------------------------------------------------------------
	  public class GoodsInfoInSort{
		  public int sortId;//���ID
		  public String sortName;//�������
		  public int goods_number;//�����е���Ʒ����
		  public int[] goodsIdArray;//��������Ʒid����
		  public int[] goodsDrawIdArray;//������ͼ���ַ����
		  public String[] goodsNameArray;//��������Ʒ��������
		  public float[] goodsPriceArray;//�۸�����
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
