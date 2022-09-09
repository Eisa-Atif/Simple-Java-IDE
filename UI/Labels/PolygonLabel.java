package com.eisaaatifguiide.myownide.UI.Labels;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import java.util.ArrayList;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextHeight;
import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getTextWidth;

public class PolygonLabel extends Label implements UIElement {
    private ArrayList<Vector2> vertices;

    public PolygonLabel() {
        super();
    }

    public PolygonLabel(float x, float y) {
        super(x, y);
    }

    public PolygonLabel(float x, float y, ArrayList<Vector2> vertices) {
        super(x, y);
        this.vertices = vertices;
    }

    public PolygonLabel(float x, float y, ArrayList<Vector2> vertices, Color colour) {
        super(x, y, colour);
        this.vertices = vertices;
    }

    public PolygonLabel(float x, float y, ArrayList<Vector2> vertices, Color colour, Text text) {
        super(x, y, colour, text);
        this.vertices = vertices;
    }

    public void render(ShapeRenderer sr, SpriteBatch batch) {
        update();
        sr.begin();

        for(int i = 0; i < vertices.size(); i++) {
            try {
                sr.line(vertices.get(i), vertices.get(i + 1));
            } catch(IndexOutOfBoundsException endOfArrayList) {
                sr.line(vertices.get(i), vertices.get(0));
            }
        }
        sr.end();
        // TODO fill polygon of the label
    }

    protected void update() {
        text.setTextSize(new Vector2(getTextWidth(this.font, this.text.getText()), getTextHeight(this.font, this.text.getText())));
    }

    @Override
    protected void alignText() {

    }

    @Override
    public void dispose() {

    }
}
