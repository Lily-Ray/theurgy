// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.gui.lib;

import com.klikli_dev.theurgy.content.gui.AbstractButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

public class GeneratedTextButton extends AbstractButton {
    private boolean selected;

    public GeneratedTextButton(int x, int y, int width, int height, Component message) {
        super(x, y, width, height, message);
    }

    public GeneratedTextButton selected(boolean selected) {
        this.selected = selected;
        return this;
    }

    @Override
    protected void extractWidgetRenderState(GuiGraphicsExtractor pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.isHovered = this.isMouseOver(pMouseX, pMouseY);

        GeneratedGuiStyle style = !this.active ? GeneratedGuiStyle.BUTTON_DISABLED
                : this.selected ? GeneratedGuiStyle.BUTTON_SELECTED
                : this.isHovered ? GeneratedGuiStyle.BUTTON_HOVER : GeneratedGuiStyle.BUTTON;

        GeneratedGuiRenderer.drawPanel(pGuiGraphics, this.getX(), this.getY(), this.width, this.height, style);

        var font = Minecraft.getInstance().font;
        int textX = this.getX() + (this.width - font.width(this.getMessage())) / 2;
        int textY = this.getY() + (this.height - 8) / 2;
        pGuiGraphics.text(font, this.getMessage(), textX, textY, !this.active ? 0xFF676767 : 0xFF202020, false);
    }
}
