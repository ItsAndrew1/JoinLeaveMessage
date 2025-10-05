package me.andrew.joinLeaveMessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveMessage extends JavaPlugin{
    @Override
    public void onEnable(){
        saveDefaultConfig();

        //Register the commands
        getCommand("setjm").setExecutor(new JoinLeaveCommands(this));
        getCommand("setlm").setExecutor(new JoinLeaveCommands(this));

        //Register the events
        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new LeaveEvent(this), this);
    }
}