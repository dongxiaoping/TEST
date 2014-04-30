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
//| Date��2014-4-24
//+----------------------------------------------------------------------
//| Function:��ҳ����Ʒ�б�ҳ��
//+----------------------------------------------------------------------
@SuppressLint("NewApi")
/*����ط�Ӧ����v7��TabListener�������ã���v4��ĿǰҲû���⣬�����Ǹ�����*/
public class GoodsListActivity extends ActionBarActivity implements android.app.ActionBar.TabListener{
	private TextView titleView;//���ı����view����
	private TextView shoppingCartView;
	private ViewPager mViewPager;
    private TabFragmentPagerAdapter mAdapter; 
	public ShopMessagesClass TheShop;//�����̵�ʵ����һ���̵����
    public static final String ARGUMENTS_NAME = "args";//���洫�η�ʽ��Ҫ�õ�
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_list);		
		TheShop=new ShopMessagesClass(4);//ʵ����һ���̵깺�ﳵ
		setCenterTitle(TheShop.shopName);//��Ӿ��б���
		initView(); //���Tab�����ǩ
	}
	
	
	/*�������actionbar�е�tab��ǩ�������*/
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
	
	/*���������Tab�õ���������*/
    public static class TabFragmentPagerAdapter extends FragmentPagerAdapter{  
    	public ShopMessagesClass TheShop;
    	 /*����ط��������˱�������*/
        public TabFragmentPagerAdapter(FragmentManager fm,ShopMessagesClass TheShop) {  
            super(fm);  
            this.TheShop=TheShop;
        }  
  
        @Override  
        public Fragment getItem(int arg0) {  
            Fragment ft = null;  
        	GoodsInfoInSort TheSortClass=this.TheShop.getGoodsInfoInSort(arg0); //�������idʵ����һ�� ������   	
        	ft = new CommonUIFragment();  
            ft=new GoodsListFragment(TheSortClass);          
            Bundle args = new Bundle();  //�����һ������Ĵ��λ���
            args.putString(ARGUMENTS_NAME, "TAB"+(arg0+1));  
            ft.setArguments(args); 
            
 /*           switch (arg0) {  
            case 0:  
               ft = new LaunchUIFragment(); 
            	//ft=new GoodsListFragment();
                break;  
  
            default:  
            	�������idʵ����һ�� ������
            	GoodsInfoInSort TheSortClass=this.TheShop.getGoodsInfoInSort(2);          	
            	ft = new CommonUIFragment();  
                ft=new GoodsListFragment(TheSortClass);
                  
                �����һ������Ĵ��λ���
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
/*        ����ط��Ǵ���λ��ID����0��ʼ�ģ����ض�Ӧtabλ�õı�������*/
         @Override  
        public CharSequence getPageTitle(int position) {  
            return TheShop.mercSortArray[position];  
        }  
    } 
/*    ��cationbar���м������������*/
	public void setCenterTitle( String titleName){
		ActionBar myActionBar=getSupportActionBar();
		myActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		myActionBar.setCustomView(R.layout.center_title_layout);	
		titleView = (TextView)findViewById(R.id.center_title_id);
		titleView.setText(titleName);
		myActionBar.setDisplayShowHomeEnabled(true);
		myActionBar.setDisplayHomeAsUpEnabled(true);
	}
	
	/*�����������actionbar��Ҫ��д�ĺ���*/
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
			 titleView.setText("���");
			/*ֱ����ת��GoodsListActivityҳ��*/
			Intent it = new Intent(GoodsListActivity.this, SubmitOrdersActivity.class);   
			Bundle bundle=new Bundle();   
			bundle.putString("name", "This is from MainActivity!");   
			it.putExtras(bundle); // it.putExtra(��test��, "shuju��);   
			startActivity(it);   // startActivityForResult(it,REQUEST_CODE);  
		 return true;	
		 default:
		 return super.onOptionsItemSelected(item);
		 }
	}

	/*����������ǽӿ�android.app.ActionBar.TabListener��ʵ��*/
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
