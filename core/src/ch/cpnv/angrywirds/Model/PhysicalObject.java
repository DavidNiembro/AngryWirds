package ch.cpnv.angrywirds.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PhysicalObject extends Sprite {

    public PhysicalObject(Vector2 position, float width, float height, String picname) {
        super(new Texture(picname));
        setBounds(position.x, position.y, width, height);
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName()+" at ("+this.getX()+","+this.getY()+")";
    }

    public void draw(Batch batch)
    {
        super.draw(batch);
    }

    public Vector2 getDimension()
    {
        return new Vector2(getWidth(), getHeight());
    }

    public Vector2 getPosition()
    {
        return new Vector2(getX(), getY());
    }

    public Rectangle getRectangle()
    {
        return new Rectangle((int)this.getPosition().x,(int)this.getPosition().y,(int)this.getDimension().x,(int)this.getDimension().y);
    }

    public boolean collidesWith(PhysicalObject o)
    {
        return this.getRectangle().overlaps(o.getRectangle());
    }

}
