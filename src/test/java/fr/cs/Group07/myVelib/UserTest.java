package fr.cs.Group07.myVelib;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private User user;

    @Before
    public void setUp() {
        // Initialize the user object before each test method
        double[] userLocation = {45, 80};
        Cards registrationCard = new Cards("VLIBRE");
        String creditCardNumber = "4268 8465 2564 4566";
        user = new User("Louis Lhotte", userLocation, registrationCard, creditCardNumber);
    }

    @Test
    public void testGetName() {
        // Test the getName() method
        String name = user.getName();
        Assert.assertEquals("Louis Lhotte", name);
    }

    @Test
    public void testSetName() {
        // Test the setName() method
        user.setName("Jane Smith");
        String name = user.getName();
        Assert.assertEquals("Jane Smith", name);
    }

    @Test
    public void testAddToTotalCharges() {
        // Test the addToTotalCharges() method
        user.addToTotalCharges(10.5);
        double totalCharges = user.getTotalCharges();
        Assert.assertEquals(10.5, totalCharges, 0.01);
    }
}
