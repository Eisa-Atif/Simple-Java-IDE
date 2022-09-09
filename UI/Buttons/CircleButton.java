package com.eisaaatifguiide.myownide.UI.Buttons;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.eisaaatifguiide.myownide.UI.Extras.InputHandler;
import com.eisaaatifguiide.myownide.UI.Labels.CircleLabel;
import com.eisaaatifguiide.myownide.UI.Extras.Text;
import com.eisaaatifguiide.myownide.UI.UIElement;

import static com.eisaaatifguiide.myownide.UI.Extras.Extras.getMousePos;

public class CircleButton extends CircleLabel implements Button, UIElement {
    private int buttonOfChoice = Input.Buttons.LEFT;
    private float changeSizeOnHoverFactor = 1;
    private float changeSizeOnClickFactor = 1;
    private float initR = this.r;
    private Color initColour = colour;
    private Color changedColourOnHover = colour;
    private Color changedColourOnClick = colour;

    public CircleButton() {
        super();
    }

    public CircleButton(float x, float y) {
        super(x, y);
    }

    public CircleButton(float x, float y, float r) {
        super(x, y, r);
    }

    public CircleButton(float x, float y, float r, Color colour) {
        super(x, y, r, colour);
    }

    public CircleButton(float x, float y, float r, Color colour, Text text) {
        super(x, y, r, colour, text);
    }

    public void update(Viewport viewport) {
        super.update();
        modifyOnHover(viewport);
        modifyOnClick(viewport);
    }

    @Override
    public boolean isHoveredOn(Viewport viewport) {
        return new Circle(this.x, this.y, this.r).contains(getMousePos(viewport));
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
            this.r = this.initR * changeSizeOnHoverFactor;
            this.colour = changedColourOnHover;
        } else if(!isHeldClickedOn(viewport)) {
            this.r = initR;
            this.colour = this.initColour;
        }
    }

    @Override
    public void modifyOnClick(Viewport viewport) {
        if(isHeldClickedOn(viewport)) {
            this.r = initR * changeSizeOnClickFactor;
            this.colour = changedColourOnHover;
        } else if(!isHeldClickedOn(viewport)) {
            this.r = initR;
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
    public void setR(float r) {
        this.r = r;
        this.initR = r;
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

    public float getInitR() {
        return initR;
    }

    public void setInitR(float initR) {
        this.initR = initR;
    }

    public Color getInitColour() {
        return initColour;
    }

    public void setInitColour(Color initColour) {
        this.initColour = initColour;
    }
}
