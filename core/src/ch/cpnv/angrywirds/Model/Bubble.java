package ch.cpnv.angrywirds.Model;

import com.badlogic.gdx.math.Vector2;

public class Bubble extends PhysicalObject {

    private static final String PICNAME = "bubble.png";
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private String textToShow; // Number of pooints removed from score if hit
    private int timeToLive;

    public Bubble(Vector2 position, String textToShow, int timeToLive){
        super(position, WIDTH, HEIGHT, PICNAME);
        this.textToShow = textToShow;
    }
}
