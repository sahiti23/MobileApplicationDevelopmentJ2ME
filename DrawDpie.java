import javax.microedition.lcdui.*;
class DrawDpie extends Canvas
{
	
	  int x,y,w,h;
                 private int a,b,c,e;
	public DrawDpie(int a1,int b1,int c1,int e1)
	{
		a=a1;b=b1;c=c1;e=e1;
                                 x=30;y=30;w=100;h=100;
	}
	public void paint(Graphics g)
	{
		
                                g.setColor(0xffffff);
                                g.fillRect(0,0,getWidth(),getHeight());
                                System.out.println("demo");
		g.setColor(0xff0000);
		g.fillArc(x,y,w,h,0,a);

		g.setColor(0x00ff00);
		g.fillArc(x,y,w,h,a,b);

		g.setColor(0x0000ff);
		g.fillArc(x,y,w,h,a+b,c);
	
		g.setColor(0xff0070);
		g.fillArc(x,y,w,h,a+b+c,e);		

	}
}