package com.paloit.controller.user.util;

import com.paloit.controller.user.model.User;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class UserHelper {

    private static final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static User generateUser() {
        var user = new User();
        user.setId(
            generateRandomUserId()
        );
        user.setUsername("palo-" + UUID.randomUUID().toString().substring(25));
        user.setFirstName(generateRandomLetter() + "ichael");
        user.setLastName(generateRandomLetter () + "ackson");
        user.setEmail(
            String.format("%s.%s@palo-it.com", user.getFirstName(), user.getLastName())
        );

        return user;
    }

    public static long generateRandomUserId() {
        var min = 0;
        var max = Long.valueOf(Integer.MAX_VALUE);
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public static char generateRandomLetter() {
        return lexicon.charAt(
            ThreadLocalRandom.current().nextInt(0, lexicon.length())
        );
    }

}
