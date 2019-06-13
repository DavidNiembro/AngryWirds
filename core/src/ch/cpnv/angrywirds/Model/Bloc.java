package ch.cpnv.angrywirds.Model;

import com.badlogic.gdx.math.Vector2;

public class Bloc extends PhysicalObject {
    private static final String PICNAME = "block.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Bloc(Vector2 position) {
        super(position, WIDTH, HEIGHT, PICNAME);
    }
}

