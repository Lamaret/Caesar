package Project.Cipher;

import Project.CommandType;

import static Project.Constants.ENG_ALPHABET;

public class CaesarCipher {
    public String shiftText(String text, int shift, CommandType commandType) {
        StringBuilder result = new StringBuilder();
        if (commandType == CommandType.ENCRYPT) {
            EncoderKey(shift, result);
        }
        if (commandType == CommandType.BRUTE_FORCE) {
            shift = -DecryptKey(text);
        }
        int ind = 0;
        for (char c : text.toCharArray()) {
            if (commandType != CommandType.ENCRYPT && ind < 2) {
                ind++;
                continue;
            }
            int index = ENG_ALPHABET.indexOf(c);
            char returnchar;
            if (index == -1) {
                returnchar = c;
            } else {
                returnchar = ENG_ALPHABET.get((ENG_ALPHABET.size() + index + shift) % ENG_ALPHABET.size());
            }
            result.append(returnchar);
        }
        return result.toString();

    }

    private void EncoderKey(int number, StringBuilder result) {
        int key = number % ENG_ALPHABET.size();
        String nullOrNot;
        if (key < 10 && key > -10) {
            nullOrNot = "0" + key;
        } else {
            nullOrNot = "" + key;
        }
        for (Character c : nullOrNot.toCharArray()) {
            int num = Integer.parseInt(String.valueOf(c));
            char simbleKey = ENG_ALPHABET.get(num);
            result.append(simbleKey);
        }

    }

    private int DecryptKey(String text) {
        String strKeyEncode = text.substring(0, 2);
        String strKeyDecode = "";
        for (char c : strKeyEncode.toCharArray()) {
            strKeyDecode = strKeyDecode + ENG_ALPHABET.indexOf(c);
        }
        return Integer.parseInt(strKeyDecode);
    }
}
