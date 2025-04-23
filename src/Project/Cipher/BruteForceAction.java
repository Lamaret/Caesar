package Project.Cipher;


import Project.CommandType;

public class BruteForceAction extends CaesarCipherAction {
    private final CaesarCipher cipher = new CaesarCipher();

    @Override
    public String execute(String text) {
        return cipher.shiftText(text, 1, CommandType.BRUTE_FORCE);
    }
}


