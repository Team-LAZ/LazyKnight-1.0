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
    DPad dpad;
    Character character;
    AttackButton attackButton;
    JumpButton jumpButton;
    MagicButton magicButton;

    SpriteBatch batch;
    OrthographicCamera camera;
    ScalingViewport sv;

    float fVelX;

    public GameScreen(Game game) {
        this.game = game;
        dpad = new DPad();
        character = new Character(150, 150);
        attackButton = new AttackButton(615, 25);
        jumpButton = new JumpButton(700, 75);
        magicButton = new MagicButton(605, 115);

        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 10F, 10F);

        sv = new ScalingViewport(Scaling.none, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        fVelX = 5;

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

        dpad.ibtnDpad[0].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                up();
            }
        });

        dpad.ibtnDpad[2].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                down();
            }
        });

        //add actors to the stage
        this.addActor(character.imgKnight);
        this.addActor(attackButton.ibtnAttack);
        this.addActor(jumpButton.ibtnJump);
        this.addActor(magicButton.ibtnMagic);

        //add dpad to the stage
        this.addActor(dpad.imgOutline);
        for (int i = 0; i < 4; i++) {
            this.addActor(dpad.ibtnDpad[i]);
        }
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

        batch.begin();
        batch.end();

        this.act(Gdx.graphics.getDeltaTime());
        this.draw();

        if (dpad.ibtnDpad[1].isPressed()) {
            right();
        }

        if (dpad.ibtnDpad[3].isPressed()) {
            left();
        }
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

    public void up() {
        System.out.println("UP");
    }

    public void right() {
        character.imgKnight.setX(character.imgKnight.getX() + fVelX);
    }

    public void down() {
        System.out.println("DOWN");
    }

    public void left() {
        character.imgKnight.setX(character.imgKnight.getX() - fVelX);
    }
}
