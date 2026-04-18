package me.LIErZ.tierTestingProject.Match.Listeners.PlayerLeavePackage;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayerQuit {

    public void PlayerLeaveBOI(Player player, Player target, TierTestingProject tierTestingProject) {

        if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(target.getDisplayName()) + ".in-match.Boolean")) {
            World PlayerWorld = Bukkit.getWorld(tierTestingProject.getConfig().getString(ChatColor.stripColor(player.getDisplayName()) + ".in-match.match"));
            World TargetWorld = Bukkit.getWorld(tierTestingProject.getConfig().getString(ChatColor.stripColor(target.getDisplayName()) + ".in-match.match"));
            if (TargetWorld != PlayerWorld) {
                if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(target.getDisplayName()) + ".in-match.ranked")) {
                    int elo = tierTestingProject.getConfig().getInt(ChatColor.stripColor(target.getDisplayName()) + ".elo");
                    elo += 3;
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".elo", elo);
                    tierTestingProject.saveConfig();
                }
                if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(target.getDisplayName()) + ".in-match.Boolean")) {
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".in-match.Boolean", false);
                    tierTestingProject.saveConfig();
                }
                if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean")) {
                    tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean", false);
                    tierTestingProject.saveConfig();
                }

                boolean TargetPlayer = tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(target.getDisplayName()) + ".in-match.Boolean");
                boolean PlayerBoolean = tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean");

                if (!PlayerBoolean && !TargetPlayer) {
                    tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".last-location", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.match", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.target", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.ranked", false);
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".last-location", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".in-match.match", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".in-match.target", "");
                    tierTestingProject.getConfig().set(ChatColor.stripColor(target.getDisplayName()) + ".in-match.ranked", false);
                    tierTestingProject.saveConfig();

                    target.teleport(Bukkit.getWorld("world").getSpawnLocation());
                    target.sendMessage(ChatColor.GREEN + "Your opponent has teleported away, sending you back to spawn");
                }
            }
        }
    }

}
