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
//| Date��2014-4-27
//+----------------------------------------------------------------------
//| Function:��ҳ����Ʒ�б�fragment,������ӵ�����ҳ��
//+----------------------------------------------------------------------
/**
 * ��Fragment�̳е���ListFragment����������Ʒ�б�֮�����Fragment�ŵ���Activity��,�����ʱ
 * ��ʹ�ã�Ӧ�ÿ����ƶ����浥����Ϊһ���ļ���
 * String[][]  goodsInformations= {{"2","R.drawable.chenhao","��ʹ����","9"},{"4","R.drawable.chenhao","��ŷ����","11"},
 * {"23","R.drawable.chenhao","��÷����","7"},{"44","R.drawable.chenhao","�춹�Ͱ�","23"},{"123","R.drawable.chenhao","�������","7"}};
 */
/*����ط�����һ����ά���鴫��ȥ��ÿһ�����������������Ϣ����ƷID����Ʒͼ���ַ����Ʒ���ơ��۸�*/
@SuppressLint("ValidFragment")
public class GoodsListFragment extends ListFragment {
	private FragmentManager manager;
	private SimpleAdapter adapter;
	private FragmentTransaction transaction;
	public GoodsInfoInSort TheSortClass;

	public GoodsListFragment(GoodsInfoInSort TheSortClass) {
		this.TheSortClass=TheSortClass;
		
		/*������η�ʽҪ�о���*/
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
       

        //���б�ֵѭ������ȥ
        
        for(int i=0;i<TheSortClass.goods_number;i++){//�������������
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
