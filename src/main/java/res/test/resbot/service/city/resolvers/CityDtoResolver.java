package res.test.resbot.service.city.resolvers;

import org.springframework.stereotype.Component;
import res.test.resbot.dto.CityDto;
import res.test.resbot.entity.City;

@Component
public class CityDtoResolver {

    public City resolveCityDto(CityDto cityDto){
        City city = new City();
        city.setName(cityDto.getName().toLowerCase());
        city.setDescription(cityDto.getDescription());
        return city;
    }
}
