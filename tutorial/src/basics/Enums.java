/*
Created and maintained by Soroush Zamani
Summer and Fall 2019
Department of Computing and Software
McMaster University
 */
/*
An enum is a special type of data type which is basically a
collection (set) of constants.
 */

package basics;

enum Directions {
    EAST,
    WEST,
    NORTH,
    SOUTH
}

enum Provinces{
    Ontario ("ON"), // This calls the enum constructor
    Quebec ("QC"), // This calls the enum constructor too
    BritishColumbia ("BC"); // This also calls the enum constructor

    private final String shortCode;

    Provinces(String code) {
        System.out.println("This is called: " + code);
        this.shortCode = code;
    }

    public String getProvinceCode() {
        System.out.println("Called!");
        return this.shortCode;
    }
}

public class Enums {
    public Enums() {
        Directions dir = Directions.EAST;

        switch (dir) {
            case EAST:
                System.out.println("Let's go EAST!");
                break;
            case WEST:
                System.out.println("Let's go EAST!");
                break;
            case NORTH:
                System.out.println("Let's go EAST!");
                break;
            case SOUTH:
                System.out.println("Let's go EAST!");
                break;
            default:
                System.out.println("Let's go nowhere");
                break;
        }

        System.out.println();

        // Iterate over enum values:
        for (Directions direction : Directions.values())
            System.out.println(direction);

        System.out.println();

        Provinces province = Provinces.Ontario;
        System.out.println(province.getProvinceCode());
    }

    public static void main(String[] args) {
        new Enums();
    }
}
