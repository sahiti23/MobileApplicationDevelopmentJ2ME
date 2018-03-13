import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Properties extends MIDlet implements CommandListener
{
	Display disp;
	TextBox t1;
	Command exit;
	Command show;
	public Properties()
	{
		disp=Display.getDisplay(this);
		t1=new TextBox("title","",200,TextField.ANY);
		exit=new Command("EXIT",Command.OK,0);
		show=new Command("show",Command.OK,1);
		t1.addCommand(exit);
		t1.addCommand(show);
		t1.setCommandListener(this);
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
			String s;
			if(disp.isColor())
				s="color display";
			else
				s="mono";

			s=s+"\n no.of gray levels:"+disp.numColors();
			Runtime rt=Runtime.getRuntime();
			s=s+"\nfree mem" +rt.freeMemory();

			t1.setString(s);
		}
 
	}
}