package com.eisaaatifguiide.myownide.UI.Extras;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Extras {
    public static float getTextWidth(BitmapFont font, String text) {
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.width;
    }

    public static float getTextHeight(BitmapFont font, String text) {
        GlyphLayout layout = new GlyphLayout(font, text);
        return layout.height;
    }

    public static Vector2 getMousePos(Viewport viewport) {
        Vector3 mouseOnScreen = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        Vector3 mouseOnWorld3D = viewport.unproject(mouseOnScreen);
        return new Vector2(mouseOnWorld3D.x, mouseOnWorld3D.y);
    }
}
