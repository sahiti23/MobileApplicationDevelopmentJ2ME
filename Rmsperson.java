import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;
import javax.microedition.io.*;
import java.io.*;
public class Rmsperson extends MIDlet implements CommandListener
{
	Display disp;
	Form f1;
	TextField name,age;
	Command add,show,find;
	public Rmsperson()
	{
		disp=Display.getDisplay(this);
		f1=new Form("person details");
		name=new TextField("enter name:","",30,TextField.ANY);
		age=new TextField("enter age:","",5,TextField.NUMERIC);
		add=new Command("add",Command.OK,1);
		show=new Command("show",Command.OK,2);
		find=new Command("find",Command.OK,3);
		f1.append(name);
		f1.append(age);
		f1.addCommand(add);
		f1.addCommand(show);
		f1.addCommand(find);
		f1.setCommandListener(this);
	
	}
	public void startApp()
	{
		disp.setCurrent(f1);
	}
	public void pauseApp()
	{}
	public void destroyApp(boolean b)
	{}
	public void commandAction(Command cmd,Displayable d)
	{
		if(cmd==add)
		{
			RecordStore rs;
			try{
				rs=RecordStore.openRecordStore("names5",true);
				String n=name.getString();
				int a=Integer.parseInt(age.getString());
				ByteArrayOutputStream bos=new ByteArrayOutputStream();
				DataOutputStream dos=new DataOutputStream(bos);
				dos.writeUTF(n);
				dos.writeInt(a);
				dos.flush();
				byte[] b=bos.toByteArray();
				int z=rs.addRecord(b,0,b.length);
				System.out.println(z);
				rs.closeRecordStore();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(cmd==show)
		{
			RecordStore rs;
			try{
				rs=RecordStore.openRecordStore("names5",true);
				byte[] b=new byte[100];
				
				ByteArrayInputStream bis=new ByteArrayInputStream(b);
				DataInputStream dis=new DataInputStream(bis);
				int n=rs.getNumRecords();
				for(int i=1;i<=n;i++)
				{
					rs.getRecord(i,b,0);
					
					System.out.println(dis.readUTF()+":"+dis.readInt());
					bis.reset();
				}
				rs.closeRecordStore();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(cmd==find)
		{
			try{
				RecordStore rs;
				rs=RecordStore.openRecordStore("names5",true);
				RecordEnumeration re=rs.enumerateRecords(new Namefilter(name.getString()),null,false);
				byte[] b=new byte[100];
				ByteArrayInputStream bis=new ByteArrayInputStream(b);
				DataInputStream dis=new DataInputStream(bis);
				while(re.hasNextElement())
				{
					rs.getRecord(re.nextRecordId(),b,0);
					System.out.println(dis.readUTF()+""+dis.readInt());
					bis.reset();
				}
				rs.closeRecordStore();
				bis.close();
				dis.close();

			}
			catch(Exception e){e.printStackTrace();}
		}

	}
}