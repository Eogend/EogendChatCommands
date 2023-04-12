package fr.lavapower.eogendchatcommands;

import fr.lavapower.eogendchatcommands.command.ReloadChatCommands;
import fr.lavapower.eogendchatcommands.listener.CCListener;
import fr.lavapower.eogendchatcommands.manager.CCManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public class EogendChatCommands extends JavaPlugin {
    private CCManager ccManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        registerCommand("reloadchatcommands", new ReloadChatCommands(this));

        getServer().getPluginManager().registerEvents(new CCListener(this), this);

        ccManager = new CCManager(this, getConfig());

        Bukkit.getScheduler().runTaskLater(this, this::reload, 40);
    }

    public void reload() {
        reloadConfig();
        ccManager.reload(getConfig());
    }

    private <T extends TabCompleter & CommandExecutor> void registerCommand(String name, T commandInstance)
    {
        PluginCommand command = getCommand(name);
        command.setExecutor(commandInstance);
        command.setTabCompleter(commandInstance);
    }

    public CCManager getCcManager() {
        return ccManager;
    }
}
