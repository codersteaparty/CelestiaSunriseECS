package engine.ecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import org.newdawn.slick.Graphics;

/**
 * Main manager of all entities living in the world.
 * This class is responcible for edding, deleting, and editing components of any entity living within it.
 * Also stores and processing Systems, making modular game logic to execute.
 * 
 * @author Maggistrator
 */
public class EntityManager {
    
    private HashMap<Entity, LinkedList<Component>> components = new HashMap<>();      
    private ArrayList<System> systems = new ArrayList<>();                                  
    private ArrayList<Integer> usedIDs = new ArrayList<>();
     
    public Entity createNewEntity(){
        int id = nextAviableID();
        Entity e = new Entity(id);
        usedIDs.add(id);
        components.put(e, new LinkedList<>());
        return e;
    }
    
    public void addEntity(Entity e, Component... nc) {
        List<Component> componentsListByEntity = this.components.get(e);
        componentsListByEntity.addAll(Arrays.asList(nc));
    }
    
    public void addComponent(Entity e, Component c) {
        List<Component> componentsListByEntity = this.components.get(e);
        componentsListByEntity.add(c);
    }
    
    public <T extends Component> T getComponent( Entity e, Aspect a ){
        List<Component> comps = components.get(e);
        for(Component c: comps){
            if(c.getAspect().equals(a)) return (T)c; 
        }
        return null;
    }
    
    /**
     * TODO: Написать функцию получения сущности getEntity
     * TODO: Подумать о том, стоит ли придерживаться строгой парадигмы
     *       ECS, и отказываться от хранения списка компонентов в Entity
     * TODO: Использовать подход один-компонент-одна-система, 
     *       тогда можно создавать комозитные компоненты
     * TODO: подумать, как сократить вызовы компонентов, не используя 
     *       дженерики, или используя минимально. Больше опираться на Aspect.
     * TODO: Добавить getAspect в System
     * TODO: Переобозвать System в Process, во избежание коллизий с системным
     *       java-классом System
     */
    
//    public Entity getEntity(int id) {
//        for (LinkedList<Component> list : components.values()) {
//            for (Object e : map.keySet().toArray()) {
//                if (((Entity) e).id == id) {
//                    return (Entity) e;
//                }
//            }
//        }
//        return null;
//    }
    
    public List<Entity> getAllEntitiesPossessing( Aspect... aspectList ){
        List<Entity> searchResults = new LinkedList();
        components.forEach((e, list)->{
            list.forEach((c)->{
                boolean hasAll = true;
                for(Aspect a: aspectList){
                    if(!c.getAspect().equals(a)) hasAll = false;
                    
                java.lang.System.out.println("Entity #"+e.id+(hasAll ? "has" : "has not")+"component with aspect "+a);
                }
                if(hasAll) searchResults.add(e);
            });
        });
        return searchResults;
    }
    
    public void removeEntity(Entity e) {
        components.remove(e);
    }
 
    public void removeComponent(Entity e, Aspect a) {
        List<Component> comps = components.get(e);
        for (int i = 0; i < comps.size(); i++) {
            if (comps.get(i).getAspect().equals(a)) {
                comps.remove(i);
                return;
            }
        }
    }
    
    public void addSystem(System s)  {
        s.init(this);
        systems.add(s);
    }
    
    public void removeSystem(Class systemClass){
        systems.forEach((s)->{
            if(s.getClass().equals(systemClass)) systems.remove(s);
        });
    }
    
    public void render(Graphics g){
        systems.forEach((s)->{
            if(s instanceof RenderableSystem) {
                ((RenderableSystem)s).render(g);
            }
        });
    }
    
    public void update(int delta){
        systems.forEach((s)->{
            s.update(delta);
        });
    }
    
    
    //i dunno why  this exists
    private int nextAviableID(){
        Random rand = new Random();
        int id = rand.nextInt();
        while(usedIDs.contains(id)) id = rand.nextInt();
        return id;
    }
}
