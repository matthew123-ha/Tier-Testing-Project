package me.LIErZ.tierTestingProject.Commands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class add3 implements CommandExecutor {

    private TierTestingProject tierTestingProject;

    public add3(TierTestingProject tierTestingProject){
        this.tierTestingProject = tierTestingProject;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            int add = tierTestingProject.getConfig().getInt(player.getDisplayName());

            add += Integer.parseInt(strings[0]);

            tierTestingProject.getConfig().set(player.getDisplayName(), add);

            tierTestingProject.saveConfig();
        }

        return true;
    }
}
