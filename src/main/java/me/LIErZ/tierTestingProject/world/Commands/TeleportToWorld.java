package me.LIErZ.tierTestingProject.world.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportToWorld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if(strings.length == 1) {
                World world = new WorldCreator(strings[0]).createWorld();
                if (world != null)
                    player.teleport(world.getSpawnLocation());
                else
                    player.sendMessage(ChatColor.RED + "error");
            }
        }
        return true;
    }
}
