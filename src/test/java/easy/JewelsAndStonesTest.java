package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JewelsAndStonesTest {

    @Test
    public void testNumJewelsInStones() {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        assertEquals(3, jewelsAndStones.numJewelsInStones("aA", "aAAbbbb"));
    }
}