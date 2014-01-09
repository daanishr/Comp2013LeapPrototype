package prototype;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


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
			System.exit(-1);
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
			Display.sync(60);
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
