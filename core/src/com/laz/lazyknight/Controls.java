package com.laz.lazyknight;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Controls implements ApplicationListener {

    SpriteBatch batch;
    Stage stage;

    Skin touchpadSkin;
    TouchpadStyle touchpadStyle;
    Drawable touchpadBackground;
    Drawable touchpadKnob;
    Touchpad touchpad;

    @Override
    public void create() {
        batch = new SpriteBatch();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        touchpadSkin = new Skin();
        touchpadSkin.add("touchpadBackground", new Texture("touchpadBackground.png"));
        touchpadSkin.add("touchpadKnob", new Texture("touchpadKnob.png"));

        touchpadStyle = new TouchpadStyle();

        touchpadBackground = touchpadSkin.getDrawable("touchpadBackground");
        touchpadKnob = touchpadSkin.getDrawable("touchpadKnob");

        touchpadStyle.background = touchpadBackground;
        touchpadStyle.knob = touchpadKnob;

        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(15, 15, 100, 100);

        stage.addActor(touchpad);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.end();

        stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
