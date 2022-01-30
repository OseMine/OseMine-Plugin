package net.osemine.osemineplugin.scoreboard;

import net.osemine.osemineplugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestScoreboard extends ScoreboardBuilder {

    private int socialId;

    public TestScoreboard(Player player) {
        super(player, ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "  twitch.tv/DerBanko  ");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore("test", 8);
        setScore(ChatColor.DARK_GRAY.toString(), 7);
        setScore(ChatColor.GRAY + "Dein Rang" + ChatColor.DARK_GRAY + ":", 6);

        if(player.isOp()) {
            setScore(ChatColor.RED + "Operator", 5);
        } else {
            setScore(ChatColor.GRAY + "Spieler", 5);
        }

        setScore(ChatColor.GRAY.toString(), 4);
        setScore(ChatColor.AQUA + "twitter.com/DerBanko", 3);
        setScore(ChatColor.RED.toString(), 2);
        setScore(ChatColor.RED + player.getAddress().getHostName(), 1);
        setScore(ChatColor.AQUA.toString(), 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                switch (socialId) {
                    case 0:
                        setScore(ChatColor.AQUA + "OseMine´s Server", 3);
                        break;
                    case 1:
                        setScore(ChatColor.BLACK + "OseMine´s Server", 3);
                        break;
                    case 2:
                        setScore(ChatColor.DARK_RED + "OseMine´s Server", 3);
                        break;
                }

                socialId++;

                if(socialId >= 3) {
                    socialId = 0;
                }

            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}
