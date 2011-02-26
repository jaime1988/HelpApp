package com.helpApp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;





public class FinalNode extends Activity{
	
	Node theNode = new Node();
	String nodePath = "";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_node);
        
		Bundle bundle = this.getIntent().getExtras();
		
		try{
			nodePath = bundle.getString("path");
			theNode.setDir(false);
			theNode.setNameText(bundle.getString("nameText"));
			theNode.setSpeakText(bundle.getString("speakText"));
			theNode.setLongText(bundle.getString("longText"));
			theNode.setImageName(bundle.getString("imageName"));
			
			
			ImageView im = (ImageView) findViewById(R.id.image);
			im.setImageURI(Uri.parse("file://" + theNode.getImageName()));
			
			TextView tt = (TextView) findViewById(R.id.text);
			tt.setText(theNode.getLongText());

			TextView speakTextView = (TextView) findViewById(R.id.speakText);
			speakTextView.setText(theNode.getSpeakText());
			
		}catch(Exception e){
			
		}
        

		
        
    }
}
