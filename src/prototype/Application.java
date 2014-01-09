package prototype;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * 
 * Generic LWJGL Application SuperCLass. contains the boiler plate code for the window.
 * currently, window size is fixed and cannot be resized, but for the purposes of demonstrating
 * the leap motion functionality, it is satisfactory.
 *
 */
public class Application 
{
	protected LeapHandler leap;
	
	public Application()
	{
		leap = new LeapHandler();
		try{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
			
			begin();
		   }
		
		catch(LWJGLException e)
		{
			e.printStackTrace();
			System.exit(-1);  // this application is hardware accelerated.
		}
		
	}
	
	private void begin()
	{
		Initialise();
		while(!Display.isCloseRequested())
		{
			update();
			render();
			Display.update();
			Display.sync(60);    // 60 frames per second ( matching monitor refresh rate)
		}
		destroy();
	}
	
	public void Initialise()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		
	}
	
	public void destroy()
	{
		Display.destroy();System.exit(0);
	}
	

}
