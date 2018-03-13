import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
class Drawb extends Canvas
{
	int x[]={40,80};
	public void paint(Graphics g)
	{
		
		g.setColor(0xffffff);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(0x0f0f0f);
		g.drawLine(10,10,10,(getHeight()-10));
		g.setColor(0x0f0f0f);
		g.drawLine(10,(getHeight()-10),(getWidth()-10),(getHeight()-10));
		g.setColor(0xff00ff);
		g.fillRect(20,(getHeight()-10-x[0]),10,x[0]);
		g.setColor(0xffff00);
		g.fillRect(40,(getHeight()-10-x[1]),10,x[1]);
		g.setColor(0xff00ff);
		g.fillRect(180,10,10,10);
		g.drawString("40marks",192,10,0);
		g.setColor(0xffff00);
		g.fillRect(180,25,10,10);
		g.drawString("80marks",192,25,0);
	}
}
