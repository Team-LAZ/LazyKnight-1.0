package com.laz.lazyknight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

//https://github.com/captainkesty/CCSBombDrop/blob/master/core/src/com/mygdx/game/GameScreen.java

public class GameScreen extends Stage implements Screen {

    Game game;
    TouchPad touchpad;
    Character character;
    AttackButton attackButton;
    JumpButton jumpButton;
    MagicButton magicButton;

    SpriteBatch batch;
    OrthographicCamera camera;
    ScalingViewport sv;

    float fVelX, fVelY;

    public GameScreen(Game game) {
        this.game = game;
        touchpad = new TouchPad(30, 30);
        character = new Character(150, 150);
        attackButton = new AttackButton(615, 25);
        jumpButton = new JumpButton(700, 75);
        magicButton = new MagicButton(605, 115);

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10F, 10F);

        sv = new ScalingViewport(Scaling.none, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        fVelX = 5;
        fVelY = 5;

        attackButton.ibtnAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                attack();
            }
        });

        jumpButton.ibtnJump.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                jump();
            }
        });

        magicButton.ibtnMagic.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                magic();
            }
        });

        this.addActor(touchpad.touchpad);
        this.addActor(character.imgKnight);
        this.addActor(attackButton.ibtnAttack);
        this.addActor(jumpButton.ibtnJump);
        this.addActor(magicButton.ibtnMagic);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.294f, 0.294f, 0.294f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        character.imgKnight.setX(character.imgKnight.getX() + touchpad.touchpad.getKnobPercentX() * fVelX);

        batch.begin();
        batch.end();

        this.act(Gdx.graphics.getDeltaTime());
        this.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void attack() {
        System.out.println("ATTACK");
    }

    public void jump() {
        System.out.println("JUMP");
    }

    public void magic() {
        System.out.println("MAGIC");
    }
}
