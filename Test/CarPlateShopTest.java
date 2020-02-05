import com.company.CarPlateShop;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CarPlateShopTest {

    private CarPlateShop shop;

    @Before
    public void CarPlateShopTest() {
        this.shop = new CarPlateShop();
    }

    //    @Test
//    public void
    @Test (expected = IllegalArgumentException.class)
    public void testIllegalInput() {
        assertThat(shop.calculatePrice(null), is(equalTo(new IllegalArgumentException())));
        assertThat(shop.calculatePrice("3242342424234"), is(equalTo(new IllegalArgumentException())));
        assertThat(shop.calculatePrice("aaaaaaa"), is(equalTo(new IllegalArgumentException())));
        assertThat(shop.calculatePrice("      "), is(equalTo(new IllegalArgumentException())));
    }

    @Test
    public void testAllNumbersAndLettersAreTheSameCost5000() {
        assertThat(shop.calculatePrice("AAA111"), is(equalTo(5000.0)));
        assertThat(shop.calculatePrice("bbb000"), is(equalTo(5000.0)));
    }

    @Test
    public void testThreeLettersOfNumbersEqualOr666Or001() {
        assertThat(shop.calculatePrice("ccc213"), is(equalTo(1000.0)));
        assertThat(shop.calculatePrice("cga333"), is(equalTo(1000.0)));
        assertThat(shop.calculatePrice("abc001"), is(equalTo(1000.0)));
        assertThat(shop.calculatePrice("abc666"), is(equalTo(1000.0)));
        assertThat(shop.calculatePrice("abc123"), is(not(1000.0)));
        assertThat(shop.calculatePrice("BBB000"), is(not(1000.0)));
    }

    @Test
    public void testEqualsGODBOSOrKLR() {
        assertThat(shop.calculatePrice("klr213"), is(equalTo(2000.0)));
        assertThat(shop.calculatePrice("bos213"), is(equalTo(2000.0)));
        assertThat(shop.calculatePrice("GOD213"), is(equalTo(2000.0)));
        assertThat(shop.calculatePrice("BBB000"), is(not(2000.0)));
        assertThat(shop.calculatePrice("abc123"), is(not(2000.0)));
        assertThat(shop.calculatePrice("GOD222"), is(equalTo(7000.0)));
        assertThat(shop.calculatePrice("klr000"), is(equalTo(7000.0)));
        assertThat(shop.calculatePrice("bos555"), is(not(2000.0)));
    }

    @Test
    public void testSuperSpecialNumber() {
        assertThat(shop.calculatePrice("a10999"), is(equalTo(10000.0)));
        assertThat(shop.calculatePrice("abc00b"), is(equalTo(10000.0)));
        assertThat(shop.calculatePrice("001abc"), is(equalTo(10000.0)));
        assertThat(shop.calculatePrice("abg1"), is(equalTo(10000.0)));
    }

    @Test
    public void testRegularNumber() {
        assertThat(shop.calculatePrice("abc112"), is(equalTo(500.0)));
    }

    @Test
    public void testMiscTests() {
        assertThat(shop.calculatePrice("aaa"), is(equalTo(10000.0)));
        assertThat(shop.calculatePrice("bos"), is(equalTo(10000.0)));
    }
}
