package Project.Runner;

import Project.Cipher.BruteForceAction;
import Project.Cipher.CaesarCipherAction;
import Project.Cipher.DecryptionAction;
import Project.Cipher.EncryptionAction;
import Project.CommandType;
import Project.Exception.InvalidFileContentException;
import Project.Exception.InvalidKeyException;
import Project.Exception.WrongFilePathException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

import static Project.CommandType.*;
import static Project.Constants.*;
import static Project.Util.CipherKeyValidatorUtil.isArgumentsValid;


public class Runner {
    public void run(String[] args) {
        if (args.length < MAX_ALLOWED_ARGS_COUNT) {
            throw new InvalidKeyException("Invalid count arguments");
        }
        CommandType commandType = isArgumentsValid(args[COMMAND_TYPE_ARG_POSITION]);

        String filePath = args[FILE_ARG_POSITION];
        Path path = Path.of(filePath);
        isFileExist(path);

        String content = getFileContent(path);
        if (commandType != BRUTE_FORCE) {

        }

        int key = Integer.parseInt(args[KEY_ARG_POSITION]);
        Map<CommandType, CaesarCipherAction> operations = Map.of(ENCRYPT, new EncryptionAction(key),
                DECRYPT, new DecryptionAction(key),
                BRUTE_FORCE, new BruteForceAction());

        String newContent = operations.get(commandType).execute(content);
        Path newPath =Path.of(newName(commandType,filePath));
        try {
            Files.createFile(newPath);
            Files.writeString(newPath,newContent);
        }catch (IOException e){
            throw new WrongFilePathException("Can`t write file");
        }
    }

    private void isFileExist(Path path) {
        if (Files.notExists(path)) {
            throw new WrongFilePathException("WrongFilePathException");
        }
    }

    private String getFileContent(Path path) {
        try {
            return Files.lines(path).collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new InvalidFileContentException("InvalidFileContentException");
        }
    }

    private String newName(CommandType commandType, String name) {
        int indexPoint = name.lastIndexOf(".");
        return name.substring(0, indexPoint) + "["+commandType.toString()+"]"+name.substring(indexPoint);
    }
}
