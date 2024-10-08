package controlador;

import modelo.Barra;
import modelo.Pelota;

public class ManejadorDeColisiones {
    private ReproductorDeSonido reproductorDeSonido;

    public ManejadorDeColisiones(ReproductorDeSonido reproductorDeSonido) {
        this.reproductorDeSonido = reproductorDeSonido;
    }

    public void verificarColision(Pelota pelota, Barra barra) {
        if (pelota.getY() + pelota.getRadio() >= barra.getY() &&
                pelota.getX() >= barra.getX() &&
                pelota.getX() <= barra.getX() + barra.getAncho()) {
            pelota.rebotarVerticalmente();
            reproductorDeSonido.reproducirSonidoDeColision();
        }
    }
}
