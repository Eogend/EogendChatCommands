package fr.lavapower.eogendchatcommands.manager;

import fr.lavapower.eogendchatcommands.EogendChatCommands;
import fr.lavapower.eogendchatcommands.data.CCData;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CCManager {
    private final List<CCData> ccDataList;
    private final EogendChatCommands plugin;

    public CCManager(EogendChatCommands plugin, FileConfiguration configuration) {
        this.plugin = plugin;
        ccDataList = new ArrayList<>();
        reload(configuration);
    }

    public void reload(FileConfiguration configuration) {
        ccDataList.clear();
        for(String key: configuration.getKeys(false))
            ccDataList.add(new CCData(configuration.getConfigurationSection(key)));
    }

    public void trigger(Player player, String message) {
        for(CCData data: ccDataList) {
            if(data.mustBeTrigger(player, message))
            {
                Bukkit.getScheduler().runTask(plugin, () -> {
                    for(String command: data.getCommands())
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                });
            }
        }
    }
}
