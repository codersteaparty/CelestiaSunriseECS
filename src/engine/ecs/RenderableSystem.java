package engine.ecs;

import org.newdawn.slick.Graphics;

/**
 * Renderable systems are updated like any other systems, but after being updated, they are rendered as well
 * @author Maggistrator
 */
public interface RenderableSystem extends System {
    
    public void render(Graphics g);
    
}
