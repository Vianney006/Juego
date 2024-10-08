package modelo;

public class Pelota {
    private int x, y; // Posición de la pelota
    private int velocidadX, velocidadY; // Velocidad de la pelota
    private int radio; // Radio de la pelota
    private int anchoPanel, altoPanel; // Dimensiones del área de dibujo

    public Pelota(int x, int y, int radio, int velocidadX, int velocidadY, int anchoPanel, int altoPanel) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.anchoPanel = anchoPanel;
        this.altoPanel = altoPanel;
    }

    public void mover() {
        x += velocidadX;
        y += velocidadY;

        // Detectar los bordes y cambiar la dirección si es necesario
        if (x - radio < 0 || x + radio > anchoPanel) {
            velocidadX = -velocidadX;
        }
        if (y - radio < 0 || y + radio > altoPanel) {
            velocidadY = -velocidadY;
        }
    }

    // Métodos getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadio() {
        return radio;
    }

    public void rebotarVerticalmente() {
        velocidadY = -velocidadY;
    }
}
