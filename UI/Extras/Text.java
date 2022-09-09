package com.eisaaatifguiide.myownide.UI.Extras;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Text {
    private String text;
    private Color colour = Color.RED;
    private Vector2 textPos = new Vector2();
    private Vector2 textSize = new Vector2();

    public Text(String text) {
        this.text = text;
    }

    public Text(String text, Vector2 pos) {
        this.text = text;
        this.textPos = pos;
    }

    public Text(String text, Vector2 pos, Color colour) {
        this.text = text;
        this.textPos = pos;
        this.colour = colour;
    }

    public void render(BitmapFont font, SpriteBatch batch) {
        batch.begin();
        font.setColor(colour);
        font.draw(batch, text, textPos.x, textPos.y);
        batch.end();
    }

    public void selectText(Color highlightColour) {
        // TODO (PRIORITY LEVEL 10/10) finish selecting text
    }

    public void selectText() {
        selectText(new Color(0, 0.57f, 0.92f, 1));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Vector2 getTextPos() {
        return textPos;
    }

    public void setTextPos(Vector2 textPos) {
        this.textPos = textPos;
    }

    public Vector2 getTextSize() {
        return textSize;
    }

    public void setTextSize(Vector2 textSize) {
        this.textSize = textSize;
    }
}
