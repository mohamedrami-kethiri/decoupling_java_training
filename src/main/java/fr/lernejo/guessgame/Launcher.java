package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        String firstArg = (args.length >= 1) ? args[0] : "";
        Simulation s;
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        if (firstArg.equals("-auto")) {
            s = new Simulation(new ComputerPlayer());
            int secondArg = Integer.parseInt(args[1]);
            s.initialize(randomNumber);
            s.loopUntilPlayerSucceed(Math.min(secondArg, 1000));
        } else if (firstArg.equals("-interactive")) {
            s = new Simulation(new HumanPlayer());
            s.initialize(randomNumber);
            s.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else {
            System.out.println("Argument incorrect ou manquant");
        }
    }
}
