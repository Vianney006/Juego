package controlador;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorDeSonido {
    private Clip sonidoColision;

    public ReproductorDeSonido() {
        try {
            File sonidoFile = new File("media/sonidodegota.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonidoFile);
            sonidoColision = AudioSystem.getClip();
            sonidoColision.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducirSonidoDeColision() {
        if (sonidoColision != null) {
            sonidoColision.setFramePosition(0);
            sonidoColision.start();
        }
    }
}
