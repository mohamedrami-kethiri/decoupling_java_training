package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long number = player.askNextGuess();
        if (number == this.numberToGuess) {
            return true;
        } else {
            player.respond(number - this.numberToGuess > 0);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long n) {
        boolean running = false;
        int i = 0;
        long begin = System.currentTimeMillis();
        while (!running && i < n) {
            running = nextRound();
            i += 1;
        }
        long time = (System.currentTimeMillis() - begin);
        logger.log(running ? "Vous avez gagné !" : "Vous avez perdu !");
        logger.log("Temps : "  + new SimpleDateFormat("mm:ss:SSS").format(new Date(time)));
    }
}
