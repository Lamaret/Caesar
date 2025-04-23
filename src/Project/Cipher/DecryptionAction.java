package Project.Cipher;

import Project.CommandType;

public class DecryptionAction extends CaesarCipherAction {
    private final int key;
    private final CaesarCipher cipher = new CaesarCipher();
    public DecryptionAction(int key) {
        this.key = key;
    }

    @Override
    public String execute(String text) {
        return cipher.shiftText(text, -key, CommandType.DECRYPT);
    }
}
