package ch.cpnv.angrywirds.Model;
import com.badlogic.gdx.math.Vector2;

public class Tnt extends PhysicalObject {

    private static final String PICNAME = "tnt.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private int negativePoints; // Number of pooints removed from score if hit

    public Tnt(Vector2 position, int negativePoints) {
        super(position, WIDTH, HEIGHT, PICNAME);
        this.negativePoints = negativePoints;
    }
}