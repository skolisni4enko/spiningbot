package ua.com.ligaspinig.spiningbot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class CallBackQueryHandler implements Handler<CallbackQuery> {
    @Override
    public void choose(CallbackQuery callbackQuery) {

    }
}
