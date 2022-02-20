package me.igor.BuildCommands;

import net.dv8tion.jda.api.entities.TextChannel;

public class Tools {
    public static void wrongUsage(TextChannel tc, Command c) {
        tc.sendMessage("Zła składnia komendy\n").queue();
    }
}
