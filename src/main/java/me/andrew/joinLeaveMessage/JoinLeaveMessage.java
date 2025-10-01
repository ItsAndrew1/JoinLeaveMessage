package me.andrew.joinLeaveMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class JoinLeaveMessage extends JavaPlugin implements Listener{
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        String joinMessage = getConfig().getString("join-message");
        joinMessage = joinMessage.replace("{player}", event.getPlayer().getName());

        joinMessage = ChatColor.translateAlternateColorCodes('&', joinMessage);

        event.setJoinMessage(joinMessage);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String leaveMessage = getConfig().getString("leave-message");
        leaveMessage = leaveMessage.replace("{player}", event.getPlayer().getName());

        leaveMessage = ChatColor.translateAlternateColorCodes('&', leaveMessage);

        event.setQuitMessage(leaveMessage);
    }
}