import javax.microedition.rms.*;
public class NameComp implements RecordComparator
{
	public int compare(byte[] b1,byte[] b2)
	{
		String s1=new String(b1);
		String s2=new String(b2);
		if(s1.compareTo(s2)>0)
			return RecordComparator.FOLLOWS;
		else if(s1.compareTo(s2)<0)
			return RecordComparator.PRECEDES;
		else 
			return RecordComparator.EQUIVALENT;
	
	}
}