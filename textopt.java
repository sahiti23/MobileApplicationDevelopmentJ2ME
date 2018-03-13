import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class textopt extends MIDlet implements CommandListener
{
	TextField t1;
	Display d1;
	Form f1;
	ChoiceGroup g1;
	Command cmd;
	public textopt()
	{
		t1=new TextField("enter name","",40,TextField.ANY);
		f1=new Form("TextDemo");
		d1=Display.getDisplay(this);
		f1.append(t1);
		g1=new ChoiceGroup("options",Choice.MULTIPLE);
		g1.append("op1",null);
		g1.append("op2",null);
		f1.append(g1);
		cmd=new Command("show",Command.OK,1);
		f1.addCommand(cmd);
		f1.setCommandListener(this);
	}
	public void startApp()
	{
		d1.setCurrent(f1);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	public void commandAction(Command cmd,Displayable d)
	{
		String s="";
		if(g1.isSelected(0))
			s=s+g1.getString(0);
		if(g1.isSelected(1))
			s=s+g1.getString(1);
		t1.setString(s);
	}
}