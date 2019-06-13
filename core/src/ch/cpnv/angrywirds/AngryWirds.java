package ch.cpnv.angrywirds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import ch.cpnv.angrywirds.Model.Bird;
import ch.cpnv.angrywirds.Model.PhysicalObject;
import ch.cpnv.angrywirds.Model.Pig;
import ch.cpnv.angrywirds.Model.Scenery;
import ch.cpnv.angrywirds.Model.Wasp;
import ch.cpnv.angrywirds.Model.Bloc;
import ch.cpnv.angrywirds.Model.Tnt;
import java.util.Random;


public class AngryWirds extends Game implements InputProcessor {
	public static Random alea;

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static final int FLOOR_HEIGHT = 120;
	private static final int SLINGSHOT_WIDTH = 75;
	private static final int SLINGSHOT_HEIGHT = 225;
	private static final int SLINGSHOT_OFFSET = 100; // from left edge
	private static final int BOARD_WIDTH = 300;
	private static final int BOARD_HEIGHT = 200;
	private static final int BOARD_OFFSET = 50; // from left edge
	private static final float INITIAL_PUSH = 1.5f; // Multiplication factor on bird launch

	SpriteBatch batch;
	Texture img;
	Texture background;
	Bird bird;
	Wasp wasp;
	Scenery scenery;
	private Texture slingshot;
	private Texture board;
	private OrthographicCamera camera;

	@Override
	public void create () {
		alea = new Random();
		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("background.jpg"));
		slingshot = new Texture(Gdx.files.internal("slingshot.png"));
		board = new Texture(Gdx.files.internal("panel.png"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		camera.update();

		bird = new Bird(new Vector2(0, FLOOR_HEIGHT), new Vector2(0, 0));
		bird.freeze();
		wasp = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));
		scenery = new Scenery();


		for (int i=0 ; i<3; i++) {
			try {
				scenery.addElement(new Tnt(new Vector2(alea.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3, FLOOR_HEIGHT + 60), 50));
			}catch (Exception e){

			}
		}
		for (int i=0 ; i<3; i++) {
			try {
				scenery.addElement(new Pig(new Vector2(alea.nextInt(WORLD_WIDTH * 2 / 3) + WORLD_WIDTH / 3 ,FLOOR_HEIGHT + 60), "I am Pig#" + 1));
			}catch (Exception e){

			}
		}
		for (int i=0 ; i<23; i++) {
            try {
                scenery.addElement(new Bloc(new Vector2((WORLD_WIDTH-23*60)+i * 60, FLOOR_HEIGHT)));

            }catch (Exception e){

            }
        }
		Gdx.input.setInputProcessor(this);
	}

	public void update() {
		float dt = Gdx.graphics.getDeltaTime();
		bird.update(dt);
		wasp.update(dt);
		PhysicalObject hit = scenery.collidesWith(bird);
		if (hit != null || bird.collidesWith(wasp) || bird.getX() > WORLD_WIDTH || bird.getY() < FLOOR_HEIGHT) {
			bird.setPosition(0, FLOOR_HEIGHT);
			bird.freeze();
			if (hit != null) Gdx.app.log("ANGRY","Collided with "+hit.getClass().getSimpleName());
		}

	}

	@Override
	public void render () {
		update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);
		batch.draw(slingshot, SLINGSHOT_OFFSET, FLOOR_HEIGHT, SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT);
		batch.draw(board, BOARD_OFFSET, WORLD_HEIGHT - BOARD_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT);
		bird.draw(batch);
		wasp.draw(batch);
		scenery.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0));
		PhysicalObject Touched = scenery.touched(pointTouched.x, pointTouched.y);
		if(Touched != null ){

		}else{
			if (bird.isFrozen()) {
				if (bird.getX() == 0)
				{
					bird.setSpeed(new Vector2((pointTouched.x - bird.getPosition().x) * INITIAL_PUSH, (pointTouched.y - bird.getPosition().y) * INITIAL_PUSH));
					bird.unFreeze();
				} else
				{
					bird.setPosition(0, FLOOR_HEIGHT);
					wasp.unFreeze();
				}
			}
		}
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