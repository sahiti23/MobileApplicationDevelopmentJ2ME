import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class phno extends MIDlet implements CommandListener
{
	TextField t1;
	Display disp;
	Form f1;
	Alert msg;
	Command exit,show;
	public phno()
	{
		t1=new TextField("enter number","",40,TextField.NUMERIC);
		disp=Display.getDisplay(this);
		exit=new Command("exit",Command.OK,0);
		show=new Command("show",Command.OK,1);
		f1=new Form("phdemo");
		f1.append(t1);
		f1.addCommand(show);
		f1.addCommand(exit);
		f1.setCommandListener(this);
	}
	public void startApp()
	{
		disp.setCurrent(f1);
	}
	public void destroyApp(boolean b)
	{
	}
	public void pauseApp()
	{
		
		
	}
	public void commandAction(Command cmd,Displayable d)
	{
		String s=t1.getString().trim();
		String msg1="invalid";
				int len=s.length();
		if((s.startsWith("040")&&(!s.startsWith("0400")))||s.startsWith("044")||s.startsWith("041")||s.startsWith("050"))
			if(s.length()>=9&&s.length()<=11)
				msg1="valid";
		if(s.startsWith("0400"))
			if(s.length()>=10&&s.length()<=12)
				msg1="valid";
		msg=new Alert("information",msg1,null,AlertType.INFO);
		disp.setCurrent(msg);
	}
}
		
			