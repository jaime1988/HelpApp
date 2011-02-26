package com.helpApp;


import java.util.ArrayList;
import android.net.Uri;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class NodeListViewAdapter extends ArrayAdapter<Node> {

	        private ArrayList<Node> items;
	        private Activity activity;
	        
	        public NodeListViewAdapter(Context context, int textViewResourceId, ArrayList<Node> items,Activity a) {
	                super(context, textViewResourceId, items);
	                this.activity = a;
	                this.items = items;
	        }
	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	                View v = convertView;
	                if (v == null) {
	                    LayoutInflater vi = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	                    
	                    v = vi.inflate(R.layout.item, null);
	                }
	                Node o = items.get(position);
	                if (o != null) {
	                	
	                	//poblamos la lista de elementos
	                	
	                        TextView tt = (TextView) v.findViewById(R.id.text);
	                        ImageView im = (ImageView) v.findViewById(R.id.image);

	                        if (im!= null) {
	                        	//im.setImageResource(o.getImageName());
	                        	
	                        }                        
	                        if (tt != null) {             
	                            tt.setText(o.getNameText());                             
	                        }
	                        
	                        if(o.isDir()){
	                        	im.setImageResource(R.drawable.directory);
	                        	
	                        }else{
	                        	im.setImageURI(Uri.parse("file://" + o.getImageName()));
	                        }
	                        //im.setImageURI(Uri.parse("file:///sdcard/external_sd/demoApp/gas.png"));
	                    //    im.setImageURI(Uri.parse("file:///sdcard/external_sd/demoApp/" + o.getImageName()));
	                    //    im.setScaleType(ImageView.ScaleType.FIT_CENTER);
	                }
	                return v;
	        }
	}

