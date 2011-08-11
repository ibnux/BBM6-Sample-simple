package com.nux.bbm.sample;

import net.rim.blackberry.api.bbm.platform.BBMPlatformContext;
import net.rim.blackberry.api.bbm.platform.BBMPlatformManager;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.MainScreen;
/**
 * 
 * @author iBNuX
 *
 */
public class KacaTampil extends MainScreen implements FieldChangeListener {
	EditField status = new EditField("Status: ", "My Status");
	
	ButtonField setstatus = new ButtonField("Set Status", ButtonField.CONSUME_CLICK);
	ButtonField addactif1 = new ButtonField("add Activity", ButtonField.CONSUME_CLICK);
	ButtonField addactif2 = new ButtonField("add Activity", ButtonField.CONSUME_CLICK);
	
	public KacaTampil() {
		setTitle("Sample BBM6");
		add(status);
		add(setstatus);
		add(new SeparatorField());
		add(addactif1);
		add(addactif2);
		
		setstatus.setChangeListener(this);
		addactif1.setChangeListener(this);
		addactif2.setChangeListener(this);
		
		bbm6Void();
	}
	
	//aktifkan fitur BBM
	void bbm6Void(){
		UiApplication.getUiApplication().invokeLater(new Runnable(){
			public void run()
			{
				BBMPlatformContext platformContext = BBMPlatformManager.register(Mulai.getMyBBMPlugin());
				Mulai.setPlatformContext(platformContext);
				platformContext.setListener(Mulai.getPlatformContextListener());
			}
		});
	}
	
	//hilangkan notifikasi save
	protected boolean onSavePrompt() {
		return true;
	}

	public void fieldChanged(Field field, int context) {
		if(field == setstatus){
			Mulai.updateStatus(status.getText());
		}else if(field == addactif2){
			Mulai.addtoProfilBox("aktivitas 1", 0);
		}else if(field == addactif1){
			Mulai.addtoProfilBox("aktivitas 2", 1);			
		}
	}
}
