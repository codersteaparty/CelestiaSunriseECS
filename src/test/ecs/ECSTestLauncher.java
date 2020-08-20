package test.ecs;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Maggistrator
 */
public class ECSTestLauncher {
    
    public static void main(String[] args) throws SlickException {
        StateBasedGame game = new StateBasedGame("ECS-Test") {
            @Override
            public void initStatesList(GameContainer container) throws SlickException {
                addState(new ECSWorld(0));
                enterState(0);
            }
        };
        AppGameContainer container = new AppGameContainer(game);
        container.setDisplayMode(640, 480, false);
        container.start();
    }
 
}
