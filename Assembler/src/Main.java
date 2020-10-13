import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Encryptor encryptor = new Encryptor();
        try {
            encryptor.performEncryption();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Assembly codes generated.");
    }
}
