package res.test.resbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import res.test.resbot.entity.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    void deleteByName(String name);

    @Query("select c.name from City c")
    List<String> getNames();

    @Query("select c.description from City c where c.name = :name")
    String getDescriptionByName(@Param("name") String name);
}
