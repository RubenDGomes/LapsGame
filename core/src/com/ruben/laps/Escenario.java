package com.ruben.laps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ruben on 11/10/2017.
 */

public class Escenario extends Stage {
    Tablero tablero;
    Ficha fichac;
    Ficha fichas;

    public Escenario(Viewport viewport, int region1, int region2) {
        super(viewport);
       // fichac = new Ficha (Gdx.graphics.getWidth()/2 -100, Gdx.graphics.getHeight() /2 -100, 1, 200);
       // this.addActor(fichac.movimiento(360f));

        tablero = new Tablero(region1, region2);
        fichas = new Ficha (Constants.WORLD_WIDTH /2 -100, Constants.WORLD_HEIGTH /2 -100, 2, 200, 500, 0.0174533f);
        this.addActor(fichas);
        tablero.agregarAlStage(this);
    }
}
