import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        StdDraw.setCanvasSize(800, 600);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();

        double horasEstudio = 0;
        double horasPorSegundo = 0;

        int semestre = 1;

        int cantidadLibrerias = 0;
        int cantidadTutorias = 0;
        int cantidadSalasEstudio = 0;

        double costoLibreria = 50;
        double costoTutoria = 200;
        double costoSala = 500;

        long lastTime = System.currentTimeMillis();


        double iconX = 0.5;
        double iconY = 0.6;
        double imageWidth = 0.2;
        double imageHeight = 0.2;
        double imageHalfWidth = imageWidth / 2;
        double imageHalfHeight = imageHeight / 2;

        while (true) {

            long now = System.currentTimeMillis();
            if (now - lastTime >= 1000) {
                horasEstudio += horasPorSegundo;
                lastTime = now;
            }

            StdDraw.clear();


            StdDraw.picture(iconX, iconY, "Escudo-UCN-Logos.png", imageWidth, imageHeight);


            StdDraw.setPenColor(Color.BLACK);
            StdDraw.text(0.5, 0.95, "Horas de estudio: " + (int) horasEstudio);
            StdDraw.text(0.5, 0.90, "Horas por segundo: " + horasPorSegundo);
            StdDraw.text(0.5, 0.85, "Semestre: " + semestre);
            StdDraw.text(0.5, 0.80, "Librerías: " + cantidadLibrerias + " (Q)");
            StdDraw.text(0.5, 0.75, "Tutorías: " + cantidadTutorias + " (W)");
            StdDraw.text(0.5, 0.70, "Salas de Estudio: " + cantidadSalasEstudio + " (E)");


            semestre = (int) (horasEstudio / 500) + 1;
            if (horasEstudio >= 10000) {
                StdDraw.text(0.5, 0.5, "¡Te graduaste!!! Muchas gracias por jugar");
                StdDraw.show();
                StdDraw.pause(3000);
                break; //


            }

            StdDraw.show();

            if (StdDraw.isMousePressed()) {
                double mouseX = StdDraw.mouseX();
                double mouseY = StdDraw.mouseY();

                if (mouseX >= iconX - imageHalfWidth && mouseX <= iconX + imageHalfWidth &&
                        mouseY >= iconY - imageHalfHeight && mouseY <= iconY + imageHalfHeight) {
                    horasEstudio += 1;
                }
            }


            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                switch (key) {
                    case 'q':
                        if (horasEstudio >= costoLibreria) {
                            horasEstudio -= costoLibreria;
                            cantidadLibrerias++;
                            horasPorSegundo += 0.5;
                        }
                        break;
                    case 'w':
                        if (horasEstudio >= costoTutoria) {
                            horasEstudio -= costoTutoria;
                            cantidadTutorias++;
                            horasPorSegundo += 25;
                        }
                        break;
                    case 'e':
                        if (horasEstudio >= costoSala) {
                            horasEstudio -= costoSala;
                            cantidadSalasEstudio++;
                            horasPorSegundo += 50;
                        }
                        break;
                }
            }

            StdDraw.pause(20);
        }
    }
}