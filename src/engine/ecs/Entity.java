package engine.ecs;

/**
 * Entity is an unique set of components, represented by it's id.
 * Entity doesn't have it's own data or behavior - Components and Systems handles it.
 * Entity doesn't contain any components or systems - just indicates them.
 * @author Maggistrator
 */
public class Entity {

    public int id;

    public Entity(int id) {
        this.id = id;
    }
 
}
