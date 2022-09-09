package com.eisaaatifguiide.myownide.UI.Labels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

public abstract class Label implements UIElement {
    protected float x, y;
    protected Text text = new Text("");
    protected BitmapFont font = new BitmapFont();

    protected Color colour = Color.WHITE;

    protected float borderThickness = 0;
    protected Color borderColour = Color.BLACK;

    public Label() {

    }

    public Label(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public Label(float x, float y, Color colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public Label(float x, float y, Color colour, Text text) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.text = text;
    }

    protected abstract void alignText();

    @Override
    public abstract void dispose();

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text, BitmapFont font, boolean align) {
        this.text = text;
        this.font = font;
        if(align) alignText();
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public float getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(float borderThickness) {
        this.borderThickness = borderThickness;
    }

    public Color getBorderColour() {
        return borderColour;
    }

    public void setBorderColour(Color borderColour) {
        this.borderColour = borderColour;
    }
}
