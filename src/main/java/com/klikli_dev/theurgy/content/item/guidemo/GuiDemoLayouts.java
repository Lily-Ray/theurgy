// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.item.guidemo;

import com.klikli_dev.theurgy.TheurgyConstants;
import com.klikli_dev.theurgy.content.gui.lib.GeneratedGuiLayout;
import com.klikli_dev.theurgy.content.gui.lib.GeneratedGuiStyle;
import net.minecraft.network.chat.Component;

public final class GuiDemoLayouts {
    public static final int WIDTH = 214;
    public static final int HEIGHT = 205;
    public static final int PLAYER_PANEL_X = 19;
    public static final int PLAYER_PANEL_Y = 107;

    private static final int BLUE = 0xFF5A9BD8;
    private static final int BLUE_SHADOW = 0xFF2B5E8C;
    private static final int ORANGE = 0xFFF08A3C;
    private static final int ORANGE_SHADOW = 0xFFA85B22;

    private GuiDemoLayouts() {
    }

    public static GeneratedGuiLayout chestLayout() {
        var builder = GeneratedGuiLayout.builder(WIDTH, HEIGHT)
                .accentBar(19, 20, 176, 4, BLUE, BLUE_SHADOW)
                .panel(19, 24, 176, 79, GeneratedGuiStyle.WINDOW)
                .label(27, 31, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_CHEST_TITLE), 0xFF303030)
                .slotGrid(27, 44, 9, 3)
                .label(27, 90, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_CHEST_DESCRIPTION), 0xFF4C4C4C);
        addPlayerInventory(builder);
        return builder.build();
    }

    public static GeneratedGuiLayout playerLayout() {
        var builder = GeneratedGuiLayout.builder(WIDTH, HEIGHT)
                .accentBar(19, 20, 176, 4, BLUE, BLUE_SHADOW)
                .panel(19, 24, 176, 79, GeneratedGuiStyle.WINDOW)
                .label(27, 31, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_PLAYER_TITLE), 0xFF303030)
                .insetPanel(27, 34, 72, 55, GeneratedGuiStyle.PREVIEW)
                .slotGrid(112, 34, 2, 2)
                .slotGrid(166, 34, 1, 2)
                .slotGrid(166, 70, 1, 2)
                .slotGrid(142, 52, 1, 1)
                .label(27, 90, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_PLAYER_DESCRIPTION), 0xFF4C4C4C);
        addPlayerInventory(builder);
        return builder.build();
    }

    public static GeneratedGuiLayout filterLayout() {
        var builder = GeneratedGuiLayout.builder(WIDTH, HEIGHT)
                .accentBar(0, 20, 214, 4, ORANGE, ORANGE_SHADOW)
                .panel(0, 24, 214, 79, GeneratedGuiStyle.WINDOW)
                .label(18, 31, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_FILTER_TITLE), 0xFF303030)
                .slotGrid(18, 32, 9, 2)
                .insetPanel(18, 72, 120, 19, GeneratedGuiStyle.INSET)
                .insetPanel(160, 72, 36, 19, GeneratedGuiStyle.INSET)
                .label(18, 93, Component.translatable(TheurgyConstants.I18n.Gui.GUI_DEMO_FILTER_DESCRIPTION), 0xFF4C4C4C);
        addPlayerInventory(builder);
        return builder.build();
    }

    private static void addPlayerInventory(GeneratedGuiLayout.Builder builder) {
        builder.panel(PLAYER_PANEL_X, PLAYER_PANEL_Y, 176, 96, GeneratedGuiStyle.WINDOW)
                .slotGrid(PLAYER_PANEL_X + 7, PLAYER_PANEL_Y + 17, 9, 3)
                .slotGrid(PLAYER_PANEL_X + 7, PLAYER_PANEL_Y + 75, 9, 1);
    }
}
