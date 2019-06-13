package ch.cpnv.angrywirds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pause extends GameActivity implements InputProcessor {
	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;

	protected SpriteBatch batch;
	private Texture background;

	public Pause() {
		super();
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
	}

	@Override
	protected void handleInput() {

	}

	@Override
	public void update(float dt) {

	}

	@Override
	public void render () {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		batch.end();;
	}

	@Override
	public void takeInputProcessing() { Gdx.input.setInputProcessor(this); }

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Root.gameActivityManager.pop();
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
