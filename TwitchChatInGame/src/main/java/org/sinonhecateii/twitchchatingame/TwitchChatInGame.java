package org.sinonhecateii.twitchchatingame;

import org.bukkit.plugin.java.JavaPlugin;
import org.sinonhecateii.twitchchatingame.getTwitchChat;
import org.bukkit.Bukkit;
public final class TwitchChatInGame extends JavaPlugin {
    private getTwitchChat TwitchChat;

    @Override
    public void onEnable() {
        // Plugin startup logic
        TwitchChat = new getTwitchChat();

        getLogger().info("TwitchChatInGame now available");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("TwitchChatInGame now disavailable");
    }
}
