package me.igor.Commands;

import me.igor.BuildCommands.Command;
import me.igor.BuildCommands.Tools;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserInfo implements Command {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if (args.isEmpty()) {
            Member selfuser = event.getGuild().getSelfMember();
            Member target = event.getMessage().getMember();
            EmbedBuilder targetInfo = new EmbedBuilder()
                    .setColor(0xFF4A4A)
                    .setAuthor(target.getUser().getName(), target.getUser().getAvatarUrl(), target.getUser().getEffectiveAvatarUrl())
                    .setDescription("**Tag**: " + target.getUser().getAsTag() + "\n**ID**: " + target.getIdLong())
                    .setThumbnail(target.getUser().getEffectiveAvatarUrl())
                    .addField("Dołączył do serwera: ", target.getTimeJoined().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), true)
                    .addField("Stworzył konto: ", target.getTimeCreated().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), false);

            event.getChannel().sendMessageEmbeds(targetInfo.build()).queue();
        } else {
            Tools.wrongUsage(event.getChannel(), this);
        }
    }

    @Override
    public String getCommand() {
        return "userinfo";
    }
}
