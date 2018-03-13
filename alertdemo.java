import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class alertdemo extends MIDlet implements CommandListener
{
	Alert s1;
	TextBox t1;
	Display disp;
	Command exit;
	Command show;
	public alertdemo()
	{
		s1=new Alert("alert demo","message",null,AlertType.ALARM);
		s1.setTimeout(Alert.FOREVER); 
		disp=Display.getDisplay(this);
		t1=new TextBox("demo","alertdemo",20,0);
		exit=new Command("exit",Command.OK,0);
		show=new Command("show",Command.OK,0);		
		t1.setCommandListener(this);
		t1.addCommand(exit);
		t1.addCommand(show);
		s1.setCommandListener(this);
	}
	public void startApp()
	{
		disp.setCurrent(t1);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	public void commandAction(Command cmd,Displayable d)
	{
		if(cmd==exit)
		{
			destroyApp(true);
			notifyDestroyed();
		}
		if(cmd==show)
		{
			disp.setCurrent(s1);
		}
	}
}