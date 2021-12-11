package Lab2;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.*;

/**
 * @author Tanvir Rahman
 * @ID 19101268
 * @Section 04
 **/

public class Lab02_19101268 {
    public static void main(String[] args) {
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        int width = 600;
        int height = 700;

        Task task = new Task();

        final GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(task);
        canvas.setSize(width, height);

        final JFrame frame = new JFrame("Task - 19101268 - Lab 02");
        frame.add(canvas);
        frame.pack();
        frame.setSize(width, height);
        frame.setBounds(0, 0, width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
