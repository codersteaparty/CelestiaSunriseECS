package game.components;

import engine.ecs.Aspect;
import engine.ecs.Component;
import org.newdawn.slick.Image;

/**
 *
 * @author Maggistrator
 */
public class SpriteRendererComponent implements Component {

    public Image image;

    @Override
    public Aspect getAspect() {
        return Aspect.SPRITE;
    }
    
}
