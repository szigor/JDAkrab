package me.igor;

import me.igor.BuildCommands.Listener;
import me.igor.Commands.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {
    private Bot() throws LoginException {

        JDABuilder.createDefault(
                        Config.get("token"),
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_VOICE_STATES
                )
                .enableCache(CacheFlag.VOICE_STATE)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(
                        new Fortune(),
                        new PingCommand(),
                        new WelcomeCommand(),
                        new ByeCommand(),
                        new AvatarChangeCommand(),
                        new Listener()
                )
                .setActivity(Activity.watching("ciebie"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();
    }
    public static void main(String[] args) throws LoginException {
        new Bot();
    }
}