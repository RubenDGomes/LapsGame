package com.ruben.laps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

/**
 * Created by ruben on 10/24/2017.
 */

public class Casilla extends Actor {
    boolean ocupada;
    private Ficha ficha;
    private TextureRegion casilla;

    public Casilla (float x, float y, float lado, boolean ocupada) {
        this.ocupada = ocupada;
        casilla = new TextureRegion(LapsGame.textureAtlas.findRegion(String.valueOf(0)));
        this.setBounds(x, y, lado, lado);
    }

    public Vector2 getPos () {
        return new Vector2(getX(), getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(casilla, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    public void setFicha (Ficha ficha) {
        this.ficha = ficha;
    }

    public Ficha getFicha() {
        return this.ficha;
    }

    public boolean isOcupada (Ficha f) {
        return f != null;
    }

    public int getValorFicha (Ficha f) {
        return f.getValorFicha();
    }

}
