package fr.lavapower.eogendchatcommands.listener;

import fr.lavapower.eogendchatcommands.EogendChatCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CCListener implements Listener {
    private final EogendChatCommands plugin;
    public CCListener(EogendChatCommands plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        plugin.getCcManager().trigger(event.getPlayer(), event.getMessage());
    }
}
