package com.project.lifeserviceapp.publicservice.shopservice;



import com.project.lifeserviceapp.MainActivity;
import com.project.lifeserviceapp.R;
import com.project.lifeserviceapp.publicservice.shopservice.ShopMessagesClass.GoodsInfoInSort;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//+----------------------------------------------------------------------
//| Author: dxp
//+----------------------------------------------------------------------
//| Date：2014-4-24
//+----------------------------------------------------------------------
//| Function:该页面商品列表页面
//+----------------------------------------------------------------------
@SuppressLint("NewApi")
/*这个地方应该用v7的TabListener，不会用，用v4的目前也没问题，不过是个隐患*/
public class GoodsListActivity extends ActionBarActivity implements android.app.ActionBar.TabListener{
	private TextView titleView;//中心标题的view对象
	private TextView shoppingCartView;
	private ViewPager mViewPager;
    private TabFragmentPagerAdapter mAdapter; 
	public ShopMessagesClass TheShop;//根据商店实例化一个商店对象
    public static final String ARGUMENTS_NAME = "args";//正规传参方式中要用到
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_list);		
		TheShop=new ShopMessagesClass(4);//实例化一个商店购物车
		setCenterTitle(TheShop.shopName);//添加居中标题
		initView(); //添加Tab分类标签
	}
	
	
	/*处理的是actionbar中的tab标签相关内容*/
	public void initView(){
		 mViewPager = (ViewPager) this.findViewById(R.id.pager); 
		 final android.app.ActionBar mActionBar = getActionBar(); 
         mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); 
         mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(),TheShop);  
         mViewPager.setAdapter(mAdapter); 
         mViewPager.setOnPageChangeListener(new OnPageChangeListener() {          
             @Override  
             public void onPageSelected(int arg0) {  
                   
                 mActionBar.setSelectedNavigationItem(arg0);  
             }  
               
             @Override  
             public void onPageScrolled(int arg0, float arg1, int arg2) {  
                   
             }  
               
             @Override  
             public void onPageScrollStateChanged(int arg0) {  
                   
             }  
         });
           //Log.v("testout", String.valueOf(mm));
            for(int i=0;i<TheShop.mercSortArray.length;i++){  
               android.app.ActionBar.Tab tab = mActionBar.newTab();  
                tab.setText(mAdapter.getPageTitle(i)).setTabListener(this);  
                mActionBar.addTab(tab);  
            } 
	}
	
	/*该类是添加Tab用到的适配器*/
    public static class TabFragmentPagerAdapter extends FragmentPagerAdapter{  
    	public ShopMessagesClass TheShop;
    	 /*这个地方传进来了标题数组*/
        public TabFragmentPagerAdapter(FragmentManager fm,ShopMessagesClass TheShop) {  
            super(fm);  
            this.TheShop=TheShop;
        }  
  
        @Override  
        public Fragment getItem(int arg0) {  
            Fragment ft = null;  
        	GoodsInfoInSort TheSortClass=this.TheShop.getGoodsInfoInSort(arg0); //根据类别id实例化一个 类别对象   	
        	ft = new CommonUIFragment();  
            ft=new GoodsListFragment(TheSortClass);          
            Bundle args = new Bundle();  //这个是一个正规的传参机制
            args.putString(ARGUMENTS_NAME, "TAB"+(arg0+1));  
            ft.setArguments(args); 
            
 /*           switch (arg0) {  
            case 0:  
               ft = new LaunchUIFragment(); 
            	//ft=new GoodsListFragment();
                break;  
  
            default:  
            	根据类别id实例化一个 类别对象
            	GoodsInfoInSort TheSortClass=this.TheShop.getGoodsInfoInSort(2);          	
            	ft = new CommonUIFragment();  
                ft=new GoodsListFragment(TheSortClass);
                  
                这个是一个正规的传参机制
                Bundle args = new Bundle();  
                args.putString(ARGUMENTS_NAME, "TAB"+(arg0+1));  
                ft.setArguments(args);  
                  
                break;  
            }*/  
            return ft;  
        }  
  
        @Override  
        public int getCount() {  
              
            return TheShop.mercSortArray.length;  
        }  
/*        这个地方是传入位置ID，从0开始的，返回对应tab位置的标题名称*/
         @Override  
        public CharSequence getPageTitle(int position) {  
            return TheShop.mercSortArray[position];  
        }  
    } 
/*    在cationbar的中间添加主题名称*/
	public void setCenterTitle( String titleName){
		ActionBar myActionBar=getSupportActionBar();
		myActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		myActionBar.setCustomView(R.layout.center_title_layout);	
		titleView = (TextView)findViewById(R.id.center_title_id);
		titleView.setText(titleName);
		myActionBar.setDisplayShowHomeEnabled(true);
		myActionBar.setDisplayHomeAsUpEnabled(true);
	}
	
	/*下面的两个是actionbar重要覆写的函数*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.goods_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		 case android.R.id.home:		 
		 Intent intent = new Intent(this, MainActivity.class);		 
		 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		 startActivity(intent);
		 return true;	 
		 case R.id.shopping_cart_id:	
			 titleView = (TextView) findViewById(R.id.shopping_cart_id);
			 titleView.setText("年后");
			/*直接跳转到GoodsListActivity页面*/
			Intent it = new Intent(GoodsListActivity.this, SubmitOrdersActivity.class);   
			Bundle bundle=new Bundle();   
			bundle.putString("name", "This is from MainActivity!");   
			it.putExtras(bundle); // it.putExtra(“test”, "shuju”);   
			startActivity(it);   // startActivityForResult(it,REQUEST_CODE);  
		 return true;	
		 default:
		 return super.onOptionsItemSelected(item);
		 }
	}

	/*下面的三个是接口android.app.ActionBar.TabListener的实现*/
	@Override
	public void onTabSelected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		   mViewPager.setCurrentItem(tab.getPosition());  
		
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
