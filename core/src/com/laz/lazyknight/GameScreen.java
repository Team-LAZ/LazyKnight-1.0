package com.laz.lazyknight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

//https://github.com/captainkesty/CCSBombDrop/blob/master/core/src/com/mygdx/game/GameScreen.java

public class GameScreen extends Stage implements Screen {

    Game game;
    DPad dpad;
    Character character;
    AttackButton attackButton;
    JumpButton jumpButton;
    MagicButton magicButton;

    OrthographicCamera camera;

    float fVelX;

    public GameScreen(Game game) {
        this.game = game;
        dpad = new DPad();
        character = new Character();
        attackButton = new AttackButton(Gdx.graphics.getWidth() - 185, 25);
        jumpButton = new JumpButton(Gdx.graphics.getWidth() - 100, 75);
        magicButton = new MagicButton(Gdx.graphics.getWidth() - 185, 115);

        camera = new OrthographicCamera();

        fVelX = 5;

        //click listeners for buttons that don't need to be held down
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

        this.addActor(attackButton.ibtnAttack);
        this.addActor(jumpButton.ibtnJump);
        this.addActor(magicButton.ibtnMagic);

        //add the four parts of the dpad to the stage, and the dpad outline
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

        character.render(this);

        //checks if left or right is pressed
        //use isPressed as it constantly checks instead of only once (for moving)
        if (dpad.ibtnDpad[1].isPressed()) {
            right();
        } else {
            character.bRight = false;
        }

        if (dpad.ibtnDpad[3].isPressed()) {
            left();
        } else {
            character.bLeft = false;
        }

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

    //methods for when buttons are pressed
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
        character.bRight = true;
    }

    public void down() {
        System.out.println("DOWN");
    }

    public void left() {
        character.bLeft = true;
    }
}
