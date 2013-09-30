package com.t2.cbt_i.tools;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.VideoView;

import com.t2.cbt_i.R;
import com.t2.cbt_i.classes.BaseABSNHActivity;

public class CBTi_Activity35a26 extends BaseABSNHActivity {

	private int[] iCaptionId = 		{ 	R.string.s_bScan01, R.string.s_bScan02, R.string.s_bScan03, R.string.s_bScan04, R.string.s_bScan05,
								R.string.s_bScan06, R.string.s_bScan07, R.string.s_bScan08, R.string.s_bScan09, R.string.s_bScan10,
								R.string.s_bScan11, R.string.s_bScan12, R.string.s_bScan13, R.string.s_bScan14, R.string.s_bScan15,
								R.string.s_bScan16, R.string.s_bScan17, R.string.s_bScan18, R.string.s_bScan19, R.string.s_bScan20,
								R.string.s_bScan21, R.string.s_bScan22, R.string.s_bScan23, R.string.s_bScan24, R.string.s_bScan25,
								R.string.s_bScan26, R.string.s_bScan27, R.string.s_bScan28, R.string.s_bScan29, R.string.s_bScan30,
								R.string.s_bScan31, R.string.s_bScan32, R.string.s_bScan33, R.string.s_bScan34, R.string.s_bScan35,
								R.string.s_bScan36, R.string.s_bScan37, R.string.s_bScan38, R.string.s_bScan39, R.string.s_bScan40,
								R.string.s_bScan41, R.string.s_bScan42, R.string.s_bScan43, R.string.s_bScan44, R.string.s_bScan45,
								R.string.s_bScan46, R.string.s_bScan47, R.string.s_bScan48, R.string.s_bScan49, R.string.s_bScan50,
								R.string.s_bScan51, R.string.s_bScan52, R.string.s_bScan53, R.string.s_bScan54, R.string.s_bScan55,
								R.string.s_bScan56, R.string.s_bScan57, R.string.s_bScan58, R.string.s_bScan59, R.string.s_bScan60,
								R.string.s_bScan61, R.string.s_bScan62, R.string.s_bScan63, R.string.s_bScan64, R.string.s_bScan65,
								R.string.s_bScan66, R.string.s_bScan67, R.string.s_bScan68, R.string.s_bScan69, R.string.s_bScan70,
								R.string.s_bScan71, R.string.s_bScan72, R.string.s_bScan73, R.string.s_bScan74, R.string.s_bScan75,
								R.string.s_bScan76, R.string.s_bScan77, R.string.s_bScan78, R.string.s_bScan79, R.string.s_bScan80,
								R.string.s_bScan81, R.string.s_bScan82, R.string.s_bScan83  };
	private int[] iCaptionStart = 	{ 	0, 10, 13, 25, 41, 48, 50, 54, 60, 64, 72, 79, 86, 90, 104, 108, 111, 119, 124, 127,
								130, 148, 154, 158, 162, 166, 175, 179, 197, 201, 207, 210, 218, 224, 228, 245, 250, 254, 258, 262,
								271, 285, 290, 294, 301, 313, 318, 323, 326, 331, 339, 341, 343, 349, 365, 369, 378, 394, 399, 403, 
								407, 410, 416, 420, 433, 455, 475, 483, 487, 494, 498, 514, 521, 524, 527, 529, 544, 549, 551, 555, 
								559, 564, 576 };
	private Handler sHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		int iRid = b.getInt("RID");
		if( iRid == R.id.bSelfGuided ) {
			setContentView(R.layout.cbti_35a26);
			((TextView)findViewById(R.id.tvSelf)).setMovementMethod(new ScrollingMovementMethod());
		} else {
			setContentView(R.layout.cbti_35a262);
			Uri uUri = Uri.parse( "android.resource://" + getPackageName() + "/" + R.raw.mp3_observe_sensations_new );

			((VideoView) findViewById( R.id.video )).setVideoURI(uUri);
			((VideoView) findViewById( R.id.video )).setOnCompletionListener(onComplete);
			
			sHandler = new Handler();
		}
	}	
	
	private void videoPlay() {
		iResLast = -1;
		rSequencer.run();
		if( iVideoPos == 0 ) {
			try {
				Thread.sleep(500);
			} catch( Exception e ) {}
		}
		if( iVideoPos > 0 ) 
			((VideoView) findViewById( R.id.video )).seekTo(iVideoPos);
		((VideoView) findViewById( R.id.video )).start();
		
	}
	
	MediaPlayer.OnCompletionListener onComplete = new MediaPlayer.OnCompletionListener() {
		public void onCompletion(MediaPlayer arg0) {
			((TextView)findViewById( R.id.caption )).setText(R.string.s_35a16);
		}
	};
	



	

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		if( ((VideoView) findViewById( R.id.video )) != null ) {
			((VideoView) findViewById( R.id.video )).stopPlayback();
			sHandler.removeCallbacks(rSequencer);
			iVideoPos = 0;
		}
		CBTi_Activity35a26.this.overridePendingTransition( R.anim.slide_right, R.anim.slide_right2);
	}
	
	private static int iResLast;
	private Runnable rSequencer = new Runnable() {	//Do something to the UI thread here
		@Override public void run() {		//This method runs in the same thread as the UI. 
			int iVideoCur = ((VideoView)findViewById(R.id.video)).getCurrentPosition() / 1000;
			if( iVideoCur >= 0 ) {
				int iCur = getCurrentCaptionIndex(iCaptionStart,iVideoCur);
				//if( (iCur!=-1) && (iResLast!=iCur) ) {
				if( iResLast!=iCur ) {
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
		return ((iList[i-1]<=iVideoPos)? i-1 : 1);
	}
	
	private static int iVideoPos;
	@Override
	protected void onPause() {
		if( ((VideoView) findViewById( R.id.video )) != null ) {
			((VideoView) findViewById( R.id.video )).pause();
			iVideoPos = ((VideoView) findViewById( R.id.video )).getCurrentPosition();
			sHandler.removeCallbacks(rSequencer);
		}
		super.onPause();
	}



	@Override
	protected void onResume() {
		if( ((VideoView) findViewById( R.id.video )) != null ) {
			videoPlay();
		}
		super.onResume();
	}
	
	
}
