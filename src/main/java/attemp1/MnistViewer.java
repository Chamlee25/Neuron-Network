package attemp1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MnistViewer extends JPanel {
    private static final long serialVersionUID = 1L;
    private int[] pixels;
    private int size;

    public MnistViewer(int[] pixels, int size) {
        this.pixels = pixels;
        this.size = size;
        setPreferredSize(new Dimension(size * 12, size * 12));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Nafocení obrazu
        AffineTransform at = new AffineTransform();
        at.scale(12, 12);
        g2d.setTransform(at);

        // Vykreslení obrázku
        for (int i = 0; i < pixels.length; i++) {
            int grayValue = 255 - pixels[i];
            g2d.setColor(new Color(grayValue, grayValue, grayValue));
            int x = i % size;
            int y = i / size;
            g2d.fillRect(x, y, 1, 1);
        }

        g2d.dispose();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\programming\\java\\Neural Network\\src\\main\\resources\\mnist_test.csv"));
        String line = br.readLine(); // skip header line
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int label = Integer.parseInt(values[0]);
            int[] pixels = new int[values.length - 1];
            for (int i = 1; i < values.length; i++) {
                pixels[i - 1] = Integer.parseInt(values[i]);
            }
            MnistViewer viewer = new MnistViewer(pixels, 28);
            JFrame frame = new JFrame();
            frame.getContentPane().add(viewer);
            frame.pack();
            frame.setLocationRelativeTo(null); // Centrování okna
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            break; // Show only the first image and then exit the loop
        }
        br.close();
    }
}

