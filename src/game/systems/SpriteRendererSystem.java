package game.systems;

import engine.ecs.Aspect;
import engine.ecs.Entity;
import engine.ecs.EntityManager;
import engine.ecs.RenderableSystem;
import game.components.PositionComponent;
import game.components.SpriteRendererComponent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Maggistrator
 */
public class SpriteRendererSystem implements RenderableSystem {

    Map<SpriteRendererComponent, PositionComponent> sprites = new HashMap<>();

    @Override
    public void init(EntityManager engine) {
        List <Entity> list = engine.getAllEntitiesPossessing(Aspect.SPRITE, Aspect.POSITION);
        for(Entity e: list) {
            SpriteRendererComponent src = engine.getComponent(e, Aspect.SPRITE);
            PositionComponent pc = engine.getComponent(e, Aspect.POSITION);
            sprites.put(src, pc);
        }
    }
    
    @Override
    public void render(Graphics g) {
        sprites.forEach((sr, pos)->{
            g.drawImage(sr.image, pos.x, pos.y);
        });
    }

    @Override
    public void update(int delta) {
        /* nothing here */
    }

}
