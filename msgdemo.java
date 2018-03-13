import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class demo extends MIDlet
{
	Display disp;
	TextBox t1;

	public demo()
	{
		disp=Display.getDisplay(this);
		t1=new TextBox("title","message",40,0);
	}
	public void startApp()
	{
		disp.setCurrent(t1);
	}
	public void pauseApp()
	{}
	public void destroyApp(boolean b)
	{
	}
}