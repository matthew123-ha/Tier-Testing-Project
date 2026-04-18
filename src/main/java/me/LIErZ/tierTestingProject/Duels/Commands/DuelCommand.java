package me.LIErZ.tierTestingProject.Duels.Commands;

import me.LIErZ.tierTestingProject.TierTestingProject;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DuelCommand implements CommandExecutor {

    private final TierTestingProject tierTestingProject;

    public DuelCommand(TierTestingProject tierTestingProject) {
        this.tierTestingProject = tierTestingProject;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if (strings.length == 0)
                tierTestingProject.GetHolyMenus().DuelMenu(player);
        }
        return true;
    }
}
