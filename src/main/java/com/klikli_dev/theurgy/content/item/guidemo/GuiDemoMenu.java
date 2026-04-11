// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.item.guidemo;

import com.klikli_dev.theurgy.content.gui.menu.MenuBase;
import com.klikli_dev.theurgy.registry.MenuTypeRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GuiDemoMenu extends MenuBase<ItemStack> {
    public static final int WIDTH = GuiDemoLayouts.WIDTH;
    public static final int HEIGHT = GuiDemoLayouts.HEIGHT;
    public static final int PLAYER_PANEL_X = GuiDemoLayouts.PLAYER_PANEL_X;
    public static final int PLAYER_PANEL_Y = GuiDemoLayouts.PLAYER_PANEL_Y;
    public static final int PLAYER_SLOTS_X = PLAYER_PANEL_X + 7;
    public static final int PLAYER_SLOTS_Y = PLAYER_PANEL_Y + 17;

    protected GuiDemoMenu(MenuType<?> type, int id, Inventory inv, RegistryFriendlyByteBuf extraData) {
        super(type, id, inv, extraData);
    }

    protected GuiDemoMenu(MenuType<?> type, int id, Inventory inv, ItemStack contentHolder) {
        super(type, id, inv, contentHolder);
    }

    public static GuiDemoMenu create(int id, Inventory inv, ItemStack stack) {
        return new GuiDemoMenu(MenuTypeRegistry.GUI_DEMO.get(), id, inv, stack);
    }

    public static GuiDemoMenu create(int id, Inventory inv, RegistryFriendlyByteBuf extraData) {
        return new GuiDemoMenu(MenuTypeRegistry.GUI_DEMO.get(), id, inv, extraData);
    }

    @Override
    protected ItemStack createOnClient(RegistryFriendlyByteBuf extraData) {
        return ItemStack.STREAM_CODEC.decode(extraData);
    }

    @Override
    protected void initAndReadInventory(ItemStack contentHolder) {
    }

    @Override
    protected void addSlots() {
        this.addPlayerSlots(PLAYER_SLOTS_X, PLAYER_SLOTS_Y);
    }

    @Override
    protected void saveData(ItemStack contentHolder) {
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return this.playerInventory.getSelectedItem() == this.contentHolder;
    }

    @Override
    public void clicked(int slotId, int dragType, @NotNull ContainerInput clickTypeIn, @NotNull Player player) {
        if (slotId == this.playerInventory.getSelectedSlot() && clickTypeIn != ContainerInput.THROW)
            return;
        super.clicked(slotId, dragType, clickTypeIn, player);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int index) {
        return ItemStack.EMPTY;
    }
}
