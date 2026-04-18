package me.LIErZ.tierTestingProject.Match.Listeners;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class Interact implements Listener {

    private final TierTestingProject tierTestingProject;
    private final ChatColor ItemDuelMenuChatColor;
    private final String ItemDuelMenu;
    private final ChatColor ItemDuelMenuRankedChatColor;
    private final String ItemDuelMenuRanked;

    public Interact(TierTestingProject tierTestingProject, ChatColor ItemDuelMenuRankedChatColor, String ItemDuelMenu, ChatColor ItemDuelMenuChatColor, String ItemDuelMenuRanked) {
        this.tierTestingProject = tierTestingProject;
        this.ItemDuelMenuChatColor = ItemDuelMenuChatColor;
        this.ItemDuelMenu = ItemDuelMenu;
        this.ItemDuelMenuRankedChatColor = ItemDuelMenuRankedChatColor;
        this.ItemDuelMenuRanked = ItemDuelMenuRanked;
    }

    @EventHandler
    public void InteractEvent(PlayerInteractEvent event) {
        if (event.getItem() != null) {
            ItemMeta itemMeta = event.getItem().getItemMeta();
            if (itemMeta != null) {
                if (event.getItem().getItemMeta().getDisplayName().equals(ItemDuelMenuChatColor + ItemDuelMenu))
                    tierTestingProject.GetHolyMenus().DuelMenu(event.getPlayer());
                else if (event.getItem().getItemMeta().getDisplayName().equals(ItemDuelMenuRankedChatColor + ItemDuelMenuRanked))
                    tierTestingProject.GetHolyMenus().DuelMenuRanked(event.getPlayer());
            }
        }
    }
}
