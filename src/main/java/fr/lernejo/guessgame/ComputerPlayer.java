package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {

    private long min = 0;
    private long max = 100;
    private long n = 100;
    private final Logger logger = LoggerFactory.getLogger("compute");

    @Override
    public long askNextGuess() {
        logger.log("Nombre :");
        this.n = min + ((max - min) / 2);
        logger.log("Vous avez choisi : " + n);
        return this.n;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log((lowerOrGreater) ? "Le nombre est plus petit" : "Le nombre est plus grand");
        if (lowerOrGreater) {
            this.max = this.n;
        } else {
            this.min = this.n;
        }
    }
}
