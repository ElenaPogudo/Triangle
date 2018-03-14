import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class checkTriangleTest {


    @DataProvider(name = "ZeroNegativInputProvider")
    public Object[][] ZeroMessageProviderData() {
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
                };
    }
    @DataProvider(name = "InfinityTriangleProvider")
    public Object[][] InfinityTriangleProviderData() {
        return new Object[][]
                {
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

    @Test(dataProvider = "ZeroMessageProvider")
    public void testCheckTriangle(Double a, Double b, Double c) {

        Triangle tr = new Triangle(a,b,c);
        Assert.assertFalse(tr.checkTriangle());
    }
        @Test(expectedExceptions= ArithmeticException.class, dataProvider = "InfinityTriangleProvider")
    public void testBigTriangle(Double a, Double b, Double c) {
        Triangle tr = new Triangle(a,b,c);
        tr.checkTriangle();
        }
}