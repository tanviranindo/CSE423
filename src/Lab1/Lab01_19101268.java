package Lab1;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.*;

public class Lab01_19101268 {

    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get (GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities (profile);

        int width = 500;
        int height = 600;

        Task01 a = new Task01 ();
        Task02 b = new Task02 ();

//        final GLCanvas canvas1 = new GLCanvas (capabilities);
//        canvas1.addGLEventListener (a);
//        canvas1.setSize (width, height);
//
//        final JFrame frame1 = new JFrame ("Task 01 - 19101268 - Lab 01");
//        frame1.add (canvas1);
//        frame1.pack ();
//        frame1.setSize (width, height);
//        frame1.setBounds (0, 0, width, height);
//        frame1.setVisible (true);

        final GLCanvas canvas2 = new GLCanvas (capabilities);
        canvas2.addGLEventListener (b);
        canvas2.setSize (width, height);

        final JFrame frame2 = new JFrame ("Task 02 - 19101268 - Lab 01");
        frame2.add (canvas2);
        frame2.pack ();
        frame2.setSize (width, height);
        frame2.setBounds (width + 100, 0, width, height);
        frame2.setVisible (true);
    }
}
