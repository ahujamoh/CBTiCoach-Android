package com.t2.cbt_i.tools;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class ToolsMainActivity extends BaseABSActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tools_main);

		// Middle New Sleep Habits 
		((Button)findViewById(R.id.bCreateNewSleepHabits)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), SleepHabitsMainActivity.class );
				startActivity(i);
				ToolsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// Middle Quiet Your Mind 
		((Button)findViewById(R.id.bQuietYourMind)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), QuiteMindMainActivity.class );
				startActivity(i);
				ToolsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
		
		// Middle Prevent Insomnia in the Future 
		((Button)findViewById(R.id.bPreventInsomniaintheFuture)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Perform action on click
				Intent i = new Intent(getApplicationContext(), PreventInsomniaActivity.class );
				startActivity(i);
				ToolsMainActivity.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		}); 
	}	
		

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		ToolsMainActivity.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		int ht = ((Button)findViewById(R.id.bCreateNewSleepHabits)).getHeight();
		((TextView)findViewById(R.id.tCreateNewSleepHabits)).setTextSize(ht/15);
		((TextView)findViewById(R.id.tQuietYourMind)).setTextSize(ht/15);
		((TextView)findViewById(R.id.tPreventInsomniaintheFuture)).setTextSize(ht/15);
	    super.onWindowFocusChanged(hasFocus);
	}
	
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(getApplicationContext(), CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_toolshelp);
		i.putExtra("RID_Text", R.string.s_30b);
		startActivity(i);
		super.getHelp();
	}
}