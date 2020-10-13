import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Encryptor {

    private ISA ISAObject = ISA.getInstance();

    void performEncryption() throws IOException {
        Scanner fileReader = new Scanner(new File("input.txt"));
        FileWriter fileWriter = new FileWriter(new File("output.txt"));
        StringBuilder writeData;
        String[] dataLine;
        while (fileReader.hasNextLine()) {
            writeData = new StringBuilder("00");
            dataLine = fileReader.nextLine().split(" ");
            String opCode = ISAObject.ISACodeMap.get(dataLine[0]);
            writeData.append(opCode);
            int opCodeValue = Integer.parseInt(opCode, 2);
            if (opCodeValue >= 0 && opCodeValue < 4) {
                for (int i = 1; i < dataLine.length; ++i) {
                    writeData.append(Utils.convertRegisterToBinary(dataLine[i]));
                }
                writeData.append("00");
            } else if (opCodeValue >= 4 && opCodeValue < 8) {
                writeData.append(Utils.convertRegisterToBinary(dataLine[1]));
                writeData.append(Utils.convertRegisterToBinary(dataLine[2]));
                writeData.append(Utils.optimise(Integer.toBinaryString(Integer.parseInt(dataLine[3])), 6,
                        dataLine[3].charAt(0) == '-'));
            } else if (opCodeValue == 8) {
                writeData.append(Utils.optimise(Integer.toBinaryString(Integer.parseInt(dataLine[1])), 10,
                        dataLine[1].charAt(0) == '-'));
                writeData.append("0000");
            } else if (opCodeValue >= 9 && opCodeValue < 11) {
                writeData.append(Utils.convertRegisterToBinary(dataLine[1]));
                writeData.append(Utils.optimise(Integer.toBinaryString(Integer.parseInt(dataLine[2])), 10,
                        dataLine[2].charAt(0) == '-'));
            } else if (opCodeValue >= 11 && opCodeValue < 16) {
                writeData.append(Utils.convertRegisterToBinary(dataLine[1]));
                writeData.append(Utils.convertRegisterToBinary(dataLine[2]));
                writeData.append(Utils.optimise(Integer.toBinaryString(Integer.parseInt(dataLine[3])), 6,
                        dataLine[3].charAt(0) == '-'));
            }
            fileWriter.write(writeData + " \n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
