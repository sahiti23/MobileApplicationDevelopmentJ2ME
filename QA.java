import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class QA extends MIDlet implements CommandListener
{
	TextField t1;
	Display d1;
	Form f1;
	ChoiceGroup g1;
	ChoiceGroup g2;
	ChoiceGroup g3;
	ChoiceGroup g4;
	Command cmd;
	public QA()
	{
		t1=new TextField("No. Of Correct Answers","",40,TextField.NUMERIC);
		f1=new Form("TextDemo");
		d1=Display.getDisplay(this);
		f1.append(t1);
		g1=new ChoiceGroup("1Q)Who is President Of INDIA?",Choice.EXCLUSIVE);
		g1.append("A P J ABDUL KALAM",null);
		g1.append("PRANAB MUKHERJEE",null);
		g1.append("Prathibha Patil",null);
		g1.append("Manmohan Singh",null);
		f1.append(g1);

		g2=new ChoiceGroup("2Q)Capital Of INDIA?",Choice.EXCLUSIVE);
		g2.append("Hyd",null);
		g2.append("Delhi",null);
		g2.append("Mumbai",null);
		g2.append("Kerela",null);
		f1.append(g2);

		g3=new ChoiceGroup("3Q)Prime Minister Of INDIA?",Choice.EXCLUSIVE);
		g3.append("Narendra Modi",null);
		g3.append("Rajnath Singh",null);
		g3.append("Venkaih Naidu",null);
		g3.append("Chandra Babu Naidu",null);
		f1.append(g3);

		g4=new ChoiceGroup("4Q)Prime Minister Of INDIA?",Choice.EXCLUSIVE);
		g4.append("Narendra Modi",null);
		g4.append("Rajnath Singh",null);
		g4.append("Venkaih Naidu",null);
		g4.append("Chandra Babu Naidu",null);
		f1.append(g4);

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
		int i;
		int y=0;
		for(i=1;i<=4;i++)
		{
			int n1=g1.getSelectedIndex();
  			if(g1.getString(n1).equals("PRANAB MUKHERJEE"))
			{
				y++;
				break;
			}
		}

		for(i=1;i<=4;i++)
		{
			int n1=g2.getSelectedIndex();
  			if(g2.getString(n1).equals("Delhi"))
			{
				y++;
				break;
			}
		}
		for(i=1;i<=4;i++)
		{
			int n1=g3.getSelectedIndex();
  			if(g3.getString(n1).equals("Narendra Modi"))
			{		
				y++;
				break;
			}
		}
		for(i=1;i<=4;i++)
		{
			int n1=g4.getSelectedIndex();
  			if(g4.getString(n1).equals("Narendra Modi"))
			{	
				y++;
				break;
			}
		}
		t1.setString("" +y);
	}
}