package vista;

import controlador.Pelota;
import modelo.Barra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PanelPelota extends JPanel {
    private Pelota pelota;
    private Barra barra;
    private ImageIcon fondo;
    private BufferedImage imagenPelota;
    private BufferedImage imagenBarra;

    public PanelPelota(Pelota pelota, Barra barra) {
        this.pelota = pelota;
        this.barra = barra;

        fondo = new ImageIcon("media/fondo1.gif");

        // Cargar las imágenes
        try {
            imagenPelota = ImageIO.read(new File("media/balin.png")); // Asegúrate de que la ruta sea correcta
            imagenBarra = ImageIO.read(new File("media/rectangulo.png")); // Asegúrate de que la ruta sea correcta
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                barra.mover(e.getX());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }
        });

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen de fondo (GIF)
        if (fondo != null) {
            g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
        }

        // Dibujar la pelota
        if (imagenPelota != null) {
            g.drawImage(imagenPelota, pelota.getX() - pelota.getRadio(), pelota.getY() - pelota.getRadio(),
                    pelota.getRadio() * 2, pelota.getRadio() * 2, this);
        }

        // Dibujar la barra
        if (imagenBarra != null) {
            g.drawImage(imagenBarra, barra.getX(), barra.getY(), barra.getAncho(), barra.getAlto(), this);
        }
    }

    public void actualizarPanel() {
        repaint();
    }
}
