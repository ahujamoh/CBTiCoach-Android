/*
* Reminders_BR_StopCaffeine.java
* Broadcast receiver used to set alarms for the user to stop intaking caffeine
*
* Created by Brad Catlett on 10/21/13.
*
* CBT-i Coach
*
* Copyright � 2009-2014 United States Government as represented by
* the Chief Information Officer of the National Center for Telehealth
* and Technology. All Rights Reserved.
*
* Copyright � 2009-2014 Contributors. All Rights Reserved.
*
* THIS OPEN SOURCE AGREEMENT ("AGREEMENT") DEFINES THE RIGHTS OF USE,
* REPRODUCTION, DISTRIBUTION, MODIFICATION AND REDISTRIBUTION OF CERTAIN
* COMPUTER SOFTWARE ORIGINALLY RELEASED BY THE UNITED STATES GOVERNMENT
* AS REPRESENTED BY THE GOVERNMENT AGENCY LISTED BELOW ("GOVERNMENT AGENCY").
* THE UNITED STATES GOVERNMENT, AS REPRESENTED BY GOVERNMENT AGENCY, IS AN
* INTENDED THIRD-PARTY BENEFICIARY OF ALL SUBSEQUENT DISTRIBUTIONS OR
* REDISTRIBUTIONS OF THE SUBJECT SOFTWARE. ANYONE WHO USES, REPRODUCES,
* DISTRIBUTES, MODIFIES OR REDISTRIBUTES THE SUBJECT SOFTWARE, AS DEFINED
* HEREIN, OR ANY PART THEREOF, IS, BY THAT ACTION, ACCEPTING IN FULL THE
* RESPONSIBILITIES AND OBLIGATIONS CONTAINED IN THIS AGREEMENT.
*
* Government Agency: The National Center for Telehealth and Technology
* Government Agency Original Software Designation: CBT-i Coach001
* Government Agency Original Software Title: CBT-i Coach
* User Registration Requested. Please send email
* with your contact information to: robert.a.kayl.civ@mail.mil
* Government Agency Point of Contact for Original Software: robert.a.kayl.civ@mail.mil
*
*/
package com.t2.cbti.reminders;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.t2.cbti.R;

public class Reminders_BR_StopCaffeine extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent)
	{
		WakeLocker.acquire(context);
		CharSequence cMsg = context.getResources().getString(R.string.s_remStopCaffeine);
		Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

		Notification noti = new NotificationCompat.Builder(context)
				// notification, no extra actions
				.setContentTitle(cMsg).setContentIntent(PendingIntent.getActivity(context, 0, new Intent(), Intent.FLAG_ACTIVITY_NEW_TASK))
				.setSmallIcon(R.drawable.cbti_icon).setSound(alarmSound).build();
		noti.flags |= Notification.FLAG_AUTO_CANCEL; // Hide the notification
														// after its selected
		// Toast.makeText(context,
		// "Your toast message.",Toast.LENGTH_SHORT).show();
		((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(7704, noti);
	}

}