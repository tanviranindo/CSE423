package Lab1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

class Task02 implements GLEventListener {

    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL ().getGL2 ();
        GLU glu = new GLU ();

        gl.glMatrixMode (GL2.GL_PROJECTION);
        gl.glLoadIdentity ();

        int width = 500;
        int height = 600;

        gl.glClearColor (255f, 255f, 255f, 255f);
        glu.gluOrtho2D (0.0f, width, 0.0f, height);
        gl.glMatrixMode (GL2.GL_MODELVIEW);
        gl.glLoadIdentity ();
        gl.glViewport (0, 0, width, height);
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL ().getGL2 ();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3d (0,0,0);

        //CODE


        gl.glEnd ();

    }


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void dispose(GLAutoDrawable arg0) {

    }
}


