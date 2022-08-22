package ua.com.ligaspinig.spiningbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ua.com.ligaspinig.spiningbot.services.TelegramBot;

@Component
public class BotInitializer {

    @Autowired
    TelegramBot bot;

    private TelegramBotsApi telegramBotsApi;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        try {
            startBotSession(telegramBotsApi);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private TelegramBotsApi startBotSession(TelegramBotsApi telegramBotsApi) throws TelegramApiException {
        if (telegramBotsApi != null)
            return telegramBotsApi;
        else
            return new TelegramBotsApi(DefaultBotSession.class);

    }
}
