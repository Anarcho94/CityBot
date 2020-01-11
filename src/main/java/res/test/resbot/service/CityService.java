package res.test.resbot.service;

import res.test.resbot.dto.CityDto;

public interface CityService {

    void add(CityDto cityDto);

    void update(CityDto cityDto);

    void delete(String cityName);
}
