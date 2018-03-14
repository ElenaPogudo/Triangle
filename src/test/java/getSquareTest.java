import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class getSquareTest {
    @DataProvider(name = "NormalInputProvider")
    public Object[][] NormalInputProviderData() {
        return new Object[][]
                {
                        {1.0, 1.0, 1.0, Math.sqrt(3)/4},
                        {3.0, 4.0, 5.0, 6.0},
                        {2.0, 2.0, 1.0, Math.sqrt(3.75)*0.5},
                        {5.0, 8.0, 11.0, Math.sqrt(336)},
                        {101.0, 101.0, 101*Math.sqrt(2), 5100.5},
                        {7.0, 7.0, 7*Math.sqrt(2), 24.5},//это выдает ошибку только если сторона 7(см предыдущую строку)

                };
    }
    @DataProvider(name = "WrongDataProvider")
    public Object[][] WrongDataProviderData() {//по логике должен выдавать ошибку, что нельзя посчитать площадь, т к недопустимые значения
        return new Object[][]
                {
                        {0.0, 1.0, 2.0},
                        {0.0, 1.0, 2.0},
                        {-6.0, 1.0, 2.0},
                        {8.0, 0.0, 6.0},
                        {8.0, -4.0, 6.0},
                        {1.0, 1.0, 0.0},
                        {1.0, 1.0, -5.0},
                        {0.0, 0.0, 2.0},
                        {-1.0, -1.0, 2.0},
                        {0.0, 1.0, 0.0},
                        {-1.0, 1.0, -1.0},
                        {1.0, 0.0, 0.0},
                        {1.0, -1.0, -1.0},
                        {0.0, 0.0, 0.0},
                        {-1.0, -1.0, -1.0},
                        {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                        {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                        {Double.MAX_VALUE, 1.0, 1.0},
                        {Double.POSITIVE_INFINITY, 1.0, 1.0},
                        {1.0, Double.MAX_VALUE, 1.0},
                        {1.0, Double.POSITIVE_INFINITY, 1.0},
                        {1.0, 1.0, Double.MAX_VALUE},
                        {1.0, 1.0, Double.POSITIVE_INFINITY},
                        {Double.MAX_VALUE, Double.MAX_VALUE, 1.0},
                        {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0},
                        {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                        {Double.POSITIVE_INFINITY, 1.0, Double.POSITIVE_INFINITY},
                        {1.0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},

                };
    }
    @Test(dataProvider = "NormalInputProvider")
    public void testCheckTriangle(Double a, Double b, Double c, Double Square) {

        Triangle tr = new Triangle(a,b,c);
        Assert.assertEquals(tr.getSquare(),Square);
    }
    @Test(expectedExceptions= ArithmeticException.class, dataProvider = "WrongDataProvider")
    public void testBigTriangle(Double a, Double b, Double c) {
        Triangle tr = new Triangle(a,b,c);
        tr.getSquare();
    }
}
