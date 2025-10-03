package me.andrew.joinLeaveMessage;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
    private final JoinLeaveMessage plugin;

    public JoinEvent(JoinLeaveMessage plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String joinMessage = plugin.getConfig().getString("join-message");
        joinMessage = joinMessage.replace("{player}", event.getPlayer().getName());

        joinMessage = ChatColor.translateAlternateColorCodes('&', joinMessage);

        event.setJoinMessage(joinMessage);
    }
}