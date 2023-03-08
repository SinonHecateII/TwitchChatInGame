package org.sinonhecateii.twitchchatingame;

import org.bukkit.plugin.java.JavaPlugin;

public final class TwitchChatInGame extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("TwitchChatInGame now available");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("TwitchChatInGame now disavailable");
    }
}
