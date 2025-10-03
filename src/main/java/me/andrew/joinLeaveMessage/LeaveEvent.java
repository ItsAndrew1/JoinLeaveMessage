package me.andrew.joinLeaveMessage;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    private final JoinLeaveMessage plugin;

    public LeaveEvent(JoinLeaveMessage plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        String leaveMessage = plugin.getConfig().getString("leave-message");
        leaveMessage = leaveMessage.replace("{player}", event.getPlayer().getName());

        leaveMessage = ChatColor.translateAlternateColorCodes('&', leaveMessage);

        event.setQuitMessage(leaveMessage);
    }
}
