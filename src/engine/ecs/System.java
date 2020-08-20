package engine.ecs;

/**
 * System. An superior processor of Components data.
 * @author Maggistrator
 */
public interface System {
    
    public void init(EntityManager engine);
    public void update(int delta);
    
}
