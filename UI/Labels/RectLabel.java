package com.eisaaatifguiide.myownide.UI.Labels;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import java.util.ArrayList;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextHeight;
import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextWidth;

public class RectLabel extends Label implements UIElement {
    protected Vector2 dimensions = new Vector2();

    public RectLabel() {
        super();
    }

    public RectLabel(Vector2 dimensions) {
        this.dimensions = dimensions;
    }

    public RectLabel(float x, float y) {
        super(x, y);
    }


    public RectLabel(float x, float y, Vector2 dimensions) {
        super(x, y);
        this.dimensions = dimensions;
    }

    public RectLabel(float x, float y, Vector2 dimensions, Color colour) {
        super(x, y, colour);
        this.dimensions = dimensions;
    }

    public RectLabel(float x, float y, Vector2 dimensions, Color colour, Text text) {
        super(x, y, colour, text);
        this.dimensions = dimensions;
    }

    public void render(ShapeRenderer sr, SpriteBatch batch) {
        update();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(borderColour);
        sr.rect(this.x - this.borderThickness / 2, this.y - this.borderThickness / 2, this.dimensions.x + borderThickness, this.dimensions.y + this.borderThickness);
        sr.setColor(colour);
        sr.rect(this.x, this.y, this.dimensions.x, this.dimensions.y);
        sr.end();

        this.text.setTextPos(new Vector2(this.x + this.dimensions.x / 2 - text.getTextSize().x / 2, this.y + this.dimensions.y / 2 + this.text.getTextSize().y / 2));
        this.text.render(this.font, batch);
    }

    protected void update() {
        text.setTextSize(new Vector2(getTextWidth(this.font, this.text.getText()), getTextHeight(this.font, this.text.getText())));
    }

    protected void alignText() {
        alignText(this, this.dimensions.x);
    }

    public static void alignText(Label label, float width) {
        char[] tmp = label.text.getText().toCharArray();
        ArrayList<Character> text = new ArrayList<>();

        for(int i = 0; i < tmp.length; i++) {
            text.add(tmp[i]);
        }

        int i = 0;
        int lines =  (int) (getTextWidth(label.font, label.text.getText()) / width) + 1;

        String newText = "";

        for(int l = 0; l < lines; l++) {
            String temp = " ";
            while(getTextWidth(label.font, temp) < width && i < text.size()) {
                temp += text.get(i);
                i++;
            }

            if(temp.charAt(0) == ' ') {
                temp = temp.substring(1);
            }

            if(l < lines - 1) {
                newText += temp + "\n";
            } else {
                newText += temp;
            }
        }

        label.text.setText(newText);
    }


    @Override
    public void dispose() {

    }

    @Override
    public void setText(Text text, BitmapFont font, boolean align) {
        super.setText(text, font, align);
        this.font = font;
    }

    public Vector2 getDimensions() {
        return dimensions;
    }

    public void setDimensions(Vector2 dimensions) {
        this.dimensions = dimensions;
    }
}
