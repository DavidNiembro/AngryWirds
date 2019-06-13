package ch.cpnv.angrywirds;

import com.badlogic.gdx.Gdx;

import java.util.Stack;

/**
 * Created by Xavier on 10.06.18.
 */

public class GameActivityManager {
    private Stack<GameActivity> gameActivities;

    public GameActivityManager() {
        gameActivities = new Stack<GameActivity>();
    }

    public void push(GameActivity gameActivity) {
        Gdx.app.log("ANGRY","Push");
        gameActivities.push(gameActivity);
        gameActivities.peek().takeInputProcessing(); // Steal control from previous foreground activity
        dumpstack();
    }

    public void pop() {
        Gdx.app.log("ANGRY","Pop");
        gameActivities.pop();
        gameActivities.peek().takeInputProcessing(); // Steal control from previous foreground activity
        dumpstack();
    }

    public void reset(GameActivity gameActivity) {
        Gdx.app.log("ANGRY","Reset stack");
        gameActivities = new Stack<GameActivity>();
        gameActivities.push(gameActivity);
        gameActivities.peek().takeInputProcessing(); // Steal control from previous foreground activity
        dumpstack();
    }

    private void dumpstack() {
        for (int i=0; i < gameActivities.size(); i++)
            Gdx.app.log("ANGRY",i + ": "+gameActivities.get(i).getClass().getSimpleName());
    }
    // The following methods concern only the topmost Activity of the stack

    public void handleInput() {
        gameActivities.peek().handleInput();
    }

    public void update(float dt) {
        gameActivities.peek().update(dt);
    }

    public void render() {
        gameActivities.peek().render();
    }
}
