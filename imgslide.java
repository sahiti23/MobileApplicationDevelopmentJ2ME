import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class imgslide extends MIDlet
{
	Image[] src;
	Display disp;
	Form f1;
	ImageItem i1;
	public imgslide()
	{
		disp=Display.getDisplay(this);
		f1=new Form("image slide");
		src=new Image[3];
		try{
			src[0]=Image.createImage("/img1.png");
			src[1]=Image.createImage("/img2.png");
			src[2]=Image.createImage("/img3.png");
			i1=new ImageItem("",src[0],Item.LAYOUT_DEFAULT,"image not supported");
			f1.append(i1);
		}
		catch(Exception e)
		{}
		
	}
	public void startApp()
	{
		disp.setCurrent(f1);
		try{
			for(int j=0;;j++)
			{
				if(j==3)
				j=0;
				i1.setImage(src[j]);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{}
	}
		
	public void destroyApp(boolean b)
	{
	}
	public void pauseApp()
	{
		
		
	}
}