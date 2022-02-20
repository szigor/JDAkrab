package me.igor.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;


public class Fortune extends ListenerAdapter{
    final String imageLink = "https://static.wikia.nocookie.net/spongebob-polska/images/9/9b/Actual-krusty-krab.jpg/revision/latest/scale-to-width-down/250?cb=20150704095618&path-prefix=pl";

    double fortune = 278.63;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.length() > 0) {
            fortune += 1.87;
            if (Math.round(fortune) % 500 == 0) {
                event.getChannel().sendMessage("Przekroczyliśmy **" + Math.round(fortune) + "$** !!").queue();
            }
        }
        if (messageSent.equalsIgnoreCase("!fortune")) {
            EmbedBuilder builder = new EmbedBuilder()
                    .setColor(0xFF4A4A)
                    .setAuthor(event.getGuild().getName())
                    .setThumbnail(imageLink)
                    .addField("Majątek Tłustego Kraba:", Math.round(fortune * 100.0)/100.0 + "$",true);
            event.getChannel().sendMessageEmbeds(builder.build()).queue();
        }
    }
}
