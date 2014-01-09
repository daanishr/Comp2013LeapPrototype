package prototype;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.HandList;
import com.leapmotion.leap.Vector;

public class LeapHandler 
{
	private Controller controller;
	
	public LeapHandler()
	{
		controller = new Controller();
		
	}
	
	public int getAxis(char axis)
	{
		Frame frame = controller.frame();
		HandList hands = frame.hands();
		
		Vector handPos = hands.get(0).palmPosition();
		
		switch (axis)
		{
		case 'x': return (int) handPos.getX();
		case 'y': return (int) handPos.getY();
		case 'z': return (int) handPos.getZ();
		}
		
		return 0;
	}
	
	public int getSpeed()
	{
		Frame frame = controller.frame();
		HandList hands = frame.hands();
		
		Vector handPos = hands.get(0).palmPosition();
		
		if (handPos.getX()>handPos.getY())
		{
			return (int) handPos.getX()/5;
		}
		else
			return (int) handPos.getY()/5;
			
	}
	
	
	

}
