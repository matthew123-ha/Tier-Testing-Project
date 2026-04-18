package me.LIErZ.tierTestingProject.Match.Listeners;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerJoin implements Listener {
    private final TierTestingProject tierTestingProject;
    private final int DefaultElo;

    public PlayerJoin(TierTestingProject tierTestingProject, int DefaultElo) {
        this.tierTestingProject = tierTestingProject;
        this.DefaultElo = DefaultElo;
    }

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        World world = Bukkit.getWorld("world");
        e.getPlayer().teleport(world.getSpawnLocation());
        if (!tierTestingProject.getConfig().contains(ChatColor.stripColor(e.getPlayer().getDisplayName()) + ".elo"))
            tierTestingProject.getConfig().set(ChatColor.stripColor(e.getPlayer().getDisplayName()) + ".elo", DefaultElo);
        tierTestingProject.PlayerJoinItems(e.getPlayer());

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "heal " + ChatColor.stripColor(e.getPlayer().getDisplayName()));
    }
}
