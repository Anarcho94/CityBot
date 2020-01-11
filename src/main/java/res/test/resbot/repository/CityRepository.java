package res.test.resbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import res.test.resbot.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    void deleteByName(String name);
}
