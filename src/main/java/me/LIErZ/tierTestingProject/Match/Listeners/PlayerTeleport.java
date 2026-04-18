package me.LIErZ.tierTestingProject.Match.Listeners;

import me.LIErZ.tierTestingProject.Match.Listeners.PlayerLeavePackage.PlayerQuit;
import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener {

    private final TierTestingProject tierTestingProject;

    public PlayerTeleport(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        Player player = e.getPlayer();
        Player targetPlayer = Bukkit.getPlayerExact(tierTestingProject.getConfig().getString(ChatColor.stripColor(player.getDisplayName()) + ".in-match.target"));
        if (targetPlayer != null) {
            if (!player.getWorld().getPlayers().contains(targetPlayer) || !targetPlayer.getWorld().getPlayers().contains(player)) {
                new PlayerQuit().PlayerLeaveBOI(e.getPlayer(), e.getPlayer(), tierTestingProject);
            }
        }
    }
}
