import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Draw extends MIDlet
{
	DrawRect d1;
	Display disp;
	public Draw()
	{
		d1=new DrawRect(70,70,50,50);
		disp=Display.getDisplay(this);
	}
	public void startApp()
	{
		disp.setCurrent(d1);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
}