package com.eisaaatifguiide.myownide.UI.Buttons;

import com.badlogic.gdx.utils.viewport.Viewport;

public interface Button {
    boolean isHoveredOn(Viewport viewport);
    boolean isClickedOn(Viewport viewport);
    boolean isHeldClickedOn(Viewport viewport);
    void modifyOnHover(Viewport viewport);
    void modifyOnClick(Viewport viewport);
}
