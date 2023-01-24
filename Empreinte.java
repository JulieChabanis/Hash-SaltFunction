import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

public class Empreinte {


    public static final Random r = new Random();
    public static final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String getSalt(int taille) {
        String s = "";
        for (int i = 0; i < taille; i++) {
            s +=alphabet.charAt(r.nextInt(alphabet.length()));
        } 
        return s;
    }

    public String getHash(String toHash){
        return DigestUtils.sha256Hex(toHash);
    }

    public String getHashSalt(String toHashSalt, String salt){
        return getHash(toHashSalt + salt);
    }

    public boolean isValidPassword(String hash, String password, String salt){
        return (getHash(password + salt).equals(hash));
    }

    public void test(String s ){
        System.out.println("mot de passe : " + s);
        System.out.println("hash du mot de passe généré : " + getHash(s));
        String salt = getSalt(64);
        System.out.println("sel généré  : " + salt);
        System.out.println("mot de passe haché et salé : " + getHashSalt(s, salt) );
    }

}