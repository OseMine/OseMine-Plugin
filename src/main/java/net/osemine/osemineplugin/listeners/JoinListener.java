package net.osemine.osemineplugin.listeners;

import net.osemine.osemineplugin.scoreboard.TestScoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.GREEN.toString() + ChatColor.UNDERLINE + player.getName() + " ist nun anwesend.");

        player.sendMessage(ChatColor.GOLD + "Willkommen auf dem Server! \n\"Viel Spaß und viel Vergnügen (^:");

        new TestScoreboard(player);
    }
}
