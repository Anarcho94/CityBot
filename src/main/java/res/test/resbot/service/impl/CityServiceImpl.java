package res.test.resbot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import res.test.resbot.dto.CityDto;
import res.test.resbot.entity.City;
import res.test.resbot.repository.CityRepository;
import res.test.resbot.service.CityService;
import res.test.resbot.service.resolvers.CityDtoResolver;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityDtoResolver cityDtoResolver;

    @Override
    public void add(CityDto cityDto) {
        cityRepository.save(cityDtoResolver.resolveCityDto(cityDto));
    }

    @Override
    public void update(CityDto cityDto) {
        City updatedCity = cityRepository.findByName(cityDto.getName().toLowerCase());
        updatedCity.setDescription(cityDto.getDescription());
        cityRepository.save(updatedCity);
    }

    @Override
    public void delete(String cityName) {
        cityRepository.deleteByName(cityName.toLowerCase());
    }
}
