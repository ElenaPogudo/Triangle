import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

public class getMessageTest {
    @DataProvider(name = "ZeroMessageProvider")
    public Object[][] ZeroMessageProviderData() {
        return new Object[][]
                {
                        {Double.NEGATIVE_INFINITY, 1.0, 2.0, "a<=0"},
                        {0.0, 1.0, 2.0, "a<=0"},
                        {-1.0, 1.0, 2.0, "a<=0"},
                        {1.0, Double.NEGATIVE_INFINITY, 2.0, "b<=0"},
                        {8.0, 0.0, 6.0, "b<=0"},
                        {8.0, -4.0, 6.0, "b<=0"},
                        {1.0, 2.0, Double.NEGATIVE_INFINITY, "c<=0"},
                        {1.0, 1.0, 0.0, "c<=0"},
                        {1.0, 1.0, -5.0, "c<=0"},
                        {0.0, 0.0, 2.0, "a<=0"},
                        {-1.0, -1.0, 2.0, "a<=0"},
                        {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 2.0, "a<=0"},
                        {0.0, 1.0, 0.0, "a<=0"},
                        {-1.0, 1.0, -1.0, "a<=0"},
                        {Double.NEGATIVE_INFINITY, 1.0, Double.NEGATIVE_INFINITY, "a<=0"},
                        {1.0, 0.0, 0.0, "b<=0"},
                        {1.0, -1.0, -1.0, "b<=0"},
                        {1.0, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, "b<=0"},
                        {0.0, 0.0, 0.0, "a<=0"},
                        {-1.0, -1.0, -1.0, "a<=0"},
                        {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, "a<=0"},
                };
    }
    @DataProvider(name = "WrongTriangleProvider")
    public Object[][] WrongTriangleProviderData() {
        return new Object[][]
                {
                        {1.0, 1.0, 2.0, "a+b<=c"},
                        {1.0, 1.0, 3.0, "a+b<=c"},
                        {2.0, 1.0, 1.0, "b+c<=a"},
                        {3.0, 1.0, 1.0, "b+c<=a"},
                        {1.0, 2.0, 1.0, "a+c<=b"},
                        {1.0, 3.0, 1.0, "a+c<=b"},
                };
    }

    @Test(dataProvider = "ZeroMessageProvider")
    public void testGetZeroMessege(Double a, Double b, Double c, String Message) {
        Triangle tr = new Triangle(a,b,c);
        tr.checkTriangle();
        Assert.assertFalse(tr.checkTriangle());
        Assert.assertSame(tr.getMessage(),Message);
    }
    @Test(dataProvider = "WrongTriangleProvider")
    public void testGetWrongTriangleMessege(Double a, Double b, Double c, String Message) {
        Triangle tr = new Triangle(a,b,c);
        tr.checkTriangle();
        Assert.assertFalse(tr.checkTriangle());
        Assert.assertEquals(tr.getMessage(),Message);
    }
}
