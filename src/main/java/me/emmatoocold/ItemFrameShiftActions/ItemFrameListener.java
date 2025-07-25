package me.emmatoocold.ItemFrameShiftActions;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class ItemFrameListener implements Listener {

    @EventHandler
    public boolean onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (!event.getPlayer().isSneaking()) {
            return false;
        }

        if (entity instanceof ItemFrame itemFrame) {

            Player player = event.getPlayer();
            ItemStack itemFrameItem = itemFrame.getItem();
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

            if (itemInMainHand.getType() == Material.GLOW_ITEM_FRAME) {
                ItemFrameLogic.swapGlowItemFrame(itemFrame);
                return true;
            }

            //remove name function
            if (itemFrameItem.getType() == itemInMainHand.getType()) {
                ItemFrameLogic.toggleItemName(itemFrame);
                return true;
            }

            //toggle itemframe invisibility
            else if (itemInMainHand.isEmpty()) {
                ItemFrameLogic.toggleItemFrameVisibility(itemFrame);
                return true;
            }

        }
        if (entity instanceof GlowItemFrame itemFrame) {

            Player player = event.getPlayer();
            ItemStack itemFrameItem = itemFrame.getItem();
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

            if (itemInMainHand.getType() == Material.ITEM_FRAME) {
                ItemFrameLogic.swapItemFrame(itemFrame);
                return true;
            }

            //remove name function
            if (itemFrameItem.getType() == itemInMainHand.getType()) {
                ItemFrameLogic.toggleItemName(itemFrame);
                return true;
            }

            //toggle itemframe invisibility
            else if (itemInMainHand.isEmpty()) {
                ItemFrameLogic.toggleItemFrameVisibility(itemFrame);
                return true;
            }
        }
        return false;
    }
}