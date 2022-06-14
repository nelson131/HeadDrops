package com.nelson131.headdrops;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class HeadDrops extends JavaPlugin {
    Logger log = getLogger();

    @Override
    public void onEnable() {
        log.info("Enabled HeadDrops");
        getServer().getPluginManager().registerEvents(new PlayerDead(), this);
    }

    @Override
    public void onDisable() {

    }
}
