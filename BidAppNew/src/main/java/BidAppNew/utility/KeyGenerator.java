package BidAppNew.utility;

import java.util.UUID;

public class KeyGenerator {
    public static String getEntityId() {
        return UUID.randomUUID().toString();
    }
}
