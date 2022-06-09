public class MidPointLine {
    public static void main(String[] args) {
        int x_1 = 5;
        int y_1 = 52;
        int x_2 = -5;
        int y_2 = 66;

        int zone = findZone(x_1, y_1, x_2, y_2);
        int[] arr = convertToZone0(x_1, y_1, zone);
        int[] array = new int[4];
        array[0] = arr[0];
        array[1] = arr[1];
        arr = convertToZone0(x_2, y_2, zone);
        array[2] = arr[0];
        array[3] = arr[1];

        System.out.println("X_0\t     Y_0\t     D\t\t  x\t\t\ty");
        midPointline(array[0], array[1], array[2], array[3], zone);
    }

    public static int findZone(int x_1, int y_1, int x_2, int y_2) {
        int dx = x_2 - x_1;
        int dy = y_2 - y_1;
        int zone;

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0 && dy > 0)
                zone = 0;

            else if (dx > 0 && dy < 0)
                zone = 7;

            else if (dx < 0 && dy > 0)
                zone = 3;

            else
                zone = 4;
        }

        else {
            if (dx > 0 && dy > 0)
                zone = 1;

            else if (dx < 0 && dy > 0)
                zone = 2;

            else if (dx < 0 && dy < 0)
                zone = 5;

            else
                zone = 6;
        }
        return zone;
    }

    public static int[] convertToZone0(int x_i, int y_i, int zone) {
        int x = 0;
        int y = 0;

        switch (zone) {
        case 0:
            x = x_i;
            y = y_i;
            break;
        case 1:
            x = y_i;
            y = x_i;
            break;
        case 2:
            x = y_i;
            y = -x_i;
            break;
        case 3:
            x = -x_i;
            y = y_i;
            break;
        case 4:
            x = -x_i;
            y = -y_i;
            break;
        case 5:
            x = -y_i;
            y = -x_i;
            break;
        case 6:
            x = -y_i;
            y = x_i;
            break;
        case 7:
            x = x_i;
            y = -y_i;
            break;
        default:
            System.err.println("Invalid Zone");
            break;
        }
        int[] array = { x, y };
        return array;
    }

    static void midPointline(int x_0, int y_0, int x_1, int y_1, int zone) {
        int dx, dy, incrE, incrNE, d, x, y;

        dx = x_1 - x_0;
        dy = y_1 - y_0;
        d = 2 * dy - dx;
        incrE = 2 * dy;
        incrNE = 2 * (dy - dx);
        x = x_0;

        y = y_0;
        convertToOriginal(x, y, zone, d);

        while (x < x_1) {
            if (d <= 0) {
                // choose E
                d = d + incrE;
                x += 1;
            }

            else {
                // choose NE
                d = d + incrNE;
                x += 1;
                y += 1;
            }

            convertToOriginal(x, y, zone, d); // the selected pixel closest to the line
        }
    }

    static void convertToOriginal(int x_i, int y_i, int zone, int value) {
        int x = 0;
        int y = 0;

        switch (zone) {
        case 0:
            x = x_i;
            y = y_i;
            break;
        case 1:
            x = y_i;
            y = x_i;
            break;
        case 2:
            x = -y_i;
            y = x_i;
            break;
        case 3:
            x = -x_i;
            y = y_i;
            break;
        case 4:
            x = -x_i;
            y = -y_i;
            break;
        case 5:
            x = -y_i;
            y = -x_i;
            break;
        case 6:
            x = y_i;
            y = -x_i;
            break;
        case 7:
            x = x_i;
            y = -y_i;
            break;
        default:
            System.err.println("Invalid Zone");
            break;
        }
        writePixel(x_i, y_i, x, y, value);
    }

    static void writePixel(int x_i, int y_i, int x, int y, int value) {
        System.out.printf("%2d |%7d |%8d |%8d |%8d\n", x_i, y_i, value, x, y);
        System.out.println("----|--------|---------|---------|------------");
    }
}
