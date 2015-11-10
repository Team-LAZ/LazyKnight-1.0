package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//http://stackoverflow.com/questions/13780742/libgdx-difference-between-sprite-and-actor
//http://stackoverflow.com/questions/21495258/how-can-i-change-the-texture-in-a-scene2d-image-using-libgdx

public class Character extends Actor {

    Texture texKnight;
    Image imgKnight;

    public Character(int x, int y) {
        texKnight = new Texture("knight.png");

        imgKnight = new Image(texKnight);
        imgKnight.setPosition(x, y);
    }
}
