package us.drullk.memer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import us.drullk.memer.entity.Memer;

import java.util.Optional;

// TODO later in Learning: Test if JpaRepository works
public interface MemerRepository extends CrudRepository<Memer, Long> {
    // TODO Any additional functionality: https://www.baeldung.com/spring-data-jpa-method-in-all-repositories

    Optional<Memer> findByDisplayName(@Param("name") String name);
}
