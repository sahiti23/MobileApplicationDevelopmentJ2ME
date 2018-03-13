import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Drawbg extends MIDlet
{
	Display disp;
	Drawb d1;
	public Drawbg()
	{
		d1=new Drawb();
		disp=Display.getDisplay(this);
	}
	public void startApp()
	{
		disp.setCurrent(d1);
	}
	public void pauseApp()
	{}
	public void destroyApp(boolean b)
	{}
}