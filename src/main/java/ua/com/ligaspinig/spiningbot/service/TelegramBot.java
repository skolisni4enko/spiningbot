package ua.com.ligaspinig.spiningbot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.com.ligaspinig.spiningbot.config.BotConfig;
import ua.com.ligaspinig.spiningbot.processor.Processor;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig config;
    private Processor processor;

    public TelegramBot (BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(update.getMessage().getChatId());
//        sendMessage.setText("Шото, блять, не получілось....");
//        try {
//            execute(sendMessage);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
        processor.process(update);
    }
}
