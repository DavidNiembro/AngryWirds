package ch.cpnv.angrywirds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * Created by Xavier on 10.06.18.
 */

public class Root extends Game {

    static public GameActivityManager gameActivityManager;

    @Override
    public void create() {
        gameActivityManager = new GameActivityManager();
        gameActivityManager.push(new Home());
    }

    @Override
    public void render() {
        gameActivityManager.handleInput();
        gameActivityManager.update(Gdx.graphics.getDeltaTime());
        gameActivityManager.render();
    }

    @Override
    public void dispose() {
    }
}
