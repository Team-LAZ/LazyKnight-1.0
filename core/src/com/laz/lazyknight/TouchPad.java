package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    Drawable touchBG, touchFG;
    Sprite sprBG, sprFG;

    public TouchPad(int x, int y) {
        sprBG = new Sprite(new Texture("touchpadBG.png"));
        sprFG = new Sprite(new Texture("touchpadFG.png"));

        skin = new Skin();
        skin.add("touchBG", sprBG);
        skin.add("touchFG", sprFG);
        touchBG = skin.getDrawable("touchBG");
        touchFG = skin.getDrawable("touchFG");

        touchpadStyle = new TouchpadStyle();
        touchpadStyle.background = touchBG;
        touchpadStyle.knob = touchFG;

        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(x, y, 100, 100);
    }
}