package com.nux.bbm.sample;


import net.rim.blackberry.api.bbm.platform.BBMPlatformContextListener;
import net.rim.device.api.ui.component.Dialog;


public class MyBBMPlatformContextListener extends BBMPlatformContextListener {

	public void accessChanged(boolean isAccessAllowed, int accessErrorCode)
	{
		if(!isAccessAllowed){
			Dialog.alert("Application can't connect to BBM");
		}
	}
	public void appInvoked(int reason, Object param)
	{
		//code for handling different contexts for invocation
	}

}
