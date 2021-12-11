package Lab2;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

/**
 * @author Tanvir Rahman
 * @ID 19101268
 * @Section 04
 **/

public class Task implements GLEventListener {

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        int student_id = 19101268;
        int ltd = student_id % 100;

        System.out.println("Student ID - " + student_id + "\n" + "Last Two Digits - " + ltd);

        //Drawing 6
        convertToZone0(gl, 50 - 1, 500, 200 + 1, 500);          // Horizontal (Up)
        convertToZone0(gl, 50, 500, 50, 200);                   // Vertical (Left)
        convertToZone0(gl, 50, 200 - 1, 200 - 1, 200 - 1);      // Horizontal (Down)
        convertToZone0(gl, 200, 350, 200, 200 + 1);             // Vertical (Right)
        convertToZone0(gl, 50, 350, 200 - 1, 350);              // Horizontal (Middle)

        //Drawing 8
        convertToZone0(gl, 250 - 1, 500, 400 - 1, 500);         // Horizontal (Up)
        convertToZone0(gl, 250, 500, 250, 200);                 // Vertical (Left)
        convertToZone0(gl, 250, 200 - 1, 400 - 1, 200 - 1);     // Horizontal (Down)
        convertToZone0(gl, 400, 500, 400, 200 + 1);             // Vertical (Right)
        convertToZone0(gl, 250, 350, 400 - 1, 350);             // Horizontal (Middle)

        //+1 or -1 has been done to beautify the output.
    }


    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }

    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        GLU glu = new GLU();

        int width = 450;
        int height = 600;

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0f, width, 0.0f, height);
    }

    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // do nothing
    }


    public void Midpoint(GL2 gl, int x1, int y1, int x2, int y2, int zone) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int d = 2 * dy - dx;
        int e = 2 * dy;

        int x = x1;
        int y = y1;

        while (x <= x2) {
            x++;
            if (d <= 0) {
                d += e;
            } else {
                d += 2 * (dy - dx);
                y++;
            }
            originalZone(gl, x, y, zone);
        }
    }

    public void originalZone(GL2 gl, int x, int y, int zone) {
        int a = 0;
        int b = 0;

        if (zone == 1) {
            a = y;
            b = x;
        } else if (zone == 2) {
            a = -y;
            b = x;
        } else if (zone == 3) {
            a = -x;
            b = y;
        } else if (zone == 4) {
            a = -x;
            b = -y;
        } else if (zone == 5) {
            a = -y;
            b = -x;
        } else if (zone == 6) {
            a = y;
            b = -x;
        } else if (zone == 7) {
            a = x;
            b = -y;
        } else {
            a = x;
            b = y;
        }

        gl.glColor3d(0, 128, 0);
        gl.glPointSize(5.0f);
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex3f(a, b, 1);
        gl.glEnd();
    }

    public int findZone(int x1, int y1, int x2, int y2) {
        // Find dx and dy
        int dx = x2 - x1;
        int dy = y2 - y1;

        int zone = 8;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx >= 0 && dy >= 0) {
                zone = 0;
            } else if (dx <= 0 && dy >= 0) {
                zone = 3;
            } else if (dx <= 0) {
                zone = 4;
            } else {
                zone = 7;
            }

        } else {
            if (dx >= 0 && dy >= 0) {
                zone = 1;
            } else if (dx <= 0 && dy >= 0) {
                zone = 2;
            } else if (dx <= 0) {
                zone = 5;
            } else {
                zone = 6;
            }
        }
        return zone;
    }

    public void convertToZone0(GL2 gl, int x1, int y1, int x2, int y2) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int zone = findZone(x1, y1, x2, y2);

        switch (zone) {
            case 1:
                a = y1;
                b = x1;
                c = y2;
                d = x2;
                break;
            case 2:
                a = y1;
                b = -x1;
                c = y2;
                d = -x2;
                break;
            case 3:
                a = -x1;
                b = y1;
                c = -x2;
                d = y2;
                break;
            case 4:
                a = -x1;
                b = -y1;
                c = -x2;
                d = -y2;
                break;
            case 5:
                a = -y1;
                b = -x1;
                c = -y2;
                d = -x2;
                break;
            case 6:
                a = -y1;
                b = x1;
                c = -y2;
                d = x2;
                break;
            case 7:
                a = x1;
                b = -y1;
                c = x2;
                d = -y2;
                break;
            default:
                a = x1;
                b = y1;
                c = x2;
                d = y2;
                break;
        }

        Midpoint(gl, a, b, c, d, zone);
    }
}
