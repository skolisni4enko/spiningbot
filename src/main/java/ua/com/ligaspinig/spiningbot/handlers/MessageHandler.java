package ua.com.ligaspinig.spiningbot.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ua.com.ligaspinig.spiningbot.config.Constants;
import ua.com.ligaspinig.spiningbot.messagesender.MessageSender;

import java.util.ArrayList;

@Component
public class MessageHandler implements Handler<Message> {
    private MessageSender messageSender;

    @Autowired
    public void setMessageSender(@Lazy MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(Message message) {
        if (message.hasText()) {
            SendMessage sendMessage = new SendMessage();
            sendMessage.setParseMode("HTML");
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            String text = message.getText();
            switch (text) {
                case "/start" -> {
//                new SaveUserService(message);// USER SAVE
                    sendMessage.setReplyMarkup(createReplyKeyboardMarkupOnStart());
                    sendMessage.setParseMode("HTML");
                    sendMessage.setText(Constants.START_TEXT);
                }
                default -> {
                    sendMessage.setParseMode("HTML");
                    sendMessage.setText("Руський воєнний корабль, іди нах...");
                }
            }
            sendMessage.setParseMode("HTML");
            messageSender.sendMessage(sendMessage);
        }
    }

    // create keyboard on start
    public ReplyKeyboardMarkup createReplyKeyboardMarkupOnStart() {
        var markup = new ReplyKeyboardMarkup();
        var keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        KeyboardRow row4 = new KeyboardRow();

        row1.add("ТУР1");
        row1.add("ТУР2");
        row1.add("ТУР3");

        row2.add("Личка ТУР1");
        row2.add("Личка ТУР1+2");
        row2.add(Constants.BUTTON_PERSONAL_FINISH);

        row3.add("Коман.Тур1");
        row3.add("Коман.Тур1+2");
        row3.add(Constants.BUTTON_TEAM_FINISH);

        row4.add("Жеребьёвка");
        row4.add(Constants.BUTTON_STATISTIC);

        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);
        keyboardRows.add(row4);

        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);

        return markup;
    }
}
