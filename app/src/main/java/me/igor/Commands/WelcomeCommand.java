package me.igor.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class WelcomeCommand extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        String imageLink = "https://static.wikia.nocookie.net/spongebob-polska/images/9/9b/Actual-krusty-krab.jpg/revision/latest/scale-to-width-down/250?cb=20150704095618&path-prefix=pl";
        Member member = event.getMember();
        int memberCount = event.getGuild().getMemberCount();
        EmbedBuilder builder = new EmbedBuilder()
                .setColor(0xFF4A4A)
                .setAuthor(event.getGuild().getName())
                .setThumbnail(imageLink)
                .addField("Właściciel:", event.getGuild().getMember(User.fromId("935863386997149756")).getEffectiveName(), true)
                .addField("Ilość obecnych klientów:", String.valueOf(memberCount), true)
                .setDescription("**Witamy w najlepszej restauracji w** ***Bikini Dolnym***\n" +
                        "Na serwerze panuje szacuneczek i wysoka kulturka osobista\n" +
                        "Polecam również zaprosić znajomcyh" + "\n **Link do tłustego:** \n" + "https://discord.gg/KGCKuc6");


        if ((event.getGuild().getDefaultChannel()) != null) {
            event.getGuild().getDefaultChannel().sendMessage(member.getAsMention() + " witamy pod ***Tłustym Krabem***!").queue();
            member.getUser().openPrivateChannel().queue(ch -> {
                ch.sendMessageEmbeds(builder.build()).queue();
            });

        }
    }
}

