// src/main/java/me/emmatoocold/ItemFrameShiftActions/ItemFrameAttributes.java
package me.emmatoocold.ItemFrameShiftActions;

import org.bukkit.Location;
import org.bukkit.Rotation;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.inventory.ItemStack;

public class ItemFrameAttributes {
    public final Location location;
    public final Rotation rotation;
    public final BlockFace facing;
    public final ItemStack item;
    public final float itemDropChance;
    public final boolean visible;
    public final boolean fixed;
    public final boolean glowing;

    public ItemFrameAttributes(ItemFrame frame) {
        this.location = frame.getLocation();
        this.rotation = frame.getRotation();
        this.facing = frame.getAttachedFace();
        this.item = frame.getItem();
        this.itemDropChance = frame.getItemDropChance();
        this.visible = frame.isVisible();
        this.fixed = frame.isFixed();
        this.glowing = frame.isGlowing();
    }
}