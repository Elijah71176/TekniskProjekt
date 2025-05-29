package se.elijah.tekniskProjekt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.elijah.tekniskProjekt.Model.HockeyPlayer;
import se.elijah.tekniskProjekt.Model.HockeyPlayerRepository;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private HockeyPlayerRepository hockeyPlayerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (hockeyPlayerRepository.count() == 0) {
            HockeyPlayer hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(30);
            hockeyPlayer.setName("Elijah");
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(43);
            hockeyPlayer.setName("Tony");
            hockeyPlayerRepository.save(hockeyPlayer);

        }
    }
}
