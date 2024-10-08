package controlador;

import modelo.Barra;
import modelo.Pelota;
import vista.PanelPelota;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPelota {
    private Pelota pelota;
    private Barra barra;
    private PanelPelota panelPelota;
    private Timer temporizador;
    private ManejadorDeColisiones manejadorDeColisiones;

    public ControladorPelota(Pelota pelota, Barra barra, PanelPelota panelPelota, ManejadorDeColisiones manejadorDeColisiones) {
        this.pelota = pelota;
        this.barra = barra;
        this.panelPelota = panelPelota;
        this.manejadorDeColisiones = manejadorDeColisiones;

        temporizador = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelota.mover();
                manejadorDeColisiones.verificarColision(pelota, barra);
                panelPelota.actualizarPanel();
            }
        });
    }

    public void iniciar() {
        temporizador.start();
    }

    public void detener() {
        temporizador.stop();
    }
}
