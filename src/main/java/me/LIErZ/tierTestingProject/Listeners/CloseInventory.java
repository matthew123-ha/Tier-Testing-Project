package me.LIErZ.tierTestingProject.Listeners;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseInventory implements Listener {

    private final TierTestingProject tierTestingProject;

    public CloseInventory(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e){
        Player player = (Player) e.getPlayer();
        if (!tierTestingProject.getConfig().getBoolean(ChatColor.stripColor(player.getDisplayName()) + ".in-match.Boolean")){
            player.getInventory().clear();
            tierTestingProject.PlayerJoinItems(player);
        }
    }
}
