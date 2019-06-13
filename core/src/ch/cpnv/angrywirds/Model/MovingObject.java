package ch.cpnv.angrywirds.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class MovingObject extends PhysicalObject {

    public final static float G = 100;
    protected Vector2 speed;
    protected boolean frozen;


    public MovingObject(Vector2 position, float width, float height, String picname, Vector2 speed) {
        super(position, width, height, picname);
        this.speed = speed;
    }


    public abstract void accelerate(float dt);

    public final void move(float dt){
        if (!frozen) this.translate(speed.x * dt, speed.y * dt);
    }

    public void update(float dt)
    {
        if (!frozen)
        {
            accelerate(dt);
            move(dt);
        }
    }

    public void freeze() {
        this.frozen = true;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void unFreeze() {
        this.frozen = false;
    }

    public final void stop()
    {
        speed.x = 0; // Calm down
        speed.y = 0;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    @Override
    public final String toString()
    {
        return getClass().getSimpleName()+" at ("+this.getX()+","+this.getY()+"), moving at ("+speed.x+","+speed.y+")";
    }
}
