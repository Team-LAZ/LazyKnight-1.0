package com.laz.lazyknight;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character implements ApplicationListener {

    Controls controls;

    SpriteBatch batch;
    Texture texKnight;
    Sprite sprKnight;

    @Override
    public void create() {
        controls = new Controls();

        batch = new SpriteBatch();

        texKnight = new Texture(Gdx.files.internal("knight.png"));
        sprKnight = new Sprite(texKnight);
        sprKnight.setPosition(100, 100);
    }

    @Override
    public void render() {
        batch.begin();
        sprKnight.draw(batch);
        batch.end();

        sprKnight.setX(sprKnight.getX() + controls.touchpad.getKnobPercentX() * 5);
        sprKnight.setY(sprKnight.getY() + controls.touchpad.getKnobPercentY() * 5);
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
    public void dispose() {

    }
}
