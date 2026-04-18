package me.LIErZ.tierTestingProject.Commands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.*;

public class EloCommand implements CommandExecutor {

    private TierTestingProject tierTestingProject;
    public EloCommand(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (strings.length == 0) {
                int elo = tierTestingProject.getConfig().getInt(ChatColor.stripColor(player.getDisplayName()) + ".elo");
                player.sendMessage(ChatColor.YELLOW + "Your elo is " + elo);
            }
            else if (strings.length == 1){
                Player target = Bukkit.getPlayerExact(strings[0]);
                if (target != null) {
                    if (target.equals(player)){
                        int elo = tierTestingProject.getConfig().getInt(ChatColor.stripColor(player.getDisplayName()) + ".elo");
                        player.sendMessage(ChatColor.YELLOW + "Your elo is " + elo);
                    }
                    else{
                        int elo = tierTestingProject.getConfig().getInt(ChatColor.stripColor(target.getDisplayName()) + ".elo");
                        player.sendMessage(ChatColor.YELLOW + ChatColor.stripColor(target.getDisplayName()) + "'s elo is " + elo);
                    }
                }
                else
                    player.sendMessage(ChatColor.RED + "Error, that player does not exist");
            }
        }

        return true;
    }
}
