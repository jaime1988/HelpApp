package com.helpApp;

import java.util.Locale;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalNode extends Activity implements OnInitListener {

	Node theNode = new Node();
	String nodePath = "";
	private TextToSpeech tts;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last_node);

		Bundle bundle = this.getIntent().getExtras();

		try {
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

			tts = new TextToSpeech(this, this);

			final Button button = (Button) findViewById(R.id.Button01);
			button.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					tts.speak(theNode.getSpeakText(), TextToSpeech.QUEUE_FLUSH, null);
				}
			});

		} catch (Exception e) {

		}

	}

	public void onInit(int status) {
		Locale loc = new Locale("es", "", "");
		tts.setLanguage(loc);
	}
}
