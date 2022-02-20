package me.igor.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class AvatarChangeCommand extends ListenerAdapter {

    @Override
    public void onUserUpdateAvatar(@NotNull UserUpdateAvatarEvent event) {

        final String textChannelIdPlayground = "930860696332271689";
        final String textChannelId = "667764000972472323"; //tlusty
        final User user = event.getUser();

        EmbedBuilder builder = new EmbedBuilder()
                .setColor(0xFF4A4A)
                .setAuthor(user.getName(), event.getOldAvatarUrl(), event.getOldAvatarUrl())
                .setDescription("**Zmienił avatar ---------->**")
                .setThumbnail(event.getNewAvatarUrl());

        event.getJDA().getTextChannelById(textChannelId).sendMessageEmbeds(builder.build()).queue();

    }
}
