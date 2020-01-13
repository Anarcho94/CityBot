package res.test.resbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import res.test.resbot.dto.CityDto;
import res.test.resbot.service.city.CityService;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/add")
   public void add(@RequestBody CityDto cityDto) {
        cityService.add(cityDto);
    }

    @PostMapping("/update")
   public void update(@RequestBody CityDto cityDto) {
        cityService.update(cityDto);
    }

    @DeleteMapping("/delete/{cityName}")
    public void delete(@PathVariable String cityName){
        cityService.delete(cityName);
    }
}
