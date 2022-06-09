public class Test
{
    public static void main(String[] args)
    {
        System.out.println("Hey, you!");
        MidPointCircle object1 = new MidPointCircle();

        System.out.println("For center at (3, 0)");
        object1.findMidpointCircle(15);
        System.out.println("For center at (x, y)");
        object1.convertedCenter(-12, 0, 15);
    }
}
