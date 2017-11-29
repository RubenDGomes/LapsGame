package com.ruben.laps;


        import com.badlogic.gdx.graphics.g2d.Batch;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
        import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * Created by ruben on 11/6/2017.
 */

public class CirculoCasilla {
    private float radio;
    private float centroX;
    private float centroY;

    public CirculoCasilla(float radio) {
        this.radio = radio;
    }

    public float getRadio () {
        return this.radio;
    }

    public float calcularLongitud (float radio) {
        float longitud = 2f * 3.14f * radio;
        return longitud;
    }

    public float getPosX (float centroX, float radio, float angulo) {
        float x = (float) (centroX + radio * Math.cos(angulo));
        return x;
    }

    public float getPosY (float centroY, float radio, float angulo) {
        float y = (float) (centroY + radio * Math.sin(angulo));
        return y;
    }

}
