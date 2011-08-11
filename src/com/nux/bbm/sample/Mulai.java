package com.nux.bbm.sample;


import net.rim.blackberry.api.bbm.platform.BBMPlatformContext;
import net.rim.blackberry.api.bbm.platform.profile.UserProfile;
import net.rim.blackberry.api.bbm.platform.profile.UserProfileBox;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.UiApplication;

/**
 * 
 * @author iBNuX
 *	ini sample aplikasi yang digunakan pada Nux radio
 */

public class Mulai extends UiApplication{
	private static MyBBMAppPlugin myBBMPlugin;
	private static MyBBMPlatformContextListener platformContextListener;
	private static BBMPlatformContext platformContext;
	
	private static UserProfile userProfile;
	private static UserProfileBox userProfileBox;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mulai ml = new Mulai();
		ml.enterEventDispatcher();
	}

	public Mulai() {
		myBBMPlugin = new MyBBMAppPlugin();
		pushScreen(new KacaTampil());
		
	}
	
	
	
	public static MyBBMPlatformContextListener getPlatformContextListener() {
		if(platformContextListener==null)
			platformContextListener = new MyBBMPlatformContextListener();
		return platformContextListener;
	}

	public static MyBBMAppPlugin getMyBBMPlugin() {
		return myBBMPlugin;
	}

	public static void setPlatformContext(BBMPlatformContext platformContext) {
		Mulai.platformContext = platformContext;
	}



	public static BBMPlatformContext getPlatformContext() {
		return platformContext;
	}

	public static void setUserProfile(UserProfile userProfile) {
		Mulai.userProfile = userProfile;
	}

	public static UserProfile getUserProfile() {
		if(userProfile==null){
			try{
				userProfile = Mulai.getPlatformContext().getUserProfile();
			}catch(Exception e){}
		}
		return userProfile;
	}

	public static void setUserProfileBox(UserProfileBox userProfileBox) {
		Mulai.userProfileBox = userProfileBox;
	}

	public static UserProfileBox getUserProfileBox() {
		if(userProfileBox==null){
			try{
				userProfileBox = getUserProfile().getProfileBox();
				try{
					if(!userProfileBox.isIconRegistered(0))
						userProfileBox.registerIcon(0, EncodedImage.getEncodedImageResource("Play.png"));
					if(!userProfileBox.isIconRegistered(1))
						userProfileBox.registerIcon(1, EncodedImage.getEncodedImageResource("add_comment.png"));
				}catch(Exception e){}
			}catch(Exception e){}
		}
		return userProfileBox;
	}
	
	public static void addtoProfilBox(String txt,int a){
		try{
			if (getUserProfileBox().isAccessible()){
				getUserProfileBox().addItem(a, txt);
			}
		}catch(Exception e){}

	}
	
	public static void updateStatus(String txt){
		try{
			getUserProfile().setPersonalMessage(txt);
		}catch(Exception e){}		
	}

}
