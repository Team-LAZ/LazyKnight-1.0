package com.laz.lazyknight;

import com.badlogic.gdx.Game;

public class LazyKnight extends Game {

    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }
}
