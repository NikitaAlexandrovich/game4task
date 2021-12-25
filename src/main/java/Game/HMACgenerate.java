package Game;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.List;

public class HMACgenerate {
    private final int move;
    private String HMAC;
    private final String key;

    public HMACgenerate(List<String> moves) {
        key = generateHMACKey();
        move = generateMove(moves);
        try {
            HMAC = encode(key, moves.get(move));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getKey() {
        return key;
    }

    public int getMove() {
        return move;
    }

    public String getHmac() {
        return HMAC;
    }

    public static String encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        StringBuilder formatted = new StringBuilder();
        byte[] bytes = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        for (byte b : bytes) {
            formatted.append(String.format("%x", b));
        }
        return formatted.toString();
    }

    private String generateHMACKey() {
        SecureRandom random = new SecureRandom();
        byte[] num = new byte[16];
        random.nextBytes(num);
        StringBuilder formatted = new StringBuilder();
        for (byte b : num) {
            formatted.append(String.format("%x", b));
        }
        formatted = new StringBuilder(formatted.toString().toUpperCase());
        return formatted.toString();
    }

    private int generateMove(List<String> moves) {
        SecureRandom random = new SecureRandom();
        return random.nextInt(moves.size());
    }
}
