package Project;

public enum CommandType {
    ENCRYPT,
    DECRYPT,
    BRUTE_FORCE;

    public static CommandType fromStr(String value){
        return CommandType.valueOf(value.toUpperCase());

    }
}
