package me.emmatoocold.ItemFrameShiftActions;

import org.bukkit.entity.GlowItemFrame;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class ItemFrameLogic {

    private static final Map<ItemFrame, String> storedNames = new HashMap<>();

    public static void toggleItemName(ItemFrame itemFrame) {
        ItemStack item = itemFrame.getItem();
        if (item == null) return;
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return;

        if (!storedNames.containsKey(itemFrame)) {
            if (meta.hasDisplayName()) {
                itemFrame.setRotation(itemFrame.getRotation().rotateCounterClockwise());
                storedNames.put(itemFrame, meta.getDisplayName());
                meta.setDisplayName(null);
                item.setItemMeta(meta);
                itemFrame.setItem(item);
            }
        } else {
            itemFrame.setRotation(itemFrame.getRotation().rotateCounterClockwise());
            meta.setDisplayName(storedNames.get(itemFrame));
            item.setItemMeta(meta);
            itemFrame.setItem(item);
            storedNames.remove(itemFrame);
        }
    }

    public static void toggleItemFrameVisibility(ItemFrame itemFrame) {
        itemFrame.setVisible(!itemFrame.isVisible());
        itemFrame.setRotation(itemFrame.getRotation().rotateCounterClockwise());
    }

    public static void swapGlowItemFrame(ItemFrame itemFrame) {
        ItemFrameAttributes attrs = new ItemFrameAttributes(itemFrame);
        itemFrame.remove();
        GlowItemFrame newFrame = itemFrame.getWorld().spawn(attrs.location, GlowItemFrame.class);
        newFrame.setRotation(attrs.rotation);
        newFrame.setFacingDirection(attrs.facing);
        newFrame.setItem(attrs.item);
        newFrame.setItemDropChance(attrs.itemDropChance);
        newFrame.setVisible(attrs.visible);
        newFrame.setFixed(attrs.fixed);
        newFrame.setGlowing(attrs.glowing);
        }

    public static void swapItemFrame(GlowItemFrame itemFrame){
        ItemFrameAttributes attrs = new ItemFrameAttributes(itemFrame);
        itemFrame.remove();
        ItemFrame newFrame = itemFrame.getWorld().spawn(attrs.location, ItemFrame.class);
        newFrame.setRotation(attrs.rotation);
        newFrame.setFacingDirection(attrs.facing);
        newFrame.setItem(attrs.item);
        newFrame.setItemDropChance(attrs.itemDropChance);
        newFrame.setVisible(attrs.visible);
        newFrame.setFixed(attrs.fixed);
        newFrame.setGlowing(attrs.glowing);
        }
}