package ua.com.ligaspinig.spiningbot.services;

import org.springframework.stereotype.Service;
import ua.com.ligaspinig.spiningbot.messagesender.MessageSender;

@Service
public class SendMessageService {
    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}
