package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class JumpButton {

    Skin skJump;
    ImageButtonStyle ibsJump;
    ImageButton ibtnJump;
    Texture texJump;
    Drawable drwJump;

    public JumpButton(int x, int y) {
        texJump = new Texture("jump_button.png");

        skJump = new Skin();
        skJump.add("ibtnJump", texJump);

        drwJump = skJump.getDrawable("ibtnJump");

        ibsJump = new ImageButtonStyle();
        ibsJump.imageUp = drwJump;

        ibtnJump = new ImageButton(ibsJump);
        ibtnJump.setPosition(x, y);
    }
}
