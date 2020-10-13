class Utils {

    static String convertRegisterToBinary(String register) {
        int length = register.length();
        if (register.charAt(length - 1) == ',') {
            register = register.substring(0, length - 1);
        }
        register = register.substring(1);
        int registerValue = Integer.parseInt(register);
        return enlarge(Integer.toBinaryString(registerValue), 4);
    }

    static String optimise(String string, int length, boolean isNegative) {
        return isNegative ? shrink(string, length) : enlarge(string, length);
    }

    private static String shrink(String string, int shrinkRate) {
        if (shrinkRate >= string.length()) return null;
        return string.substring(string.length() - shrinkRate);
    }

    private static String enlarge(String string, int enlargeRate) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < enlargeRate - string.length(); ++i) {
            stringBuilder.insert(0, "0");
        }
        return stringBuilder.toString();
    }

}
