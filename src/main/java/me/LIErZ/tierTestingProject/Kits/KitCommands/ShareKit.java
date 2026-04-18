package me.LIErZ.tierTestingProject.Kits.KitCommands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShareKit implements CommandExecutor {

    private final TierTestingProject tierTestingProject;

    public ShareKit(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player){
            if (args.length == 0){
                player.sendMessage("/ShareKit (Player)");
            }
            else if (args.length == 1){
                
            }
        }

        return true;
    }
}
