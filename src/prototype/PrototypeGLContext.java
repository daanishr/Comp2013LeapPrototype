package prototype;


import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.util.glu.GLU.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;


/**
 * All OpenGL tasks relating to creating, translating and rendering handled here.
 * 
 *
 */

public class PrototypeGLContext extends Application {
	
	int vertexHandle;
	int colorHandle;
	
 
	public void Initialise()
	{
		glMatrixMode(GL_PROJECTION);
		
		// 3D shape has a more realistic look with Perspective mode rather than Orthographic
		gluPerspective(70f, 800f/600f, 1, 10);
		
		// render to the full size of the window
		glViewport(0,0,Display.getWidth(), Display.getHeight());
		
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		
		glEnable(GL_DEPTH_TEST);
	
		glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_COLOR_ARRAY);
        
   
        FloatBuffer vertexBuffer = BufferUtils.createFloatBuffer(3*24);
        vertexBuffer.put(new float[]
        {
            
            -0.5f,  0.5f,  0.5f,
             0.5f,  0.5f,  0.5f,
            -0.5f, -0.5f,  0.5f,
             0.5f, -0.5f,  0.5f,

          
             0.5f,  0.5f,  0.5f,
             0.5f,  0.5f, -0.5f,
             0.5f, -0.5f,  0.5f,
             0.5f, -0.5f, -0.5f,
            
      
             0.5f,  0.5f, -0.5f,
            -0.5f,  0.5f, -0.5f,
             0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f, -0.5f,
            
        
            -0.5f,  0.5f, -0.5f,
            -0.5f,  0.5f,  0.5f,
            -0.5f, -0.5f, -0.5f,
            -0.5f, -0.5f,  0.5f,
            
    
            -0.5f,  0.5f,  0.5f,
             0.5f,  0.5f,  0.5f,
            -0.5f,  0.5f, -0.5f,
             0.5f,  0.5f, -0.5f,
            

            -0.5f, -0.5f,  0.5f,
             0.5f, -0.5f,  0.5f,
            -0.5f, -0.5f, -0.5f,
             0.5f, -0.5f, -0.5f,
        });
        
         // set the pointer back to the start of buffer
        vertexBuffer.rewind();  // set the pointer back to the start of buffer
        
        FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(3*24);
        colorBuffer.put(new float[]
        {
            // Front face
            1, 0, 0,
            1, 1, 0,
            1, 0, 1,
            1, 0, 0,
            
            // Right face
            1, 1, 1,
            1, 1, 1,
            1, 1, 1,
            1, 1, 1,
            
            // Back face
            0, 1, 1,
            1, 0, 0,
            0, 1, 0,
            0, 1, 1,
            
            // Left face
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
            1, 0, 0,
            
            // Top face
            0, 1, 0,
            1, 0, 1,
            1, 0, 1,
            0, 1, 0,
            
            // Bottom face
            0, 0, 0,
            1, 0, 0,
            0, 0, 0,
            0, 0, 0
        });
        colorBuffer.rewind();
        
        // Allocate buffer space on the GPU and bind to the vertex and colour buffers created
        vertexHandle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vertexHandle);
        glBufferData(GL_ARRAY_BUFFER, vertexBuffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
   
        colorHandle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, colorHandle);
        glBufferData(GL_ARRAY_BUFFER, colorBuffer, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        
     
        // move the camera back in the z axis ( cube centre is drawn around origin)
        glTranslatef(0, 0, -3); 
        
	}
	// method called 60 times per second
	public void render()
	{
	
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        
        //rotation controlled by motion control device
        glRotatef(1, leap.getAxis('z'), leap.getAxis('x'), 0);
        
        glBindBuffer(GL_ARRAY_BUFFER, vertexHandle);
        glVertexPointer(3, GL_FLOAT, 0, 0);
        
        glBindBuffer(GL_ARRAY_BUFFER, colorHandle);
        glColorPointer(3, GL_FLOAT, 0, 0);
       
        glDrawArrays(GL_TRIANGLE_STRIP, 0, 24);
        
       
	}
	
	public void destroy()
	{
		// free memory taken up in the GPU
		 glDeleteBuffers(vertexHandle);
	     glDeleteBuffers(colorHandle);
	     glDisableClientState(GL_VERTEX_ARRAY);
	     glDisableClientState(GL_COLOR_ARRAY);
	}
	public static void main(String[] args)
	{
		new PrototypeGLContext();
	}
}
