package us.drullk.memer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import us.drullk.memer.entity.Memer;
import us.drullk.memer.repositories.MemerRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final MemerRepository repository;

    @Autowired
    public DatabaseLoader(MemerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Memer("DrullsTestUser"));

        MemeApplication.LOGGER.info("User Repo Count: " + this.repository.count());
    }
}
