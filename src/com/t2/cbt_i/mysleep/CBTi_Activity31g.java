package com.t2.cbt_i.mysleep;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;



public class CBTi_Activity31g extends BaseABSNHActivity {

	CBTi_Data31b cData31b;
	CBTi_Data31c cData31c;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31g);
	
		// schedule Button
		((Button)findViewById(R.id.bScheduleNextAssessment)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31g.this, CBTi_Activity33a.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity31g.this.startActivity(i);
				CBTi_Activity31g.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});
		
		// take now Button
		((Button)findViewById(R.id.bTakeAssessmentNow)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity31g.this, CBTi_Activity31c.class );
				CBTi_Data31c cData31c = new CBTi_Data31c(CBTi_Activity31g.this);
				cData31c.deleteData();			// start with a clean slate
				CBTi_Activity31g.this.startActivity(i);
				CBTi_Activity31g.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});

	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(CBTi_Activity31g.this, CBTi_Activity31a.class );
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		CBTi_Activity31g.this.startActivity(i);
		CBTi_Activity31g.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	 
	@Override
	protected void onPause() {
		super.onPause();
	}

		
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
}