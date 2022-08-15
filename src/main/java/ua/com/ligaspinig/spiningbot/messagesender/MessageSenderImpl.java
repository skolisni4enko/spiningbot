package ua.com.ligaspinig.spiningbot.messagesender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.com.ligaspinig.spiningbot.services.TelegramBot;

@Service
public class MessageSenderImpl implements MessageSender {
    private TelegramBot telegramBot;
    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setTelegramBot (TelegramBot bot) {
        this.telegramBot = bot;
    }
}
