import javax.microedition.lcdui.*;
class DrawRect extends Canvas
{
	private int x,y,h,w;
	public DrawRect(int nx,int ny,int nw,int nh)
	{
		x=nx; y=ny; h=nh; w=nw;
	}
	public void paint(Graphics g)
	{
		System.out.println("demo");
		g.setColor(0xffffff);
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(0xff0000);
		g.fillArc(x,y,w,h,0,90);
		g.setColor(0x00ff00);
		g.fillArc(x,y,w,h,90,90);
	}
}