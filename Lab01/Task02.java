import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.io.*;
public class Task02 implements GLEventListener{

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile

    	Task02 l = new Task02();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(800, 600);

        final JFrame frame = new JFrame ("Shan");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glPointSize(2);
        gl.glBegin (GL2.GL_POINTS);//static field
    
        try {
       		File file = new File("C:\\Users\\binay\\Downloads\\input.txt"); 
            
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            
            String st; 
            while ((st = br.readLine()) != null){ 
				float x = Float.parseFloat(st);
                st = br.readLine();
                double y = Float.parseFloat(st);
                gl.glVertex2d(x,y);
              }
       	
        }
       	catch(Exception e){
       		System.out.println("Empty");
       	}
        gl.glEnd();

    }

    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    public void init(GLAutoDrawable drawable) {
        // method body
        //4. drive the display() in a loop
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
    //end of main
}//end of classimp