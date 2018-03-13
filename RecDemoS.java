import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;

public class RecDemoS extends MIDlet implements CommandListener
{
	Display disp;
	Form f;
	TextField t;
	Command cmd,cdisp,nrec;
	RecordStore rs;
	public RecDemoS()
	{
		disp=Display.getDisplay(this);
		f=new Form("rms");
		t=new TextField("demo","",40,TextField.ANY);
		cmd=new Command("Add",Command.OK,0);
		cdisp=new Command("Display",Command.OK,0);
		nrec=new Command("No of Records",Command.OK,0);
		f.append(t);
		f.addCommand(cmd);
		f.addCommand(cdisp);
		f.addCommand(nrec);
		f.setCommandListener(this);

	}
	public void commandAction(Command src,Displayable d)
	{
		if(src==cmd)
		{
			try
			{
				rs=RecordStore.openRecordStore("name2",true);
				String s=t.getString();
				byte b[]=s.getBytes();
				int n=rs.addRecord(b,0,b.length);
				System.out.println(n);
				rs.closeRecordStore();
			}
			catch(Exception e)
				{}
		}
		else if(src==nrec)
		{
			try
			{
				rs=RecordStore.openRecordStore("name2",true);
				System.out.println("no of records"+rs.getNumRecords());
				rs.closeRecordStore();
			}
			catch(Exception e){}
		}
		if(src==cdisp)
		{   
			try
			{
				rs=RecordStore.openRecordStore("name2",true);
				int n=rs.getNumRecords();
                                                                
				byte[] b;
				RecordEnumeration re=rs.enumerateRecords(null,new NameComp(),false);
				for(int i=1;i<=n;i++)
				{              
					//b=new byte[rs.getRecordSize(i)];
					//rs.getRecord(i,b,0);
					b=re.nextRecord();
					System.out.println(new String(b));
					f.append(new StringItem("",new String(b)));
				}
			rs.closeRecordStore();	
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}	
	}
	public void startApp()
	{
		disp.setCurrent(f);
	}
	public void destroyApp(boolean b)
	{
		
	}
	public void pauseApp()
	{}	
	
}