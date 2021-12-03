package Lab1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

class Task02 implements GLEventListener {

    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL ().getGL2 ();
        GLU glu = new GLU ();

        int width = 500;
        int height = 600;

        gl.glClearColor (255.0f, 255.0f, 255.0f, 255.0f);
        gl.glViewport (0, 0, width, height);
        gl.glMatrixMode (GL2.GL_PROJECTION);
        gl.glLoadIdentity ();
        glu.gluOrtho2D (0.0f, width, 0.0f, height);
    }

    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL ().getGL2 ();
        gl.glClear (GL2.GL_COLOR_BUFFER_BIT);


        gl.glColor3d (0, 0, 0);
        DDAPlain (gl, 150, 100, 100, 450);

        gl.glColor3d (0, 0, 255);
        DDADot (gl, 150, 260, 270, 270);

        gl.glColor3d (0, 0, 255);
        DDAPlain (gl, 150, 350, 450, 450);


        gl.glColor3d (0, 0, 255);
        DDAPlain (gl, 150, 350, 100, 100);

        gl.glEnd ();
    }

    private void DDAPlain(GL2 gl, int x1, int x2, int y1, int y2) {
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        int steps = Math.max (Math.abs (diffX), Math.abs (diffY));

        int x_inc = diffX / steps;
        int y_inc = diffY / steps;

        gl.glPointSize (2.0f);
        gl.glBegin (GL2.GL_POINTS);
        for (int i = 0; i < steps; i++) {
            gl.glVertex2d (Math.round (x1), Math.round (y1));
            x1 += x_inc;
            y1 += y_inc;
        }
    }

    private void DDADot(GL2 gl, int x1, int x2, int y1, int y2) {
        int delX = x2 - x1;
        int delY = y2 - y1;
        int steps = Math.max (Math.abs (delX), Math.abs (delY));

        int mod = 0;

        gl.glPointSize (1.0f);
        gl.glBegin (GL2.GL_POINTS);
        if (y1 == y2) {
            while (x1 < x2) {
                x1 += 1;
                if (mod % 2 == 0) gl.glVertex2d (Math.round (x1), Math.round (y1));
                mod += 1;
            }
        } else if (x1 == x2) {
            while (y1 < y2) {
                y1 += 1;
                if (mod % 4 == 0) gl.glVertex2d (Math.round (x1), Math.round (y1));
                mod += 1;
            }
        } else {
            float slope = delY - delX;
            if (-1 < slope && slope > 1) {
                while (x1 < x2) {
                    x1 = x1 + 1;
                    y1 += slope;
                    if (mod % 2 == 0) gl.glVertex2d (Math.round (x1), Math.round (y1));
                    mod += 1;
                }
            } else {
                while (y1 < y2) {
                    x1 += slope;
                    y1 += 1;
                    if (mod % 2 == 0) gl.glVertex2d (Math.round (x1), Math.round (y1));
                    mod += 1;
                }
            }
        }
    }


    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void dispose(GLAutoDrawable arg0) {

    }
}
