package com.project.lifeserviceapp.publicservice.shopservice;

import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;   
  
public class LaunchUIFragment extends Fragment {  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
          
        View rootView = inflater.inflate(com.project.lifeserviceapp.R.layout.fragment_selection_launch, container, false);  
          
        return rootView;  
    }  
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        // TODO Auto-generated method stub  
        super.onActivityCreated(savedInstanceState);  
    }  
      
}  
