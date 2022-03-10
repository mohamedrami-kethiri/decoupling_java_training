package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("HumanPlayer");

    @Override
    public long askNextGuess() {
        logger.log("Nombre :");
        try {
            Scanner sc = new Scanner(System.in);
            long number = sc.nextInt();
            sc.nextLine();
            return number;
        } catch(Exception e) {
            logger.log("Erreur !");
            return -1;
        }
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log((lowerOrGreater) ? "Le nombre est plus petit" : "Le nombre est plus grand");
    }
}
