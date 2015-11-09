package com.laz.lazyknight;

import com.badlogic.gdx.Game;

public class LazyKnight extends Game {

    Controls controls;
    Character character;

    @Override
    public void create() {
        character = new Character();
        character.create();

        controls = new Controls();
        controls.create();
    }

    @Override
    public void render() {
        character.render();
        controls.render();
    }
}
