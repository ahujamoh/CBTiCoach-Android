package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;


public class CBTi_Activity20a extends CBTi_BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_20a);
	
		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_MySleep);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity20a.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button 
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity20a.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.buddy_learnusingbedroom);
				i.putExtra("RID_Text", R.string.s_20b);
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});

		// middle buttons
		((Button)findViewById(R.id.bSleepDiary)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity20a.this, CBTi_Activity21a.class );
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bUpdateSleepPrescription)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity20a.this, CBTi_Activity22a.class );
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bINeedMoreSleep)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button 23a

				Intent i = new Intent(CBTi_Activity20a.this, CBTi_Activity23a.class );
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

		((Button)findViewById(R.id.bAssessment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button 23a

				Intent i = new Intent(CBTi_Activity20a.this, CBTi_Activity31a.class );
				CBTi_Activity20a.this.startActivity(i);
				CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});


	}



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity20a.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
}