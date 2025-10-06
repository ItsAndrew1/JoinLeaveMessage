package me.andrew.joinLeaveMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class JoinLeaveCommands implements CommandExecutor {
    private final JoinLeaveMessage plugin;

    public JoinLeaveCommands(JoinLeaveMessage plugin){
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        String noPermissionMessage = "&cYou don't have permission to run this command!";

        //Join Message Command
        if(command.getName().equalsIgnoreCase("setjm")){
            if(!sender.hasPermission("joinleavemessage.setjm")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', noPermissionMessage));
                return true;
            }
            else if(args.length == 0){
                sender.sendMessage("Usage: /setjm <message>");
                return true;
            }
            else{
                String newJoinMessage = String.join(" ", args);
                String setMessage = "&aJoin Message updated successfully!";
                plugin.getConfig().set("join-message", newJoinMessage);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', setMessage));
            }
            return true;
        }

        //Leave Message command
        else if(command.getName().equalsIgnoreCase("setlm")){
            if(!sender.hasPermission("joinleavemessage.setlm")){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', noPermissionMessage));
                return true;
            }
            if(args.length == 0){
                sender.sendMessage("Usage: /setlm <message>");
                return true;
            }
            else{
                String newLeaveMessage = String.join(" ", args);
                String setMessage = "&aLeave Message updated successfully!";
                plugin.getConfig().set("leave-message", newLeaveMessage);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', setMessage));
            }
            return true;
        }
        return false;
    }
}
