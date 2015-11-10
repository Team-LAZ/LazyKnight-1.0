package com.laz.lazyknight;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MagicButton {

    Skin skMagic;
    ImageButtonStyle ibsMagic;
    ImageButton ibtnMagic;
    Texture texMagic;
    Drawable drwMagic;

    public MagicButton(int x, int y) {
        texMagic = new Texture("magic_button.png");

        skMagic = new Skin();
        skMagic.add("ibtnMagic", texMagic);

        drwMagic = skMagic.getDrawable("ibtnMagic");

        ibsMagic = new ImageButtonStyle();
        ibsMagic.imageUp = drwMagic;

        ibtnMagic = new ImageButton(ibsMagic);
        ibtnMagic.setPosition(x, y);
    }
}
