package com.helpApp;

import java.io.File;
import java.util.ArrayList;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends ListActivity {

	private ArrayList<Node> nodesArray = null;
	private NodeListViewAdapter nodesAdapter;
	private static String globalPath = "/sdcard/external_sd/helpApp/";
	private static String relativePath = "";

	public static String getRelativePath() {
		return relativePath;
	}

	public static void setRelativePath(String relativePath) {
		MainActivity.relativePath = relativePath;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		nodesArray = new ArrayList<Node>();
		this.nodesAdapter = new NodeListViewAdapter(this, R.layout.item,
				nodesArray, this);
		setListAdapter(this.nodesAdapter);
	    
		Bundle bundle = this.getIntent().getExtras();
		try{
			relativePath = bundle.getString("relativePath");
		}catch(Exception e){
			
		}
	    
		inicializarLocales();

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Node local = (Node) l.getItemAtPosition(position);
		
		if(local.isDir()){
	       Intent main_menu = new Intent(this,MainActivity.class).putExtra("relativePath", local.getNameText());  
	        startActivity(main_menu); 
		}
		// Toast.makeText(this, local.getLocalName(),
		// Toast.LENGTH_LONG).show();
		// Intent main_menu = new
		// Intent(this,FinalNode.class).putExtra("prueba",
		// local.getLocalName());
		// startActivity(main_menu);
		// startActivity(new Intent(this, PersonListActivity.class).putExtra(
		// "name", names.get(position)));
	}

	/*
	 * Inicializacion del mapa
	 */

	private void inicializarLocales() {

		try {
			nodesArray = new ArrayList<Node>();
			Node o1 = new Node();
			o1.setNameText("Prueba");
			nodesArray.add(o1);
			getFiles(nodesArray);
			/*
			 * Node o5 = new Node(); o5.setLocalName("Tiendas");
			 * o5.setLocalImage(R.drawable.icon); o5.setImageName("shop.png");
			 * Node o1 = new Node(); o1.setLocalName("Bancos");
			 * o1.setLocalImage(R.drawable.stub); o1.setImageName("visa.png");
			 * Node o2 = new Node(); o2.setLocalName("Gasolineras");
			 * o2.setLocalImage(R.drawable.stub); o2.setImageName("gas.png");
			 * Node o3 = new Node(); o3.setLocalName("Hospitales");
			 * o3.setLocalImage(R.drawable.icon);
			 * o3.setImageName("hospital.png"); Node o4 = new Node();
			 * o4.setLocalName("Restaurantes");
			 * o4.setLocalImage(R.drawable.stub);
			 * o4.setImageName("restaurant.png");
			 * 
			 * nodesArray.add(o1); nodesArray.add(o2); nodesArray.add(o3);
			 * nodesArray.add(o4); nodesArray.add(o5);
			 */
			Log.i("Locales añadidos ", "" + nodesArray.size());
		} catch (Exception e) {
			Log.e("BACKGROUND_PROC", e.getMessage());
		}

		if (nodesArray != null && nodesArray.size() > 0) {
			for (int i = 0; i < nodesArray.size(); i++)
				nodesAdapter.add(nodesArray.get(i));
		}

		nodesAdapter.notifyDataSetChanged();

	}
	
	
	public void getFiles(ArrayList<Node> nodes){
		//File[] archivos = new File("/sdcard/external_sd/helpApp/").listFiles();
		File[] archivos = new File(globalPath + relativePath).listFiles();
		
    	String kk = "";

    	for( File archivo: archivos){
    		char first = archivo.getName().charAt(0);
    		if( first == '.'){
    			continue;
    		}
    		
    		if(archivo.isFile()){
    			Node o1 = new Node();
    			o1.setNameText(archivo.getName());
    			o1.setDir(false);
    			nodesArray.add(o1);
    		}else if(archivo.isDirectory()){
    			Node o1 = new Node();
    			o1.setNameText(archivo.getName());
    			o1.setDir(true);
    			nodesArray.add(o1);
    		}
    		
    		kk += archivo.toString() + "\n";
    		
    	}
		
	}
	
	
	
	
}