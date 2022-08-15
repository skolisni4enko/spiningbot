package ua.com.ligaspinig.spiningbot.processors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import ua.com.ligaspinig.spiningbot.handlers.CallBackQueryHandler;
import ua.com.ligaspinig.spiningbot.handlers.MessageHandler;

@Component
public class DefaultProcessor implements Processor {

    private final CallBackQueryHandler callBackQueryHandler;
    private final MessageHandler messageHandler;

    public DefaultProcessor(CallBackQueryHandler callBackQueryHandler, MessageHandler messageHandler) {
        this.callBackQueryHandler = callBackQueryHandler;
        this.messageHandler = messageHandler;
    }

    @Override
    public void executeMessage(Message message) {
        messageHandler.choose(message);

    }

    @Override
    public void executeCallBackQuery(CallbackQuery callbackQuery) {
        callBackQueryHandler.choose(callbackQuery);
    }
}
