package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

//https://github.com/captainkesty/CCSBombDrop/blob/master/core/src/com/mygdx/game/BombButton.java

public class AttackButton extends Actor {

    Skin skAttack;
    ImageButtonStyle ibsAttack;
    ImageButton ibtnAttack;
    Texture texAttack;
    Drawable drwAttack;

    public AttackButton(int x, int y) {
        texAttack = new Texture("attack_button.png");

        skAttack = new Skin();
        skAttack.add("ibtnAttack", texAttack);

        drwAttack = skAttack.getDrawable("ibtnAttack");

        ibsAttack = new ImageButtonStyle();
        ibsAttack.imageUp = drwAttack;

        ibtnAttack = new ImageButton(ibsAttack);
        ibtnAttack.setPosition(x, y);
    }
}
