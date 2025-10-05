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

        //Join Message Command
        if(command.getName().equalsIgnoreCase("setjm")){
            if(args.length == 0){
                sender.sendMessage("Usage: /setjm <message>");
                return true;
            }
            else{
                String newJoinMessage = String.join(" ", args);
                String setMessage = "&dJoin Message updated successfully!";
                plugin.getConfig().set("join-message", newJoinMessage);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', setMessage));
            }

            return true;
        }

        //Leave Message command
        else if(command.getName().equalsIgnoreCase("setlm")){
            if(args.length == 0){
                sender.sendMessage("Usage: /setlm <message>");
                return true;
            }
            else{
                String newLeaveMessage = String.join(" ", args);
                String setMessage = "&dLeave Message updated successfully!";
                plugin.getConfig().set("leave-message", newLeaveMessage);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', setMessage));
            }
            return true;
        }
        return false;
    }
}
