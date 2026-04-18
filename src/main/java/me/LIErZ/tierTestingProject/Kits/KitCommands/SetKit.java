package me.LIErZ.tierTestingProject.Kits.KitCommands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SetKit implements CommandExecutor {

    private final TierTestingProject tierTestingProject;
    private final ChatColor ItemDuelMenuChatColor;
    private final String SetKitString;

    public SetKit(TierTestingProject tierTestingProject, ChatColor ItemDuelMenuChatColor, String SetKitString) {
        this.tierTestingProject = tierTestingProject;
        this.ItemDuelMenuChatColor = ItemDuelMenuChatColor;
        this.SetKitString = SetKitString;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 1){
                switch (args[0]){
                    case "InQueueCrystal" -> Set(player, "InQueueCrystal");
                    case "InQueueSword" -> Set(player, "InQueueSword");
                    case "InQueueAxe" -> Set(player, "InQueueAxe");
                    case "InQueueMace" -> Set(player, "InQueueMace");
                    case "InQueueUHC" -> Set(player, "InQueueUHC");
                    case "InQueueNetherite" -> Set(player, "InQueueNetherite");
                    case "InQueueSMP" -> Set(player, "InQueueSMP");
                    case "InQueuePot" -> Set(player, "InQueuePot");
                    case "InQueueDiamondSMP" -> Set(player, "InQueueDiamondSMP");
                }
            }
            else if (args.length == 0){
                tierTestingProject.GetHolyMenus().EditKitMenu(player, SetKitString, ItemDuelMenuChatColor);
            }
        }
        return true;
    }

    private void Set(Player player, String string){
        for (int i = 0; i <= 40; i++){
            ItemStack itemStack = player.getInventory().getItem(i);
            if (itemStack != null){
                tierTestingProject.getConfig().set(string + "." + i, itemStack);
                tierTestingProject.saveConfig();
            }
        }
    }
}
