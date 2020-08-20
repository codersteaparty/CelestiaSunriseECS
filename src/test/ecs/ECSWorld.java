/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.ecs;

import engine.ecs.Aspect;
import engine.ecs.Entity;
import game.GameWorld;
import game.components.PositionComponent;
import game.components.SpriteRendererComponent;
import game.systems.SpriteRendererSystem;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Maggistrator
 */
public class ECSWorld extends GameWorld {
     Entity spriteEntity ;
    public ECSWorld(int ID) {
        super(ID);
    }

    @Override
    public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
        super.init(arg0, arg1); 
        spriteEntity = entityManager.createNewEntity();
        PositionComponent position = new PositionComponent(50, 50, 0);
        SpriteRendererComponent spriteRenderer = new SpriteRendererComponent();
        spriteRenderer.image = new Image("data/images/test/ecs/eyes.png");
        entityManager.addEntity(spriteEntity, position, spriteRenderer);
        entityManager.addSystem(new SpriteRendererSystem());
    }

    @Override
    public void render(GameContainer c, StateBasedGame game, Graphics g) throws SlickException {
        super.render(c, game, g); 
        g.drawString("Img: " + ((SpriteRendererComponent)entityManager.getComponent(spriteEntity, Aspect.SPRITE)).image.toString(), 0, 0);
        g.drawString("Pos: " + ((PositionComponent)entityManager.getComponent(spriteEntity, Aspect.POSITION)).x + "|"+ ((PositionComponent)entityManager.getComponent(spriteEntity, Aspect.POSITION)).y, 50, 50);
    }

    @Override
    public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
        super.update(arg0, arg1, arg2); 
        
    }
    
}
