package com.t2.cbt_i.mysleep;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSActivity;
import com.t2.cbt_i.classes.CBTi_Help;


public class CBTi_Activity31b extends BaseABSActivity {

	CBTi_Data31b cData31b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_31b);

		// ProviderToggle Button 
		((ToggleButton)findViewById(R.id.bProvider)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
			}
		});
		
		// Take Assessment Button 
		((Button)findViewById(R.id.bTakeNow)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the button
				Intent i = new Intent(CBTi_Activity31b.this, CBTi_Activity31c.class );
				CBTi_Data31c cData31c = new CBTi_Data31c(CBTi_Activity31b.this);
				cData31c.deleteData();			// start with a clean slate
				CBTi_Activity31b.this.startActivity(i);
				CBTi_Activity31b.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
			}
		});
		
	}
	
	

	

	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		CBTi_Activity31b.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	
		
	static final int DIALOG_ISIERROR = 1;

	@Override
	protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case DIALOG_ISIERROR:
	    	new AlertDialog.Builder(this).setMessage(getString(R.string.s_ISIError)).setPositiveButton("OK", null).create().show();
			break;
	    }
	    return null;
	}

	
		        
	@Override
	protected void onPause() {
		cData31b.bProvider = ((ToggleButton)findViewById(R.id.bProvider)).isChecked();
		cData31b.saveData();			// save data to file
		super.onPause();
	}

	
	@Override
	protected void onResume() {
		cData31b = new CBTi_Data31b(this);
		
		if( cData31b.withinAWeek()) {
			Intent i = new Intent(CBTi_Activity31b.this, CBTi_Activity31g.class );
			CBTi_Activity31b.this.startActivity(i);
			CBTi_Activity31b.this.overridePendingTransition( R.anim.slide_left, R.anim.slide_left2);
		}
		else {
			((ToggleButton)findViewById(R.id.bProvider)).setChecked( cData31b.bProvider );
		}
		
		super.onResume();
	}
	
	@Override
	public void getHelp() {			// called to render help screen
		Intent i = new Intent(CBTi_Activity31b.this, CBTi_Help.class );
		i.putExtra("RID_Img",  R.drawable.buddy_assessmenthelp);
		i.putExtra("RID_Text", R.string.s_31bhelp);
		CBTi_Activity31b.this.startActivity(i);
		CBTi_Activity31b.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
	}
}