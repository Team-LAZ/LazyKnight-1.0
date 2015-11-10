package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class AttackButton extends Actor {

    Skin skAttack;
    ImageButtonStyle ibsAttack;
    ImageButton ibtnAttack;
    Sprite sprAttack;
    Drawable drwAttack;

    public AttackButton(int x, int y) {
        sprAttack = new Sprite(new Texture("ibtnAttack.png"));

        skAttack = new Skin();
        skAttack.add("ibtnAttack", sprAttack);
        drwAttack = skAttack.getDrawable("ibtnAttack");

        ibsAttack = new ImageButtonStyle();
        ibsAttack.imageUp = drwAttack;

        ibtnAttack = new ImageButton(ibsAttack);
        ibtnAttack.setPosition(x, y);
        ibtnAttack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Attack");
            }
        });
    }
}
