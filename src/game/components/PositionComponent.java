package game.components;

import engine.ecs.Aspect;
import engine.ecs.Component;

/**
 *
 * @author Maggistrator
 */
public class PositionComponent implements Component {

    public float x;
    public float y;
    public float rotation;

    public PositionComponent(float x, float y, float rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }
    
    @Override
    public Aspect getAspect() {
        return Aspect.POSITION;
    }
    
}
