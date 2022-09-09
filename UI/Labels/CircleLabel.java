package com.eisaaatifguiide.myownide.UI.Labels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextHeight;
import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextWidth;

public class CircleLabel extends Label implements UIElement {
    protected float r = 0;

    public CircleLabel() {
        super();
    }

    public CircleLabel(float x, float y) {
        super(x, y);
    }

    public CircleLabel(float x, float y, float r) {
        super(x, y);
        this.r = r;
    }

    public CircleLabel(float x, float y, float r, Color colour) {
        super(x, y, colour);
        this.r = r;
    }

    public CircleLabel(float x, float y, float r, Color colour, Text text) {
        super(x, y, colour, text);
        this.r = r;
    }

    public void render(ShapeRenderer sr, SpriteBatch batch) {
        update();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(borderColour);
        sr.circle(this.x, this.y, this.r + borderThickness);
        sr.setColor(colour);
        sr.circle(this.x, this.y, this.r);
        sr.end();

        this.text.setTextPos(new Vector2(this.x - text.getTextSize().x / 2, this.y + this.text.getTextSize().y / 2));
        this.text.render(this.font, batch);
    }

    protected void update() {
        text.setTextSize(new Vector2(getTextWidth(this.font, this.text.getText()), getTextHeight(this.font, this.text.getText())));
    }

    @Override
    protected void alignText() {
        float a = (float) (this.r / Math.sqrt(2) * 2); // the diagonal of the square is equivalent to the radius of the circle times 2
        RectLabel.alignText(this, a);
    }

    @Override
    public void dispose() {

    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    };
}
