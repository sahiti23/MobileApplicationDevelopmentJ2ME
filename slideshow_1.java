import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class slideshow extends MIDlet 
{
	Display disp;
	TextBox[] t1;
	public slideshow()
	{
		disp=Display.getDisplay(this);
		t1=new TextBox[3];
		for(int i=0;i<3;i++)
		t1[i]=new TextBox("title","screen"+i,40,0);
	}
	public void startApp()
	{
		try
		{
			for(int i=0;i<3;)
			{
				disp.setCurrent(t1[i]);
				Thread.sleep(1000);
				i++;
				if(i==3)
				i=0;
			}
		}catch(InterruptedException ie)
		{
		}
	}
	public void pauseApp()
	{
	}
	public void destroyApp(boolean b){
	}
}