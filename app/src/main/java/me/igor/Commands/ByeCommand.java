package me.igor.Commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ByeCommand extends ListenerAdapter {
    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {

        User user = event.getUser();

//        user.openPrivateChannel().queue(ch -> {
//            ch.sendMessage("Żegnam.").queue();
//            ch.sendMessage("Jakby co to masz tu linka: https://discord.gg/KGCKuc6").queue();
//        });

        if ((event.getGuild().getDefaultChannel()) != null) {
            event.getGuild().getDefaultChannel().sendMessage("__**" + user.getName() + "**__ opuścił **Tłustego Kraba**").queue();
        }
    }
}
