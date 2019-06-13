package ch.cpnv.angrywirds.Model;
import com.badlogic.gdx.math.Vector2;

public class Bird extends MovingObject {

    private static final String PICNAME = "bird.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Bird(Vector2 position, Vector2 speed) {
        super(position, WIDTH, HEIGHT, PICNAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        speed.y -= MovingObject.G * dt;
    }
}
