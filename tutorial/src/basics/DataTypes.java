package basics;// There are two kinds of data types in Java. Primitive and non-primitive
// Primitives include int, short, byte, long, double, char, boolean, etc.
// Non-primitives include everything else, i.e. objects

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTypes {

    public DataTypes() {
//        // byte range is between -128 to 127 (8 bit signed number)
//        byte num = 127;
////        byte num2 = 128; // 128 cannot be filled in a byte
//        System.out.println(num);
//        num += 1;
//        System.out.println(num); // Overflow happens

//        // long is 8 bytes
//        long bigNum = 9223372036854775807L;

//        float realNum = 19.42f;
//        // if you don't put f at the end of number, it's considered as double
//        float realNum2 = 19.42;

//        // Primitives must be initialized to be usable
//        boolean bool;
//        int num;
//        if (num == 1)
//            System.out.println("Initialized!");
//        System.out.println(bool);

        ////////////////////////////////////////////////////////////////

        // We'll talk more about arrays and other non-primitives later
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> intList = new ArrayList<>();
        Map<String, String> stringMap = new HashMap<>();
    }

    public static void main(String[] args) {
        new DataTypes();
    }
}
