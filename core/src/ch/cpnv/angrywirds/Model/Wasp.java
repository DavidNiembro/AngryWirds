package ch.cpnv.angrywirds.Model;

import com.badlogic.gdx.math.Vector2;

import ch.cpnv.angrywirds.AngryWirds;

public class Wasp extends MovingObject {

    private static final int AGITATION = 15; // How sharply speed changes
    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Wasp(Vector2 position, Vector2 speed) {
        super(position, WIDTH, HEIGHT, PICNAME, speed);
    }

    @Override
    public void accelerate(float dt) {
        // The wasp only slightly alters its speed at random. It is subject to gravity, but it counters it with its flight
        speed.x += (AngryWirds.alea.nextFloat()-getX()/AngryWirds.WORLD_WIDTH)*AGITATION; // the closer it is to a border, the higher the chances that acceleration goes the other way
        speed.y += (AngryWirds.alea.nextFloat()-getY()/AngryWirds.WORLD_HEIGHT)*AGITATION;
    }
}
