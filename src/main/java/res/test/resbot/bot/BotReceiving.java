package res.test.resbot.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import res.test.resbot.repository.CityRepository;

@Component
@RequiredArgsConstructor
public class BotReceiving extends TelegramLongPollingBot {

    private static final String NOT_FOUND = "Такого города нет, но скоро будет :)";
    private static final String BOT_TOKEN = "Token";
    private static final String BOT_NAME = "Name";

    private final CityRepository cityRepository;

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    private void sendMsg(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(getCityDescription(message.toLowerCase()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String getCityDescription(String cityName) {
        return cityRepository.findByName(cityName) != null ? cityRepository.findByName(cityName).getDescription() : NOT_FOUND;
    }
}
