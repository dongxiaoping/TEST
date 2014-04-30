package com.project.lifeserviceapp.publicservice.shopservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.lifeserviceapp.R;
import com.project.lifeserviceapp.publicservice.shopservice.ShopMessagesClass.GoodsInfoInSort;
//+----------------------------------------------------------------------
//| Author: dxp
//+----------------------------------------------------------------------
//| Date：2014-4-27
//+----------------------------------------------------------------------
//| Function:该页面商品列表fragment,可以添加到其它页面
//+----------------------------------------------------------------------
/**
 * 该Fragment继承的是ListFragment。里面是商品列表，之后见该Fragment放到主Activity中,这个暂时
 * 不使用，应该可以移动外面单独作为一个文件的
 * String[][]  goodsInformations= {{"2","R.drawable.chenhao","天使蛋糕","9"},{"4","R.drawable.chenhao","北欧布丁","11"},
 * {"23","R.drawable.chenhao","西梅蛋糕","7"},{"44","R.drawable.chenhao","红豆餐包","23"},{"123","R.drawable.chenhao","五谷杂粮","7"}};
 */
/*这个地方定义一个二维数组传进去，每一个集合里面包括的信息由商品ID、商品图标地址、商品名称、价格*/
@SuppressLint("ValidFragment")
public class GoodsListFragment extends ListFragment {
	private FragmentManager manager;
	private SimpleAdapter adapter;
	private FragmentTransaction transaction;
	public GoodsInfoInSort TheSortClass;

	public GoodsListFragment(GoodsInfoInSort TheSortClass) {
		this.TheSortClass=TheSortClass;
		
		/*这个传参方式要研究下*/
/*        Bundle bundle = getArguments();     
        bundle.getString(GoodsListActivity.ARGUMENTS_NAME, "");  */
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        adapter = new SimpleAdapter(getActivity(), getData(),
        		R.layout.goods_list_row,new String[] { "img", "title", "info" },
                new int[] { R.id.img, R.id.title, R.id.info });
        manager = getFragmentManager();
    }
    
	private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map ;//= new HashMap<String, Object>();
       

        //将列表值循环传进去
        
        for(int i=0;i<TheSortClass.goods_number;i++){//遍历纵向的数据
                map = new HashMap<String, Object>();
                map.put("img", TheSortClass.goodsDrawIdArray[i]);               
                map.put("title", TheSortClass.goodsNameArray[i]);
                map.put("info", TheSortClass.goodsPriceArray[i]);
                list.add(map);
        	}    
        return list;
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_goods_list, container,
				false);
		setListAdapter(adapter);
		adapter.notifyDataSetChanged();
		return rootView;
	}
	
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
/*	        super.onListItemClick(l, v, position, id);
        String item = adapter.getItem(position);
        //
        RightFragment fragment = new RightFragment();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.right, fragment, "fragment");
        transaction.addToBackStack("fragment");
        Bundle bundle = new Bundle();
        bundle.putString("item", item);
        fragment.setArguments(bundle);
        transaction.commit();*/
    }
    
    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }


}
