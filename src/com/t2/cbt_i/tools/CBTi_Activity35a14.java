package com.t2.cbt_i.tools;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.CBTi_Help;
import com.t2.cbt_i.dashboard.CBTi_BaseActivity;
import com.t2.cbt_i.dashboard.DashActivity;

public class CBTi_Activity35a14 extends CBTi_BaseActivity {

	VideoView vvVideo;

	private int[] iCaptionId = 		{ R.string.s_Beach01, R.string.s_Beach02, R.string.s_Beach03, R.string.s_Beach04, R.string.s_Beach05,
			R.string.s_Beach06, R.string.s_Beach07, R.string.s_Beach08, R.string.s_Beach09, R.string.s_Beach10,
			R.string.s_Beach11, R.string.s_Beach12, R.string.s_Beach13, R.string.s_Beach14, R.string.s_Beach15,
			R.string.s_Beach16, R.string.s_Beach17, R.string.s_Beach18, R.string.s_Beach19, R.string.s_Beach20,
			R.string.s_Beach21, R.string.s_Beach22, R.string.s_Beach23, R.string.s_Beach24, R.string.s_Beach25,
			R.string.s_Beach26, R.string.s_Beach27, R.string.s_Beach28, R.string.s_Beach29, R.string.s_Beach30,
			R.string.s_Beach31, R.string.s_Beach32, R.string.s_Beach33
	};
	private int[] iCaptionStart = 	{ 
			1, 9, 14, 20, 24, 
			30, 41, 43, 46, 51, 
			62, 66, 74, 90, 96,
			106, 117, 126, 132, 140, 
			150, 162, 173, 178, 188, 
			200, 207, 218, 236, 252, 
			261, 273, 289
	};
	private Handler sHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cbti_35a14);

		// set up top bar
		((ImageButton)findViewById(R.id.ibTopLeft)).setImageResource(R.drawable.ic_menu_home);
		((TextView)findViewById(R.id.tvTopTitle)).setText( R.string.s_BeachImagery);
		((ImageButton)findViewById(R.id.ibTopRight)).setImageResource(R.drawable.ic_menu_help);
		
		((TextView)findViewById(R.id.caption)).setText( R.string.s_BeachText );

		// topLeft Button HOME
		((ImageButton)findViewById(R.id.ibTopLeft)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button

				Intent i = new Intent(CBTi_Activity35a14.this, DashActivity.class );
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				CBTi_Activity35a14.this.startActivity(i);
				CBTi_Activity35a14.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
			}
		});

		// topRight Button HELP
		((ImageButton)findViewById(R.id.ibTopRight)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				Intent i = new Intent(CBTi_Activity35a14.this, CBTi_Help.class );
				i.putExtra("RID_Img",  R.drawable.guidedimagerybeach);
				i.putExtra("RID_Text", R.string.s_35a12help);
				CBTi_Activity35a14.this.startActivity(i);
				CBTi_Activity35a14.this.overridePendingTransition( R.anim.slide_up, R.anim.slide_up2);
			}
		});

		// PLAY
		((Button)findViewById(R.id.bPlayMe)).setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		// handle the about button
				iVideoPos = 0;
				videoPlay();
			}
		});


		Uri uUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.mp3_imagerybeach );
		((VideoView) findViewById( R.id.video )).setVideoURI(uUri);
		((VideoView) findViewById( R.id.video )).setOnCompletionListener(onComplete);

		sHandler = new Handler();
	}	

	private void videoPlay() {
		((Button)findViewById(R.id.bPlayMe)).setVisibility(View.GONE);
		((VideoView) findViewById( R.id.video )).start();
		iVideoPos = 0;
		rSequencer.run();
		iResLast = -1;
	}


	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener() {
		public void onCompletion(MediaPlayer arg0) {
			((TextView)findViewById( R.id.caption )).setText(R.string.s_RoadText);
			((Button)findViewById(R.id.bPlayMe)).setVisibility(View.VISIBLE);
			//((VideoView) findViewById( R.id.video )).setVisibility(View.INVISIBLE);
		}
	};





	@Override
	public void onBackPressed() {
		super.onBackPressed();
		((VideoView) findViewById( R.id.video )).stopPlayback();
		sHandler.removeCallbacks(rSequencer);
		iVideoPos = 0;
		CBTi_Activity35a14.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}


	private static int iVideoPos;
	@Override
	protected void onPause() {
		((VideoView) findViewById( R.id.video )).pause();
		iVideoPos = ((VideoView) findViewById( R.id.video )).getCurrentPosition();
		sHandler.removeCallbacks(rSequencer);
		super.onPause();
	}



	@Override
	protected void onResume() {
		if( iVideoPos > 0 ) {
			((VideoView) findViewById( R.id.video )).seekTo(iVideoPos);
			videoPlay();
		}
		super.onResume();
	}

	private static int iResLast;
	private Runnable rSequencer = new Runnable() {	//Do something to the UI thread here
		@Override public void run() {		//This method runs in the same thread as the UI. 
			int iVideoCur = ((VideoView)findViewById(R.id.video)).getCurrentPosition() / 1000;
			if( iVideoCur > 0 ) {
				int iCur = getCurrentCaptionIndex(iCaptionStart,iVideoCur);
				if( (iCur!=-1) && (iResLast!=iCur) ) {
					((TextView)findViewById( R.id.caption )).setText(iCaptionId[iCur]);
					iResLast = iCur;
				}
			}
			sHandler.postDelayed(rSequencer, 1000);
		}
	};
	
	private int getCurrentCaptionIndex( int[] iList, int iVideoPos ) {
		int i=0;
		while(i<iList.length) {
			if( iList[i] > iVideoPos)
				return ((i<=iList.length)? i-1 : i);
			i++;
		}
		return ((iList[i-1]<=iVideoPos)? i-1 : -1);
	}
}
