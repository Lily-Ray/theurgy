// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.item.guidemo;

import com.klikli_dev.theurgy.TheurgyConstants;
import com.klikli_dev.theurgy.content.gui.lib.GeneratedGuiLayout;
import com.klikli_dev.theurgy.content.gui.lib.GeneratedTextButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class GuiDemoScreen extends AbstractContainerScreen<GuiDemoMenu> {
    private GeneratedTextButton chestButton;
    private GeneratedTextButton playerButton;
    private GeneratedTextButton filterButton;
    private DemoMode currentDemo = DemoMode.CHEST;

    public GuiDemoScreen(GuiDemoMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title, GuiDemoMenu.WIDTH, GuiDemoMenu.HEIGHT);
    }

    @Override
    protected void init() {
        super.init();

        int x = this.leftPos + 5;
        int y = this.topPos + 2;

        this.chestButton = new GeneratedTextButton(x, y, 64, 16, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_CHEST_BUTTON));
        this.chestButton.withOnClick(() -> this.setDemo(DemoMode.CHEST));
        this.addRenderableWidget(this.chestButton);

        this.playerButton = new GeneratedTextButton(x + 69, y, 64, 16, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_PLAYER_BUTTON));
        this.playerButton.withOnClick(() -> this.setDemo(DemoMode.PLAYER));
        this.addRenderableWidget(this.playerButton);

        this.filterButton = new GeneratedTextButton(x + 138, y, 64, 16, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_FILTER_BUTTON));
        this.filterButton.withOnClick(() -> this.setDemo(DemoMode.FILTER));
        this.addRenderableWidget(this.filterButton);

        this.updateButtons();
    }

    @Override
    public void extractRenderState(@NotNull GuiGraphicsExtractor pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.extractRenderState(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.extractTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor pGuiGraphics, int pMouseX, int pMouseY) {
    }

    @Override
    public void extractContents(GuiGraphicsExtractor pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        GeneratedGuiLayout layout = this.currentDemo.layout;
        layout.render(pGuiGraphics, this.leftPos, this.topPos);

        pGuiGraphics.text(this.font, this.playerInventoryTitle, this.leftPos + GuiDemoMenu.PLAYER_PANEL_X + 8, this.topPos + GuiDemoMenu.PLAYER_PANEL_Y + 6, 0xFF404040, false);

        super.extractContents(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
    }

    private void setDemo(DemoMode demoMode) {
        this.currentDemo = demoMode;
        this.updateButtons();
    }

    private void updateButtons() {
        if (this.chestButton != null)
            this.chestButton.selected(this.currentDemo == DemoMode.CHEST);
        if (this.playerButton != null)
            this.playerButton.selected(this.currentDemo == DemoMode.PLAYER);
        if (this.filterButton != null)
            this.filterButton.selected(this.currentDemo == DemoMode.FILTER);
    }

    private enum DemoMode {
        CHEST(GuiDemoLayouts.chestLayout()),
        PLAYER(GuiDemoLayouts.playerLayout()),
        FILTER(GuiDemoLayouts.filterLayout());

        private final GeneratedGuiLayout layout;

        DemoMode(GeneratedGuiLayout layout) {
            this.layout = layout;
        }
    }
}
