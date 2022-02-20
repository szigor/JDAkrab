package me.igor.Commands;

import me.igor.BuildCommands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class ServerInfo implements Command {

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if (args.isEmpty()) {
            String imageLink = "https://static.wikia.nocookie.net/spongebob-polska/images/9/9b/Actual-krusty-krab.jpg/revision/latest/scale-to-width-down/250?cb=20150704095618&path-prefix=pl";
            int memberCount = event.getGuild().getMemberCount();

            EmbedBuilder eb = new EmbedBuilder()
                    .setColor(0xFF4A4A)
                    .setAuthor(event.getGuild().getName())
                    .setThumbnail(imageLink)
                    .addField("Właściciel:", event.getGuild().getMember(User.fromId("935863386997149756")).getEffectiveName(), true)
                    .addField("Ilość obecnych klientów:", String.valueOf(memberCount), true)
                    .setDescription("**Jedyna słuszna restauracja w** ***Bikini Dolnym***\n" + "\n **Link do tłustego:** \n" + "https://discord.gg/KGCKuc6");

            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }

    }

    @Override
    public String getCommand() {
        return "serverinfo";
    }
}
