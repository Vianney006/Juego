package controlador;

import modelo.Barra;
import vista.PanelPelota;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.UnexpectedException;


public class ControladorPelota {
    private Pelota pelota;
    private Barra barra;
    private PanelPelota panelPelota;
    private Timer temporizador;
    private Clip sonidoColision;

    public ControladorPelota(Pelota pelota, Barra barra, PanelPelota panelPelota) {
        this.pelota = pelota;
        this.barra = barra;
        this.panelPelota = panelPelota;

        //Cargar el sonido de colision
        try {
            File sonidoFile = new File("media/sonidodegota.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonidoFile);
            sonidoColision = AudioSystem.getClip();
            sonidoColision.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        temporizador = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pelota.mover();
                verificarColision();
                panelPelota.actualizarPanel();
            }
        });
    }

    private void verificarColision() {
        if (pelota.getY() + pelota.getRadio() >= barra.getY() &&
                pelota.getX() >= barra.getX() &&
                pelota.getX() <= barra.getX() + barra.getAncho()) {
            pelota.rebotarVerticalmente();
            sonidoColision.setFramePosition(0);
            sonidoColision.start();
        }
    }

    public void iniciar() {
        temporizador.start();
    }

    public void detener() {
        temporizador.stop();
    }
}
