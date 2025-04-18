package Project.Util;

import Project.CommandType;
import Project.Exception.InvalidKeyException;

import static Project.Constants.accessKey;

public class CipherKeyValidatorUtil {
    public static CommandType isArgumentsValid(String commandStr) {
        if (!accessKey.contains(commandStr.toUpperCase())) {
            throw new InvalidKeyException("InvalidKeyException");
        } else {
            return CommandType.fromStr(commandStr);
        }
    }
}
