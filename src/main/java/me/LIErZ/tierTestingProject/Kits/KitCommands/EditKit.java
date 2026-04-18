package me.LIErZ.tierTestingProject.Kits.KitCommands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EditKit implements CommandExecutor {

    private final TierTestingProject tierTestingProject;
    private final ChatColor ItemDuelMenuChatColor;
    private final String ItemDuelMenu;

    public EditKit(TierTestingProject tierTestingProject,  ChatColor ItemDuelMenuChatColor, String ItemDuelMenu) {
        this.tierTestingProject = tierTestingProject;
        this.ItemDuelMenuChatColor = ItemDuelMenuChatColor;
        this.ItemDuelMenu = ItemDuelMenu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 0){
                tierTestingProject.GetHolyMenus().EditKitMenu(player, ItemDuelMenu, ItemDuelMenuChatColor);
            }
        }
        return true;
    }
}
