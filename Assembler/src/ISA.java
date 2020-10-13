import java.util.HashMap;
import java.util.Map;

class ISA {

    Map<String, String> ISACodeMap;
    private static ISA instance;

    private ISA() {
        ISACodeMap = new HashMap<>();
        initISACodes();
    }

    public static ISA getInstance() {
        if (instance == null) {
            instance = new ISA();
        }
        return instance;
    }

    public void initISACodes() {
        ISACodeMap.put("ADD", "0000");
        ISACodeMap.put("AND", "0001");
        ISACodeMap.put("OR", "0010");
        ISACodeMap.put("XOR", "0011");
        ISACodeMap.put("ADDI", "0100");
        ISACodeMap.put("ANDI", "0101");
        ISACodeMap.put("ORI", "0110");
        ISACodeMap.put("XORI", "0111");
        ISACodeMap.put("JUMP", "1000");
        ISACodeMap.put("LD", "1001");
        ISACodeMap.put("ST", "1010");
        ISACodeMap.put("BEQ", "1011");
        ISACodeMap.put("BLT", "1100");
        ISACodeMap.put("BGT", "1101");
        ISACodeMap.put("BLE", "1110");
        ISACodeMap.put("BGE", "1111");
    }
}
