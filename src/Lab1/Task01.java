package Lab1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

class Task01 implements GLEventListener {

    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL ().getGL2 ();
        GLU glu = new GLU ();

        gl.glMatrixMode (GL2.GL_PROJECTION);
        gl.glLoadIdentity ();

        int width = 500;
        int height = 600;

        glu.gluOrtho2D (0.0f, width, 0.0f, height);
        gl.glMatrixMode (GL2.GL_MODELVIEW);
        gl.glLoadIdentity ();
        gl.glViewport (0, 0, width, height);
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL ().getGL2 ();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3d (255, 255, 255);
        gl.glBegin (GL2.GL_LINES);

        int a = 100;
        int b = 200;
        int c = 250;
        int d = 400;
        int e = 500;

        gl.glVertex2d (a, d);
        gl.glVertex2d (d, d);

        gl.glVertex2d (d, d);
        gl.glVertex2d (c, a);

        gl.glVertex2d (c, a);
        gl.glVertex2d (a, d);

        gl.glVertex2d (a, b);
        gl.glVertex2d (d, b);

        gl.glVertex2d (d, b);
        gl.glVertex2d (c, e);

        gl.glVertex2d (c, e);
        gl.glVertex2d (a, b);

        gl.glEnd ();

    }


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void dispose(GLAutoDrawable arg0) {

    }
}


