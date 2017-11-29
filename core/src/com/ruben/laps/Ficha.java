package com.ruben.laps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;

import java.util.*;

/**
 * Created by ruben on 10/24/2017.
 */

public class Ficha extends Actor {
    int valor;
    private float angulo;
    private float radio;
    private TextureRegion ficha;
    private List<Integer> valores = new ArrayList<Integer>();
    private float lado;
    private float x, y;
    private ComportamientoFicha comportamiento;

    public Ficha (float x, float y, int valor, float lado, float radio, float angulo) {
        ficha = new TextureRegion(LapsGame.textureAtlas.findRegion(String.valueOf(valor)));
        this.radio = radio;
        this.x = x;
        this.y = y;
       // fichaCircular(radio, angulo, x, y);
        this.lado = lado;
       // this.setBounds(x, y, lado, lado);
    }

    public void addValor (int i, int valor) {
        valores.add(i, valor);
    }

    public int getValorFicha () {
        return this.valor;
    }

    @Override
   public void draw(Batch batch, float parentAlpha) {
        if (angulo >= (2.0f * Math.PI)) {
            angulo = 0.0f;
            float x = (float) (this.x + (Math.cos(this.angulo) * this.radio));
            float y = (float) (this.y + (Math.sin(this.angulo) * this.radio));
            batch.draw(ficha, x, y, this.getWidth(), this.getHeight());
            this.setBounds(x, y, lado, lado);
        }
        else {
            angulo -= 0.0174533f;
            float x = (float) (this.x + (Math.cos(this.angulo) * this.radio));
            float y = (float) (this.y + (Math.sin(this.angulo) * this.radio));
            batch.draw(ficha, x, y, this.getWidth(), this.getHeight());
            this.setBounds(x, y, lado, lado);
        }
        //batch.draw(ficha, this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

   /* public void fichaCircular (float radio, float angulo, float xo, float yo) {
        while (Gdx.graphics.getDeltaTime() != 0) {
                angulo += 0.017533f;
                float x = (float) (xo + radio * Math.cos(angulo));
                float y = (float) (yo + radio * Math.sin(angulo));
                this.setBounds(x, y, 200, 200);
        }
        }*/

    public Ficha movimiento (float angulo) {
        RotateToAction acc = new RotateToAction();
        acc.setRotation(angulo);
        acc.setDuration(10f);
        this.addAction(acc);
        return this;
    }

	/*public Ficha tirarFicha (int tirar, Grafo grafo) {
		Ficha ficha = new Ficha(0);
		ficha.getValorFicha();
		if (tirar == 1) {
			int i = (int) (Math.random() * 19);
			return
		}
		return ficha.
	}*/
}
