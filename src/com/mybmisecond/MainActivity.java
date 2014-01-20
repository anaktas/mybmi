package com.mybmisecond;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button bttn;
	private TextView hgTxt;
	private TextView wgTxt;
	private TextView rsTxt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		try {
			bttn = (Button)findViewById(R.id.button1);
			bttn.setOnClickListener(this);
		} catch (Exception e) {
			//rsTxt.setText("Problem:" + e.getMessage());
			Toast.makeText(MainActivity.this, "Ups!...", Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
	/*
	@Override
	protected void onRestart() {
		new ButtonController();
	}
	
	@Override
	protected void onResume() {
		new ButtonController();
	}*/
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(MainActivity.this, "Hi there!", Toast.LENGTH_LONG).show();
		
		try {
			hgTxt = (TextView)findViewById(R.id.hgText);
			double h = Double.parseDouble(hgTxt.getText().toString());
			wgTxt = (TextView)findViewById(R.id.wgText);
			double w = Double.parseDouble(wgTxt.getText().toString());
			rsTxt = (TextView)findViewById(R.id.rsText);
			if(h <= 0) {
				rsTxt.setText("Λάθος δεδομένα.");
				//Toast.makeText(MainActivity.this, "Wrong input.", Toast.LENGTH_LONG).show();
			} else {
				double res = Math.round(w/(h*h));
				if(res <= 0) {
					rsTxt.setText("Πρόκειται να πεθάνεις...");
					//Toast.makeText(MainActivity.this, "You will die!", Toast.LENGTH_LONG).show();
				} else if(res > 0 & res <= 18.5) {
					rsTxt.setText("Είσαι ελλιποβαρής!\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				} else if(res > 18.5 & res <= 24.9) {
					rsTxt.setText("Έχεις κανονικό βάρος.\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				} else if(res > 24.9 & res <= 29.9) {
					rsTxt.setText("Είσαι υπέρβαρος!\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				} else if(res > 29.9 & res <= 35) {
					rsTxt.setText("Έχεις α' βαθμού παχυσαρκία!\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				} else if(res > 35 & res <= 40) {
					rsTxt.setText("Έχεις β' βαθμού παχυσαρκία!\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				} else {
					rsTxt.setText("Έχεις γ' βαθμού παχυσαρκία!\n Ο δείκτης σου είναι: " + res);
					//Toast.makeText(MainActivity.this, "Your BMI is: " + res, Toast.LENGTH_LONG).show();
				}
			}
		} catch(Exception e) {
			rsTxt.setText("Problem:" + e.getMessage());
			//Toast.makeText(MainActivity.this, "Ups! No2...", Toast.LENGTH_LONG).show();
		}
	}

}
