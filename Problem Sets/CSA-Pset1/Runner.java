import java.util.Scanner;
public class Runner {
	public static void main(String[] args) {
		Point point = new Point();
		Point point2 = new Point(6, 7);
		Point point3 = new Point(6, 10);

		System.out.println(point2);
		System.out.println(point2.equals(point3));
		System.out.println(point2.getX());
		System.out.println(point2.getY());

		System.out.println(point2.slopeTo(point3));

		point2.setX(0.67);
		point2.setY(1.62);

        System.out.println("End Point Tests\n\n");
        ///////////////////////////////////////////////////

        Point a = new Point(0, 10);
        Point b = new Point(1, 10);
        Point c = new Point(0, 0);
        Point d = new Point(10, 0);

        Rectangle r1 = new Rectangle(a, b, c, d);
        Rectangle r2 = new Rectangle(new Point(5, 8), new Point(15, 8), new Point(5, -2), new Point(15, -2));
        Rectangle r3 = new Rectangle(new Point(20, 10), new Point(30, 10), new Point(20, 0), new Point(30, 0));
        Rectangle r4 = new Rectangle(new Point(0, 5), new Point(5, 5), new Point(0, 0), new Point(5, 0));

        System.out.println(r1);

        System.out.println(r1.equals(r2));
        System.out.println(r1.equals(r1));

        System.out.println(r1.isOverlapping(r2));
        System.out.println(r1.isOverlapping(r3));

        System.out.println(r1.getArea());

        System.out.println(r1.isSquare());
        System.out.println(r4.isSquare());

        System.out.println(r1.isValid());
        
        System.out.println("End Rect Tests\n\n");
        ///////////////////////////////////////////////////////////////////

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter medical record name: ");
        MedicalRecord rec1 = new MedicalRecord(scanner.nextLine());
        MedicalRecord rec2 = new MedicalRecord("67");

        System.out.println(rec1);
        System.out.println(rec2);
        System.out.println(rec1.equals(rec2));
        System.out.println(rec1.getName());
        rec1.toggleTranslator();
        System.out.println(rec1);
        System.out.println(rec1.getPatientID());
        System.out.println(MedicalRecord.getNumRecords());

        rec1.clearRecord();
        System.out.println(rec1);

        System.out.println("End MedicalRecord Tests\n\n");

	}
}