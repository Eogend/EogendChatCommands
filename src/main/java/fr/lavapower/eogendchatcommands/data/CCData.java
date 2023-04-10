package fr.lavapower.eogendchatcommands.data;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;

public class CCData {
    private final String chat;
    private final Location location;
    private final int radius;
    private final List<String> commands;

    public CCData(ConfigurationSection section) {
        chat = section.getString("chat");
        location = new Location(Bukkit.getWorld(section.getString("location.world")), section.getInt("location.x"), section.getInt("location.y"), section.getInt("location.z"));
        radius = section.getInt("location.radius");
        commands = section.getStringList("commands");
    }

    public boolean mustBeTrigger(Player player, String message) {
        return message.equals(chat) && player.getWorld() == location.getWorld() && player.getLocation().distance(location) <= radius;
    }

    public List<String> getCommands() {
        return commands;
    }
}
