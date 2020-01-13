package res.test.resbot.service.bot.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import res.test.resbot.repository.CityRepository;
import res.test.resbot.service.bot.BotMessageService;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BotMessageServiceImpl implements BotMessageService {

    private static final String NOT_FOUND = "Такого города нет, но скоро будет :)";

    private final CityRepository cityRepository;

    @Override
    public String getResponseMessage(String requestMessage) {
        List<String> cityNames = cityRepository.getNames();
        for (String name : cityNames) {
            if (requestMessage.contains(name)) {
                return cityRepository.getDescriptionByName(name);
            }
        }
        return NOT_FOUND;
    }
}
