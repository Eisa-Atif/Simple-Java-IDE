package com.eisaaatifguiide.myownide.UI.Buttons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getMousePos;

public class CapsuleButton extends RectButton implements Button, UIElement {
    public CapsuleButton() {
        super();
    }

    public CapsuleButton(Vector2 dimensions) {
        super(dimensions);
    }

    public CapsuleButton(float x, float y) {
        super(x, y);
    }

    public CapsuleButton(float x, float y, Vector2 dimensions) {
        super(x, y, dimensions);
    }

    public CapsuleButton(float x, float y, Vector2 dimensions, Color colour) {
        super(x, y, dimensions, colour);
    }

    public CapsuleButton(float x, float y, Vector2 dimensions, Color colour, Text text) {
        super(x, y, dimensions, colour, text);
    }

    @Override
    public void render(ShapeRenderer sr, SpriteBatch batch) {
        update();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(borderColour);
        sr.circle(this.x, this.y + this.dimensions.y / 2, (this.dimensions.y + borderThickness) / 2);
        sr.circle(this.x + this.dimensions.x, this.y + this.dimensions.y / 2, (this.dimensions.y + borderThickness) / 2);
        sr.setColor(colour);
        sr.circle(this.x, this.y + this.dimensions.y / 2, this.dimensions.y / 2);
        sr.circle(this.x + this.dimensions.x, this.y + this.dimensions.y / 2, this.dimensions.y / 2);
        sr.setColor(borderColour);
        sr.rect(this.x - this.borderThickness / 2, this.y - this.borderThickness / 2, this.dimensions.x + borderThickness, this.getDimensions().y + this.borderThickness);
        sr.setColor(colour);
        sr.rect(this.x, this.y, this.getDimensions().x, this.getDimensions().y);
        sr.rectLine(new Vector2(this.x, this.y), new Vector2(this.x, this.y + dimensions.x), borderThickness);
        sr.rectLine(new Vector2(this.x + dimensions.x, this.y), new Vector2(this.x + dimensions.x, this.y + dimensions.x), borderThickness);
        sr.end();

        this.text.setTextPos(new Vector2(this.x + this.dimensions.x / 2 - text.getTextSize().x / 2, this.y + this.dimensions.y / 2 + this.text.getTextSize().y / 2));
        this.text.render(this.font, batch);
    }

    @Override
    public boolean isHoveredOn(Viewport viewport) {
        return super.isHoveredOn(viewport) || new Vector2(this.x, this.y + this.dimensions.y / 2).dst(getMousePos(viewport)) < this.dimensions.y / 2 || new Vector2(this.x + this.dimensions.x, this.y + this.dimensions.y / 2).dst(getMousePos(viewport)) < this.dimensions.y / 2;

    }
}
