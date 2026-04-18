package me.LIErZ.tierTestingProject.Match.Listeners;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    private final TierTestingProject tierTestingProject;

    public PlayerDeath(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent e) {
        Player player = e.getEntity();
        String killerString = tierTestingProject.getConfig().getString(ChatColor.stripColor(player.getDisplayName()) + ".in-match.target");
        Player killer = Bukkit.getPlayer(killerString);
        String WorldString = tierTestingProject.getConfig().getString(ChatColor.stripColor(player.getDisplayName()) + ".in-match.match");
        World world = Bukkit.getWorld(WorldString);
        if (world != null)
            if (player.getWorld().equals(world)) {
                if (killer.getWorld().equals(world)) {
                    if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.ranked") && tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.ranked")) {
                        int elo = tierTestingProject.getConfig().getInt(ChatColor.stripColor(killer.getDisplayName()) + ".elo");
                        elo += 3;
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".elo", elo);
                        tierTestingProject.saveConfig();
                    }
                    if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.Boolean")) {
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.Boolean", false);
                        tierTestingProject.saveConfig();
                    }
                    if (tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean")) {
                        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean", false);
                        tierTestingProject.saveConfig();
                    }

                    boolean KillerBoolean = tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.Boolean");
                    boolean PlayerBoolean = tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean");

                    if (!KillerBoolean) {
                        killer.teleport(Bukkit.getWorld("world").getSpawnLocation());
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".last-location", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.match", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.target", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(killer.getDisplayName()) + ".in-match.ranked", false);
                        tierTestingProject.saveConfig();
                    }
                    if (!PlayerBoolean) {
                        player.teleport(Bukkit.getWorld("world").getSpawnLocation());
                        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".last-location", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.match", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.target", "");
                        tierTestingProject.getConfig().set(ChatColor.stripColor(player.getDisplayName()) + ".in-match.ranked", false);
                        tierTestingProject.saveConfig();
                    }
                    tierTestingProject.saveConfig();

                    killer.getInventory().clear();
                    player.getInventory().clear();
                    tierTestingProject.PlayerJoinItems(killer);
                    tierTestingProject.PlayerJoinItems(player);
                }
            }
    }
}
