// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.gui.lib;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public final class GeneratedGuiLayout {
    private final int width;
    private final int height;
    private final int titleX;
    private final int titleY;
    private final int subtitleX;
    private final int subtitleY;
    private final List<Element> elements;

    private GeneratedGuiLayout(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.titleX = builder.titleX;
        this.titleY = builder.titleY;
        this.subtitleX = builder.subtitleX;
        this.subtitleY = builder.subtitleY;
        this.elements = List.copyOf(builder.elements);
    }

    public static Builder builder(int width, int height) {
        return new Builder(width, height);
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public int titleX() {
        return this.titleX;
    }

    public int titleY() {
        return this.titleY;
    }

    public int subtitleX() {
        return this.subtitleX;
    }

    public int subtitleY() {
        return this.subtitleY;
    }

    public void render(GuiGraphicsExtractor graphics, int left, int top) {
        for (Element element : this.elements) {
            element.render(graphics, left, top);
        }
    }

    public interface Element {
        void render(GuiGraphicsExtractor graphics, int left, int top);
    }

    public record PanelElement(int x, int y, int width, int height, GeneratedGuiStyle style) implements Element {
        @Override
        public void render(GuiGraphicsExtractor graphics, int left, int top) {
            GeneratedGuiRenderer.drawPanel(graphics, left + this.x, top + this.y, this.width, this.height, this.style);
        }
    }

    public record InsetPanelElement(int x, int y, int width, int height, GeneratedGuiStyle style) implements Element {
        @Override
        public void render(GuiGraphicsExtractor graphics, int left, int top) {
            GeneratedGuiRenderer.drawInsetPanel(graphics, left + this.x, top + this.y, this.width, this.height, this.style);
        }
    }

    public record AccentBarElement(int x, int y, int width, int height, int fillColor, int shadowColor) implements Element {
        @Override
        public void render(GuiGraphicsExtractor graphics, int left, int top) {
            GeneratedGuiRenderer.drawAccentBar(graphics, left + this.x, top + this.y, this.width, this.height, this.fillColor, this.shadowColor);
        }
    }

    public record SlotGridElement(int x, int y, int columns, int rows, int spacing) implements Element {
        @Override
        public void render(GuiGraphicsExtractor graphics, int left, int top) {
            GeneratedGuiRenderer.drawSlotGrid(graphics, left + this.x, top + this.y, this.columns, this.rows, this.spacing);
        }
    }

    public record LabelElement(int x, int y, Component text, int color, boolean shadow) implements Element {
        @Override
        public void render(GuiGraphicsExtractor graphics, int left, int top) {
            graphics.text(net.minecraft.client.Minecraft.getInstance().font, this.text, left + this.x, top + this.y, this.color, this.shadow);
        }
    }

    public static final class Builder {
        private final int width;
        private final int height;
        private int titleX;
        private int titleY;
        private int subtitleX;
        private int subtitleY;
        private final List<Element> elements = new ArrayList<>();

        private Builder(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Builder title(int x, int y) {
            this.titleX = x;
            this.titleY = y;
            return this;
        }

        public Builder subtitle(int x, int y) {
            this.subtitleX = x;
            this.subtitleY = y;
            return this;
        }

        public Builder panel(int x, int y, int width, int height, GeneratedGuiStyle style) {
            this.elements.add(new PanelElement(x, y, width, height, style));
            return this;
        }

        public Builder insetPanel(int x, int y, int width, int height, GeneratedGuiStyle style) {
            this.elements.add(new InsetPanelElement(x, y, width, height, style));
            return this;
        }

        public Builder accentBar(int x, int y, int width, int height, int fillColor, int shadowColor) {
            this.elements.add(new AccentBarElement(x, y, width, height, fillColor, shadowColor));
            return this;
        }

        public Builder slotGrid(int x, int y, int columns, int rows) {
            return this.slotGrid(x, y, columns, rows, GeneratedGuiRenderer.SLOT_SIZE);
        }

        public Builder slotGrid(int x, int y, int columns, int rows, int spacing) {
            this.elements.add(new SlotGridElement(x, y, columns, rows, spacing));
            return this;
        }

        public Builder label(int x, int y, Component text, int color) {
            this.elements.add(new LabelElement(x, y, text, color, false));
            return this;
        }

        public Builder label(int x, int y, Component text, int color, boolean shadow) {
            this.elements.add(new LabelElement(x, y, text, color, shadow));
            return this;
        }

        public GeneratedGuiLayout build() {
            return new GeneratedGuiLayout(this);
        }
    }
}
