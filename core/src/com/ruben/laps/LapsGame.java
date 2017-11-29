package com.ruben.laps;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;

public class LapsGame extends ApplicationAdapter {
	public static TextureAtlas textureAtlas;
	Escenario stage;

	@Override
	public void create () {
		textureAtlas = new TextureAtlas(Gdx.files.internal("texturas.atlas"));
		OrthographicCamera camera = new OrthographicCamera();
		Viewport viewport = new FitViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGTH, camera);
		stage = new Escenario(viewport, Constants.REGION1, Constants.REGION2);
		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void render () {
		cls();
		stage.act();
		stage.draw();
	}
	
	@Override
	public void dispose () {
		textureAtlas.dispose();
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width,height,true);
	}


	public static void cls() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}

