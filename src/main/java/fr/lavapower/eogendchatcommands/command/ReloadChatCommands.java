package fr.lavapower.eogendchatcommands.command;

import fr.lavapower.eogendchatcommands.EogendChatCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ReloadChatCommands implements TabCompleter, CommandExecutor
{
    private final EogendChatCommands plugin;
    public ReloadChatCommands(EogendChatCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        plugin.reload();
        sender.sendMessage("Reload fait !");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        return new ArrayList<>();
    }
}