// SPDX-FileCopyrightText: 2026 klikli-dev
//
// SPDX-License-Identifier: MIT

package com.klikli_dev.theurgy.content.item.guidemo;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GuiDemoItem extends Item implements MenuProvider {
    public GuiDemoItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getPlayer() == null)
            return InteractionResult.PASS;
        return this.use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack heldItem = pPlayer.getItemInHand(pUsedHand);

        if (!pPlayer.isShiftKeyDown() && pUsedHand == InteractionHand.MAIN_HAND) {
            if (!pLevel.isClientSide() && pPlayer instanceof ServerPlayer serverPlayer) {
                serverPlayer.openMenu(this, buf -> ItemStack.STREAM_CODEC.encode(buf, heldItem));
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return GuiDemoMenu.create(pContainerId, pPlayerInventory, pPlayer.getMainHandItem());
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(this.getDescriptionId());
    }
}
