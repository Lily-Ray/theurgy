// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.gui.lib;

import net.minecraft.client.gui.GuiGraphicsExtractor;

public final class GeneratedGuiRenderer {
    public static final int SLOT_SIZE = 18;

    private GeneratedGuiRenderer() {
    }

    public static void drawPanel(GuiGraphicsExtractor graphics, int x, int y, int width, int height, GeneratedGuiStyle style) {
        if (width <= 0 || height <= 0)
            return;

        graphics.fill(x, y, x + width, y + height, style.outlineColor());
        if (width <= 2 || height <= 2)
            return;

        graphics.fill(x + 1, y + 1, x + width - 1, y + height - 1, style.fillColor());
        graphics.fill(x + 1, y + 1, x + width - 1, y + 2, style.lightEdgeColor());
        graphics.fill(x + 1, y + 1, x + 2, y + height - 1, style.lightEdgeColor());
        graphics.fill(x + width - 2, y + 1, x + width - 1, y + height - 1, style.darkEdgeColor());
        graphics.fill(x + 1, y + height - 2, x + width - 1, y + height - 1, style.darkEdgeColor());
    }

    public static void drawInsetPanel(GuiGraphicsExtractor graphics, int x, int y, int width, int height, GeneratedGuiStyle style) {
        if (width <= 0 || height <= 0)
            return;

        graphics.fill(x, y, x + width, y + height, style.fillColor());
        graphics.fill(x, y, x + width, y + 1, style.darkEdgeColor());
        graphics.fill(x, y, x + 1, y + height, style.darkEdgeColor());
        graphics.fill(x + width - 1, y, x + width, y + height, style.lightEdgeColor());
        graphics.fill(x, y + height - 1, x + width, y + height, style.lightEdgeColor());
    }

    public static void drawAccentBar(GuiGraphicsExtractor graphics, int x, int y, int width, int height, int fillColor, int shadowColor) {
        if (width <= 0 || height <= 0)
            return;

        graphics.fill(x, y, x + width, y + height, fillColor);
        graphics.fill(x, y + height - 1, x + width, y + height, shadowColor);
    }

    public static void drawSlot(GuiGraphicsExtractor graphics, int x, int y) {
        drawInsetPanel(graphics, x, y, SLOT_SIZE, SLOT_SIZE, GeneratedGuiStyle.SLOT);
    }

    public static void drawSlotGrid(GuiGraphicsExtractor graphics, int x, int y, int columns, int rows, int spacing) {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                drawSlot(graphics, x + column * spacing, y + row * spacing);
            }
        }
    }
}
