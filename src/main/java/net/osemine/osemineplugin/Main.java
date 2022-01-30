package net.osemine.osemineplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.osemine.osemineplugin.backpack.BackpackManager;
import net.osemine.osemineplugin.commands.BackpackCommand;
import net.osemine.osemineplugin.commands.TimerCommand;
import net.osemine.osemineplugin.listeners.ExplosionListeners;
import net.osemine.osemineplugin.listeners.JoinListener;
import net.osemine.osemineplugin.listeners.QuitListener;
import net.osemine.osemineplugin.timer.Timer;
import net.osemine.osemineplugin.utils.Config;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Timer timer;
    private Config config;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "HALLO!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);
        manager.registerEvents(new ExplosionListeners(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("backpack").setExecutor(new BackpackCommand());

        timer = new Timer();
        backpackManager = new BackpackManager();
    }

    @Override
    public void onDisable() {
        timer.save();
        backpackManager.save();

        config.save();
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public Timer getTimer() {
        return timer;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}
