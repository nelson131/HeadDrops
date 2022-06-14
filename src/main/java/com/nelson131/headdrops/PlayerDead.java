package com.nelson131.headdrops;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerDead implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Entity killer = (Entity) event.getEntity();
        Player player = (Player) event.getEntity();

        ItemStack Skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) Skull.getItemMeta();

        meta.setOwner(player.getName());
        meta.setDisplayName(ChatColor.RED + "Head of" + player.getName());
        Skull.setItemMeta(meta);

        if(player.getLastDamageCause() instanceof EntityDamageByEntityEvent){
            if(killer instanceof Player){
                player.getWorld().dropItem(player.getLocation().add(0,1,0), Skull);
            }
        }
    }
}
