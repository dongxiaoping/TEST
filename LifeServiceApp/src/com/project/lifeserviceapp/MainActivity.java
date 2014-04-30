package com.project.lifeserviceapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.lifeserviceapp.publicservice.shopservice.GoodsListActivity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
//+----------------------------------------------------------------------
//| Author: dxp
//+----------------------------------------------------------------------
//| Date：2014-4-23
//+----------------------------------------------------------------------
//| Function:该页面是服务选择页，也就是登陆进去的首页
//+----------------------------------------------------------------------
public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container,new PlaceholderFragment()).commit();
		}
		/*隐藏action bar*/
		ActionBar actionBar = getSupportActionBar();
		actionBar.hide();
	
		/*直接跳转到GoodsListActivity页面*/
		Intent it = new Intent(MainActivity.this, GoodsListActivity.class);   
		Bundle bundle=new Bundle();   
		bundle.putString("name", "This is from MainActivity!");   
		it.putExtras(bundle); // it.putExtra(“test”, "shuju”);   
		startActivity(it);   // startActivityForResult(it,REQUEST_CODE);  

		
		/*目标activity获取值的方法*/
/*		Bundle bundle=getIntent().getExtras();   
		String name=bundle.getString("name"); */ 
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private FragmentManager manager;
		private SimpleAdapter adapter;
		private FragmentTransaction transaction;

		public PlaceholderFragment() {
		}
   
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}		
	}

}
