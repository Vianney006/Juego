import controlador.ControladorPelota;
import controlador.Pelota;
import modelo.Barra;
import vista.PanelPelota;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Pelota que Rebota con Barra");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int ancho = 800;
        int alto = 600;

        Pelota pelota = new Pelota(100, 100, 20, 5, 5, ancho, alto);
        Barra barra = new Barra(350, alto - 50, 100, 10, ancho);

        PanelPelota panelPelota = new PanelPelota(pelota, barra);
        panelPelota.setPreferredSize(new Dimension(ancho, alto));

        ControladorPelota controlador = new ControladorPelota(pelota, barra, panelPelota);

        marco.add(panelPelota);
        marco.pack();
        marco.setVisible(true);

        controlador.iniciar();
    }
}
