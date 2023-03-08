package org.sinonhecateii.twitchchatingame;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import org.sinonhecateii.twitchchatingame.ImportantData;

import static org.bukkit.Bukkit.getLogger;

public class getTwitchChat implements Listener {
    public static void main(String[] args) throws Exception {
        ImportantData data = new ImportantData();

        String server = "irc.chat.twitch.tv";
        int port = 6667;
        String nickname = data.nickname;
        String token = data.token;
        String channel = "lol_ambition";

        // Connect to Twitch IRC
        Socket socket = new Socket(server, port);
        OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Authenticate with Twitch IRC using your OAuth token
        writer.write("PASS " + token + "\r\n");
        writer.write("NICK " + nickname + "\r\n");
        writer.flush();

        // Join the specified channel
        writer.write("JOIN #" + channel + "\r\n");
        writer.flush();

        // Read Twitch chat messages
        String line;
        while ((line = reader.readLine()) != null) {
            // Parse Twitch chat message
            String[] parts = line.split(" ");
            if (parts[0].equals("PING")) {
                // Respond to Twitch IRC PING message to keep the connection alive
                writer.write("PONG " + parts[1] + "\r\n");
                writer.flush();
            } else {
                // Handle Twitch chat message
                // The message format is: ":username!username@username.tmi.twitch.tv PRIVMSG #channel :message"
                String[] messageParts = line.split(":", 3);
                if (messageParts.length >= 3) {
                    String username = messageParts[1].split("!")[0];
                    String message = messageParts[2];
                    getLogger().info(username + ": " + message);
                    //Bukkit.broadcastMessage(username + ": " + message);
                }
            }
        }

        // Close the connection to Twitch IRC
        socket.close();
    }
}
