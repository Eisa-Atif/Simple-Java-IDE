package com.eisaaatifguiide.myownide.UI.Buttons;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eisaaatifguiide.myownide.UI.Extras.InputHandler;
import com.eisaaatifguiide.myownide.UI.Labels.RectLabel;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getMousePos;

public class RectButton extends RectLabel implements Button, UIElement {
    private int buttonOfChoice = Input.Buttons.LEFT;
    private float changeSizeOnHoverFactor = 1;
    private float changeSizeOnClickFactor = 1;
    private float initWidth = dimensions.x;
    private float initHeight = dimensions.y;
    private float initX = this.x;
    private float initY = this.y;
    private Color initColour = colour;
    private Color changedColourOnHover = colour;
    private Color changedColourOnClick = colour;

    public RectButton() {
        super();
    }

    public RectButton(Vector2 dimensions) {
        super(dimensions);
    }

    public RectButton(float x, float y) {
        super(x, y);
    }

    public RectButton(float x, float y, Vector2 dimensions) {
        super(x, y, dimensions);
    }

    public RectButton(float x, float y, Vector2 dimensions, Color colour) {
        super(x, y, dimensions, colour);
    }

    public RectButton(float x, float y, Vector2 dimensions, Color colour, Text text) {
        super(x, y, dimensions, colour, text);
    }

    public void update(Viewport viewport) {
        super.update();
        modifyOnHover(viewport);
        modifyOnClick(viewport);
    }

    @Override
    public boolean isHoveredOn(Viewport viewport) {
        float mx = getMousePos(viewport).x, my = getMousePos(viewport).y;
        return (mx > this.x && mx < this.x + this.dimensions.x) && (my > this.y && my < this.y + this.dimensions.y);
    }

    @Override
    public boolean isClickedOn(Viewport viewport) {
        return isHoveredOn(viewport) && InputHandler.isButtonJustUp(buttonOfChoice);
    }

    @Override
    public boolean isHeldClickedOn(Viewport viewport) {
        return isHoveredOn(viewport) && InputHandler.isButtonDown(buttonOfChoice);
    }

    @Override
    public void modifyOnHover(Viewport viewport) {
        if(isHoveredOn(viewport)) {
            this.dimensions.x = this.initWidth * changeSizeOnHoverFactor;
            this.dimensions.y = this.initHeight * changeSizeOnHoverFactor;
            float dx = this.dimensions.x - this.initWidth;
            float dy = this.dimensions.y - this.initHeight;
            this.x = initX - dx / 2;
            this.y = initY - dy / 2;
            this.colour = changedColourOnHover;
        } else if(!isHeldClickedOn(viewport)) {
            this.dimensions.x = this.initWidth;
            this.dimensions.y = this.initHeight;
            this.x = this.initX;
            this.y = this.initY;
            this.colour = this.initColour;
        }
    }

    @Override
    public void modifyOnClick(Viewport viewport) {
        if(isHeldClickedOn(viewport)) {
            this.dimensions.x = this.initWidth * changeSizeOnClickFactor;
            this.dimensions.y = this.initHeight * changeSizeOnClickFactor;
            float dx = this.dimensions.x - this.initWidth;
            float dy = this.dimensions.y - this.initHeight;
            this.x = initX - dx / 2;
            this.y = initY - dy / 2;
            this.colour = changedColourOnClick;
        } else if(!isHoveredOn(viewport)) {
            this.dimensions.x = this.initWidth;
            this.dimensions.y = this.initHeight;
            this.x = this.initX;
            this.y = this.initY;
            this.colour = this.initColour;
        }
    }

    public int getButtonOfChoice() {
        return buttonOfChoice;
    }

    public void setButtonOfChoice(int buttonOfChoice) {
        this.buttonOfChoice = buttonOfChoice;
    }

    @Override
    public void setX(float x) {
        super.setX(x);
        this.initX = x;
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        this.initY = y;
    }

    @Override
    public void setDimensions(Vector2 dimensions) {
        super.setDimensions(dimensions);
        this.initWidth = dimensions.x;
        this.initHeight = dimensions.y;
    }

    @Override
    public void setColour(Color colour) {
        super.setColour(colour);
        this.initColour = colour;
    }

    public Color getChangedColourOnHover() {
        return changedColourOnHover;
    }

    public void setChangedColourOnHover(Color changedColour) {
        this.changedColourOnHover = changedColour;
    }

    public Color getChangedColourOnClick() {
        return changedColourOnClick;
    }

    public void setChangedColourOnClick(Color changedColourOnClick) {
        this.changedColourOnClick = changedColourOnClick;
    }

    public float getChangeSizeOnClickFactor() {
        return changeSizeOnClickFactor;
    }

    public void setChangeSizeOnClickFactor(float changeSizeOnClickFactor) {
        this.changeSizeOnClickFactor = changeSizeOnClickFactor;
    }

    public float getChangeSizeOnHoverFactor() {
        return changeSizeOnHoverFactor;
    }

    public void setChangeSizeOnHoverFactor(float changeSizeOnHoverFactor) {
        this.changeSizeOnHoverFactor = changeSizeOnHoverFactor;
    }

}
