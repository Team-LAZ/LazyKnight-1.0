package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

//https://github.com/captainkesty/CCSBombDrop/blob/master/core/src/com/mygdx/game/TouchPad.java

public class TouchPad extends Actor {

    Touchpad touchpad;
    TouchpadStyle touchpadStyle;
    Skin skin;
    Drawable drwTouchpadBG, drwTouchpadFG;
    Texture texTouchpadBG, texTouchpadFG;

    public TouchPad(int x, int y) {
        texTouchpadBG = new Texture("touchpadBG.png");
        texTouchpadFG = new Texture("touchpadFG.png");

        skin = new Skin();
        skin.add("drwTouchpadBG", texTouchpadBG);
        skin.add("drwTouchpadFG", texTouchpadFG);

        drwTouchpadBG = skin.getDrawable("drwTouchpadBG");
        drwTouchpadFG = skin.getDrawable("drwTouchpadFG");

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = drwTouchpadBG;
        touchpadStyle.knob = drwTouchpadFG;

        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(x, y, 100, 100);
    }
}