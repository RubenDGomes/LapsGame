package com.ruben.laps;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;

import java.util.*;


/**
 * Created by ruben on 10/25/2017.
 */

public class Tablero extends Actor {
    private ArrayList<Casilla> region1;
    private ArrayList<Casilla> region2;
    private int valorRegion2;
    private int valorRegion1;
    private Casilla centro;
    private CirculoCasilla circuloRegion1;
    private CirculoCasilla circuloRegion2;
    private float lado;
    private float lado_casilla;

    public Tablero(int valorRegion1, int valorRegion2) {
        this.valorRegion1 = valorRegion1;
        this.valorRegion2 = valorRegion2;
        this.lado = Constants.WORLD_WIDTH;
        this.lado_casilla = 200;
        this.setBounds(0, 0, lado/2, lado/2);
        crearCentro();
        crearRegiones();
    }

    private Casilla crearCentro () {
        Casilla centro = new Casilla(Constants.WORLD_WIDTH /2 - 100, Constants.WORLD_HEIGTH / 2 - 100, lado_casilla, false);
        return centro;
    }

    public float posX (CirculoCasilla c, int cantidad) {
        return c.calcularLongitud(c.getRadio()) / cantidad;
    }

    private void crearRegiones () {
   //     crearCentro();
        float x;
        float y;
        circuloRegion1 = new CirculoCasilla(200);
        circuloRegion2 = new CirculoCasilla(400);
        region1 = new ArrayList<Casilla>();
        region2 = new ArrayList<Casilla>();

        for (int i = 0; i < Constants.REGION1; i++) {
            float angulo = 6.28319f / Constants.REGION1;
                x = circuloRegion1.getPosX(Constants.WORLD_WIDTH / 2 - 100, 165, angulo * i);
                y = circuloRegion1.getPosY(Constants.WORLD_HEIGTH / 2 - 100, 165, angulo * i);
                Casilla casilla = new Casilla(y, x, lado_casilla, false);
                region1.add(casilla);
        }

        for (int i = 1; i < Constants.REGION2 + 1; i++) {
            float angulo = 6.28319f  / Constants.REGION2;
                x = circuloRegion2.getPosX(Constants.WORLD_WIDTH / 2 - 100, 330, angulo *i);
                y = circuloRegion2.getPosY(Constants.WORLD_HEIGTH / 2 - 100, 330, angulo * i);
            Casilla casilla = new Casilla(x, y, lado_casilla, false);
            region2.add(casilla);
        }
    }

    public void agregarAlStage (Stage stage) {
        stage.addActor(this);
        stage.addActor(crearCentro());
        for (Casilla c: region1) {
            stage.addActor(c);
        }

        for (Casilla c2: region2) {
            stage.addActor(c2);
        }
    }


}
