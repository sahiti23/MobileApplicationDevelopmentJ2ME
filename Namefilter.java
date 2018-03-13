import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import javax.microedition.rms.*;
import java.io.*;

public class Namefilter implements RecordFilter
{
	String n;
	public Namefilter(String s)
	{
		n=s;
	}
	public boolean matches(byte[] b)
	{
		try{
			ByteArrayInputStream bis=new ByteArrayInputStream(b);
			DataInputStream dis=new DataInputStream(bis);
			String name=dis.readUTF();
			
			if(n.equals(name))
			{
				return true;
			}
			else
			{
				return false;
			}
			//bis.reset();
		}catch(Exception e){}
		return false;
	}
}