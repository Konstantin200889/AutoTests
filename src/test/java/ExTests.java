import org.example.Cat;
import org.example.Dog;
import org.example.Rectangle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class ExTests {

    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", useHeadersInDisplayName = true)
    void testWithCsvFileSourceAndHeaders(String Login, String Password, String Role) {
        String a = Login + " " + Password + " " + Role;
        System.out.println(a);
        Assertions.assertNotNull(Login);
        Assertions.assertNotNull(Password);
        Assertions.assertNotNull(Role);
        Assertions.assertNotEquals(" ", Login);
        Assertions.assertNotEquals(" ", Password);
        Assertions.assertNotEquals(" ", Role);
    }

        // Урок
        /*
        @Test
        public void rectangleAreaTest () {
            Rectangle rectangle = new Rectangle(); // каждый тест - это метод, кот. что-то делает
            rectangle.width = 5.0;
            rectangle.length = 5.0;
            rectangle.height = 5.0;
            Boolean check = false;
            if (rectangle.area() == 125) {
                check = true;
            }
            Assertions.assertTrue(check, "wrong calculation");
        }


        @Test
        public void NewRectangleAreaTest () {
            Rectangle rectangle = null;
            Assumptions.assumeTrue(true);
            rectangle = new Rectangle();
            rectangle.length = 1.0;
            rectangle.height = 1.0;
            rectangle.width = 1.0;

            Assertions.assertEquals(1, rectangle.area(), "wrong calculation");
        }


        @Test
        public void MeowMeowTest () {
            Cat cat = new Cat();
            Assertions.assertEquals("MeowMeow!!!", cat.voice(), "error");
        }


        @Test
        public void BarkBarkTest () {
            Dog dog = new Dog();
            Assertions.assertEquals("Bark-Bark!!!", dog.voice(), "error");
        }


        @Test
        public void NewTest () {
            Boolean a = false;
            Assertions.assertTrue(!a, "correct");
        }


        @Test
        public void NewNewTest () {
            Dog dog = new Dog();
            Dog doggy = new Dog();
            Assertions.assertSame(dog, doggy, "notequal");
        }


        @Test
        public void NewNewNewTest () {
            Rectangle rectangle1 = null;
            rectangle1.width = 5.0;
            rectangle1.height = 5.0;
            rectangle1.length = 5.0;
            Assertions.assertEquals(125, rectangle1.RectangleArea(), "notcorrect");
        }


        @Test
        public void NewNewNewNewTest () {
            Rectangle rectangle2 = new Rectangle(5.0, 5.0, 6.0);
            Assumptions.assumeTrue(rectangle2 != null);
            rectangle2.width = 5.0;
            rectangle2.height = 5.0;
            rectangle2.length = 5.0;
            Assertions.assertEquals(125, rectangle2.RectangleArea(), "notcorrect");
        }


        @BeforeAll
        static void setup () {
            System.out.println("запустился 1 раз перед всеми тестами"); //
        }

        @BeforeEach
        public void setupEach () {
            System.out.println("запустился перед каждым тестом");
        }


        @Test
        public void ТестПлощади () {
            System.out.println("расчет площади");
        }

        @Test
        public void ТестПериметра () {
            System.out.println("расчет периметра");
        }


        @AfterEach
        public void setupAfterEach () {
            System.out.println("запустился 1 раз после каждого теста");
        }

        @AfterAll
        static void setupAfterAll () {
            System.out.println("запустился 1 раз после всех тестов");
        }
*/
}












