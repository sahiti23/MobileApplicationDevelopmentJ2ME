import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Demo1 extends MIDlet implements CommandListener
{
	Display disp;
	TextBox t1;
	Command exit;
	public Demo1()
	{
		disp=Display.getDisplay(this);
		t1=new TextBox("title","",40,TextField.NUMERIC);
		exit=new Command("EXIT",Command.OK,0);
		t1.addCommand(exit);
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
		destroyApp(true);
		notifyDestroyed();
	}
}