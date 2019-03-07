package com.test.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.states.GameStateManager;
import com.test.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Flappy Bird";
    private GameStateManager gsm;

    private SpriteBatch batch;//you can have only one and passed around all of your different states (too heavy)
	//Texture img; //not used anymore, I think
    private Music music;


	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        gsm.push(new MenuState(gsm));
//		img = new Texture("badlogic.jpg");//needed to draw the image
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
//      batch.begin();    //used to draw the image
//		batch.draw(img, 0, 0);
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		music.dispose();
	}
}
