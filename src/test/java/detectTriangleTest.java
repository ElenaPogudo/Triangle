import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class detectTriangleTest {
    @DataProvider(name = "NormalInputProvider")
    public Object[][] NormalInputProviderData() {
        return new Object[][]
                {
                        {1.0, 1.0, 1.0, 3},//равносторонний и, соответственно равнобедренный
                        {3.0, 4.0, 5.0, 8},//прямоугольный
                        {4.0, 3.0, 5.0, 8},
                        {3.0, 5.0, 4.0, 8},
                        {4.0, 5.0, 3.0, 8},
                        {5.0, 4.0, 3.0, 8},
                        {5.0, 3.0, 4.0, 8},
                        {2.0, 2.0, 1.0, 2},//равнобедренный
                        {1.0, 3.0, 3.0, 2},
                        {3.0, 1.0, 3.0, 2},
                        {5.0, 8.0, 11.0, 4},//обычный
                        {5.0, 5.0, 5*Math.sqrt(2), 10 },//равнобедренный и прямоугольный
                        {7.0, 7.0, 7*Math.sqrt(2), 10 },//проходит только с 7
                };
    }
    @DataProvider(name = "WrongDataProvider")
    public Object[][] WrongDataProviderData() {//по логике должен выдавать ошибку, что нельзя определить тип, тк не корректный ввод
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
    public void testWhatTriangleIsThis(Double a, Double b, Double c, int TriangleType) {

        triangle.Triangle tr = new triangle.Triangle(a,b,c);
        Assert.assertEquals(tr.detectTriangle(),TriangleType);
    }
    @Test(expectedExceptions= ArithmeticException.class, dataProvider = "WrongDataProvider")//точно должно быть исключение, не факт правда что такое
    public void testBigTriangle(Double a, Double b, Double c) {
        triangle.Triangle tr = new triangle.Triangle(a,b,c);
        tr.detectTriangle();
    }
}
