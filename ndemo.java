import java.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class ndemo extends MIDlet implements CommandListener,Runnable
{
	private Display mDisplay;
	private Form mForm;
	Command cmd;
	TextField input;
	public ndemo()
	{
		mForm=new Form("connecting...");
		mForm.addCommand(new Command("Exit",Command.EXIT,0));
		input=new TextField("enter name:","",200,TextField.ANY);
		cmd=new Command("send",Command.OK,1);
		mForm.addCommand(cmd);
		mForm.append(input);
		mForm.setCommandListener(this);
	}
	public void startApp()
	{
		if(mDisplay==null)
			mDisplay=Display.getDisplay(this);
		mDisplay.setCurrent(mForm);
	}
	public void pauseApp(){}
	public void destroyApp(Boolean unconditional){}
	public void commandAction(Command c,Displayable s)
	{
		if(c.getCommandType()==Command.EXIT)
			notifyDestroyed();
		if(c==cmd)
		{
			Thread t=new Thread(this);
			t.start();
		}
	}
	public void run()
	{
		HttpConnection hc=null;
		InputStream in=null;
		try
		{
			hc=(HttpConnection)Connector.open(input.getString());
			int ch;
			in=hc.openInputStream();
			StringBuffer sb=new StringBuffer();
			while((ch=in.read())!=-1)
				sb.append((char)ch);
			StringItem stringItem=new StringItem(null,sb.toString());
			mForm.append(StringItem);
			mForm=setTitle("done");
		}
		catch(Exception ioe)
		{
			StringItem stringItem=new StringItem(null,ioe.toString());
			mForm.append(stringItem);
			mForm.setTitle("done");
		}
		finally
		{
			try
			{
				if(in!=null)		in.close()