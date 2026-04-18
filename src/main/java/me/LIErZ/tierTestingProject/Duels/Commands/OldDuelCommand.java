package me.LIErZ.tierTestingProject.Duels.Commands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import me.LIErZ.tierTestingProject.world.CreateWorld;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class OldDuelCommand implements CommandExecutor {

    private final TierTestingProject tierTestingProject;

    public OldDuelCommand(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 1) {
                File source = new File(Bukkit.getWorldContainer(), CreateWorld.TemplateWorld);
                Player targetPlayer = Bukkit.getServer().getPlayerExact(strings[0]);
                if (targetPlayer != null) {
                    if (targetPlayer != player) {
                        try {
                            CreateWorld.CreateTheWorld(source, new File(Bukkit.getWorldContainer(), String.valueOf(Math.random())), player, tierTestingProject, targetPlayer, false);
                        } catch (IOException e) {
                            player.sendMessage(e.toString());
                        }
                    }
                }
            }
        }
        return true;
    }
}
