import java.util.Arrays;

public class day5 {
    private static int codeFinder(int[] opCodes) {

        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                System.out.println(i+" , "+j);
                int output = calculationEngine(opCodes, i, j);
                if (output == 19690720) {
                    return (i*100)+j;
                }
            }
        }
        return -1;
    }

    private static int opCode1 (int[] tempOpCodes, int i) {
        return tempOpCodes[tempOpCodes[i+1]] + tempOpCodes[tempOpCodes[i+2]];
    }

    private static int opCode2 (int[] tempOpCodes, int i) {
        return tempOpCodes[tempOpCodes[i+1]] * tempOpCodes[tempOpCodes[i+2]];
    }

    private static int calculationEngine(int[] opCodes, int noun, int verb) {
        int[] tempOpCodes = Arrays.copyOf(opCodes, opCodes.length);

        tempOpCodes[1] = noun;
        tempOpCodes[2] = verb;

        for (int i = 0; i < tempOpCodes.length; ++i) {
            if (tempOpCodes[i] == 99) {
                break;
            }
            if (tempOpCodes[i] == 1) {
                tempOpCodes[tempOpCodes[i+3]] = opCode1(tempOpCodes, i);
                i += 3;
                continue;
            }
            if (tempOpCodes[i] == 2) {
                tempOpCodes[tempOpCodes[i+3]] = opCode2(tempOpCodes, i);
                i += 3;
                continue;
            }
        }
        return tempOpCodes[0];
    }

    private static void diagnosticEngine(int[] opCodes, int input) {
        int[] tempOpCodes = Arrays.copyOf(opCodes, opCodes.length);

        for (int i = 0; i < tempOpCodes.length; ++i) {
            System.out.println("Index "+i);
            if (tempOpCodes[i] == 99) {
                break;
            }
            if (tempOpCodes[i] == 1) {
                System.out.println("Opcode 1...");
                tempOpCodes[tempOpCodes[i + 3]] = opCode1(tempOpCodes, i);
                i += 3;
                continue;
            }
            if (tempOpCodes[i] == 2) {
                System.out.println("Opcode 2...");
                tempOpCodes[tempOpCodes[i + 3]] = opCode2(tempOpCodes, i);
                i += 3;
                continue;
            }
            if (tempOpCodes[i] == 3) {
                tempOpCodes[tempOpCodes[i + 1]] = input;
                i++;
                continue;
            }
            if (tempOpCodes[i] == 4) {
                System.out.println("Opcode 4 output: "+tempOpCodes[ tempOpCodes[i+1]]);
                i++;
                continue;
            }
            if (tempOpCodes[i] > 99) {
                char[] codeArray = Integer.toString(tempOpCodes[i]).toCharArray();
                int opCode = codeArray[codeArray.length-1]+codeArray[codeArray.length];
            }
        }
    }

    public static void main(String[] args) {
        int[] opCodes = new int[] {1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 13, 1, 19, 1, 9, 19, 23, 2, 23, 13, 27, 1, 27, 9, 31, 2, 31, 6, 35, 1, 5, 35, 39, 1, 10, 39, 43, 2, 43, 6, 47, 1, 10, 47, 51, 2, 6, 51, 55, 1, 5, 55, 59, 1, 59, 9, 63, 1, 13, 63, 67, 2, 6, 67, 71, 1, 5, 71, 75, 2, 6, 75, 79, 2, 79, 6, 83, 1, 13, 83, 87, 1, 9, 87, 91, 1, 9, 91, 95, 1, 5, 95, 99, 1, 5, 99, 103, 2, 13, 103, 107, 1, 6, 107, 111, 1, 9, 111, 115, 2, 6, 115, 119, 1, 13, 119, 123, 1, 123, 6, 127, 1, 127, 5, 131, 2, 10, 131, 135, 2, 135, 10, 139, 1, 13, 139, 143, 1, 10, 143, 147, 1, 2, 147, 151, 1, 6, 151, 0, 99, 2, 14, 0, 0};
        int[] testCase1 = new int[] {1,9,10,3,2,3,11,0,99,30,40,50};
//        System.out.println("Result part I: "+calculationEngine(opCodes, 12, 2));
//        System.out.println("Result part II: "+codeFinder(opCodes));

//        diagnosticEngine(customReader.customInputReader("input_day5_1"), 1);
        int[] testCase2 = new int[] {3,0,4,0,99};
//        diagnosticEngine(testCase2, 1);
//        diagnosticEngine(customReader.customInputReader("inputTest_day5_1"), 1);
    }
}
