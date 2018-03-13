import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class DrawD extends MIDlet implements CommandListener
{
	DrawDpie d1;
	Display disp;
	TextField t1,t2,t3,t4;
	Form f1;
	Command next;
	public DrawD()
	{	
		
		f1=new Form("Dynamic values from user");
		t1=new TextField("1st no.","",40,TextField.NUMERIC);
		t2=new TextField("2nd no.","",40,TextField.NUMERIC);
		t3=new TextField("3rd no.","",40,TextField.NUMERIC);
		t4=new TextField("4th no.","",40,TextField.NUMERIC);
		f1.append(t1);
		f1.append(t2);
		f1.append(t3);
		f1.append(t4);
		disp=Display.getDisplay(this);
		next=new Command("next",Command.OK,1);
		f1.addCommand(next);
		f1.setCommandListener(this);
	}
	public void startApp()
	{
		disp.setCurrent(f1);
	}
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	public void commandAction(Command next,Displayable d)
	{
		int x1=Integer.parseInt(t1.getString());
		int x2=Integer.parseInt(t2.getString());
		int x3=Integer.parseInt(t3.getString());
		int x4=Integer.parseInt(t4.getString());
		int total=x1+x2+x3+x4;
                                System.out.println(total+"");
		int a,b,c,e;
		float deg1=360.0f/total;
		a=(int)(x1*deg1);
		b=(int)(x2*deg1);
		c=(int)(x3*deg1);
		e=(int)(x4*deg1);
                                d1=new DrawDpie(a,b,c,e);
                                disp.setCurrent(d1);
		
	}
	
		
			
}