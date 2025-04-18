package Project.Cipher;

import static Project.Constants.ENG_ALPHABET;

public class CaesarCipher {
    public String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = ENG_ALPHABET.indexOf(c);
            char returnchar;
            if (index == -1) {
                returnchar = c;
            } else {
                returnchar =ENG_ALPHABET.get((ENG_ALPHABET.size()+index+shift)%ENG_ALPHABET.size());
            }
            result.append(returnchar);
        }
        return result.toString();

    }
}
