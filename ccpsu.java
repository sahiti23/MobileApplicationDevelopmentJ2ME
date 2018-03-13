import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class ccpsu extends MIDlet implements ItemStateListener
{
	Display d1;
	Form f1;
	ChoiceGroup g1;
	ChoiceGroup g2;
	public ccpsu()
	{
		f1=new Form("OptionsDemo");
		d1=Display.getDisplay(this);
		g1=new ChoiceGroup("options",Choice.MULTIPLE);
		g1.append("cut",null);
		g1.append("copy",null);
		g1.append("paste",null);

		g2=new ChoiceGroup("options",Choice.EXCLUSIVE);
		g2.append("select",null);
		g2.append("unselect all",null);
		f1.append(g1);
		f1.append(g2);
		f1.setItemStateListener(this);
	}
	public void startApp()
	{
		d1.setCurrent(f1);
	}
	public void destroyApp(boolean b){}
	public void pauseApp(){}
	
	public void itemStateChanged(Item i)
	{
		boolean b[]=new boolean[g1.size()];
		if(i==g2)
		{
			int a;
			if(g2.isSelected(0))
			for(a=0;a<3;a++)
				b[a]=true;	
			if(g2.isSelected(1))
			for(a=0;a<3;a++)
				b[a]=false;	
		g1.setSelectedFlags(b);
		}
	}
}