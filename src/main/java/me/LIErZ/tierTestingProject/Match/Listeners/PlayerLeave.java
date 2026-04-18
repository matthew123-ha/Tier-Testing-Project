package me.LIErZ.tierTestingProject.Match.Listeners;

import me.LIErZ.tierTestingProject.Match.Listeners.PlayerLeavePackage.PlayerQuit;
import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    private final TierTestingProject tierTestingProject;

    public PlayerLeave(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(event.getPlayer().getDisplayName()) + ".in-match.Boolean")) {
            Player target = Bukkit.getPlayerExact(tierTestingProject.getConfig().getString(ChatColor.stripColor(event.getPlayer().getDisplayName()) + ".in-match.target"));
            
            tierTestingProject.getConfig().set(ChatColor.stripColor(event.getPlayer().getDisplayName()) + ".in-match.Boolean", false);
            tierTestingProject.getConfig().set(ChatColor.stripColor(event.getPlayer().getDisplayName()) + ".in-match.match", "");
            tierTestingProject.saveConfig();
            new PlayerQuit().PlayerLeaveBOI(event.getPlayer(), target, tierTestingProject);
        }
    }
}
