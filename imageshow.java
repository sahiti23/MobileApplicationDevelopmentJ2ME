import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class imageshow extends MIDlet
{
	Display disp;
	Form f1;
	ImageItem i1;
	Image[] src;
	public imageshow()
	{	
		disp=Display.getDisplay(this);
		f1=new Form("Image demo");
		src=new Image[3];
		try
		{
			src[0]=Image.createImage("/sunset.jpg");
			src[1]=Image.createImage("/blue hills.jpg");
			src[2]=Image.createImage("/wel.png");
			i1=new ImageItem("",src[0],Item.LAYOUT_DEFAULT,"Image not supported");
			f1.append(i1);
		}
		catch(Exception e){}
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
	
		}catch(Exception e){}
	}
		
	public void pauseApp(){}
	public void destroyApp(boolean b){}
	
}

/*store the 3 images in "res" folder */