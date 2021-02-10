package omnirio.util;

import java.util.UUID;

public class Utilities {

    public static String generateUniqueID() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

}
