public class MidPointCircle
{

    void findMidpointCircle(int radius)
    {
        int x, y, d;
        d = 1 - radius;
        x = 0;
        y = radius;
        circlePoints(x, y, d);

        while (x < y) {
            if (d < 0) {
                //choose E
                d = d + 2 * x + 3;
                x += 1;
            }
            else {
                // choose SE
                d = d + (2 * x) - (2 * y) + 5;
                x += 1;
                y -= 1;
            }

            circlePoints(x, y, d);
        }
    }

    void circlePoints(int x, int y, int d) {
        System.out.println("In this row d is: " + d);
        System.out.print("At center: "+x+" "+y+" ");
//        writePixel(y, x, 0);
//        writePixel(x, y, 1);
        writePixel(-x, y, 2);
 //     writePixel(-y, x, 3);
//        writePixel(-y, -x, 4);
        //writePixel(-x, -y, 5);
//        writePixel(x, -y, 6);
//        writePixel(y, -x, 7);
    }


    void writePixel (int x, int y, int zone) {
        //System.out.print("At zone: ");
        System.out.print("Zone:0"+zone+"  "+x + "\t\t");
        System.out.print(y + "\t\t");
        x = x+(3);
        y = y+(0);
        System.out.print(" Original: "+x+" "+y);
        System.out.println();
    }

    void convertedCenter(int x_1, int y_1, int radius) {
        int x, y, d;
        d = 1 - radius;
        x = 0;
        y = radius;
        circlePoints(x - x_1, y - y_1, d);

        while (x < y) {
            if (d < 1) {
                //choose E
                d = d + 2 * x + 3;
                x += 1;
            }
            else {
                // choose SE
                d = d + (2 * x) - (2 * y) + 5;
                x += 1;
                y -= 1;
            }

            circlePoints(x - x_1, y - y_1, d);
            //System.out.print(x-x_1+" "+ y-y_1);
        }
    }
}
