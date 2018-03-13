import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class Arthmul extends MIDlet implements CommandListener
{
	TextField num1,num2,res;
	Display disp;
	Form f1;
	Command mul;
	public Arthmul()
	{
		num1=new TextField("enter no.","",4,TextField.NUMERIC);
		num2=new TextField("enter no.","",4,TextField.NUMERIC);
		res=new TextField("res","",4,TextField.NUMERIC);
		disp=Display.getDisplay(this);
		mul=new Command("mul",Command.OK,1);
		f1=new Form("calculator");
		f1.append(num1);
		f1.append(num2);
		f1.append(res);
		f1.addCommand(mul);
		f1.setCommandListener(this);
	}
	public void startApp()
	{
		disp.setCurrent(f1);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	public void commandAction(Command cmd,Displayable d)
	{
		int n1=Integer.parseInt(num1.getString());
 		int n2=Integer.parseInt(num2.getString());
		if(cmd==mul)
		{
			res.setString(""+(n1*n2)); 
		}
	}
}