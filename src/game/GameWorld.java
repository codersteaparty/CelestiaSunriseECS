package game;

import engine.ecs.EntityManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameWorld extends BasicGameState {

    private int stateID;
    protected EntityManager entityManager = new EntityManager();

    public GameWorld(int ID) {
        stateID = ID;
    }

    @Override
    public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
        
    }

    @Override
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
        entityManager.render(arg2);
    }

    @Override
    public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
        entityManager.update(arg2);
    }

    @Override
    public int getID() {
        return stateID;
    }

}
