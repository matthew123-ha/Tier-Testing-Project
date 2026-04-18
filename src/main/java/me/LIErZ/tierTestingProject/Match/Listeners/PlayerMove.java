package me.LIErZ.tierTestingProject.Match.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    private final Player player;
    private final Player targetPlayer;

    public PlayerMove(Player player, Player targetPlayer) {
        this.player = player;
        this.targetPlayer = targetPlayer;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        if (player.equals(e.getPlayer()) || targetPlayer.equals(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
