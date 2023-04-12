//add JDA library: https://github.com/DV8FromTheWorld/JDA/releases

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

import com.example.RandomModel; //example deep learning model (doesn't exist)

public class MyBot extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder.createDefault("DISCORD_BOT_TOKEN")
                .addEventListeners(new MyBot())
                .build();
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        
        if (event.getMessage().getContentRaw().startsWith("!botName")) {
            String request = event.getMessage().getContentRaw().substring(8);
            
            // Random response from Random (nonexistant) deep learning model
            String response = RandomModel.predict(request);
            
            MessageChannel channel = event.getChannel();
            if (channel instanceof TextChannel) {
                ((TextChannel) channel).sendMessage(response).queue();
            }
        }
    }
}
