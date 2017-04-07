package lab4.ru.vsu.amm.avl_tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    private Tree<Integer, String> tester;

    @Before
    public void init () {
        tester = new Tree<>();

        for (int i = 0; i < 5000; i++) {
            tester.add(i, null);
        }
    }

    @Test
    public void treeShouldContainValue () {
        String inserted = "hello";
        tester.add(Integer.MAX_VALUE, inserted);
        Tree<Integer, String>.Node<Integer, String> node =
            tester.find(Integer.MAX_VALUE);
        String found = node == null ? "" : node.getValue();
        String errorMessage =
            "Expected word is " + inserted + " but " + found + " was found\n";

        Assert.assertEquals(errorMessage, inserted, found);

        System.out.println("Adding test (and search obviously). Passed.");
    }

    @Test
    public void treeMustNotContainNode () {
        final Integer a = 1;
        Assert.assertNotNull("Value " + a + " is expected to be in.",
            tester.find(a));
        tester.removeIfExists(a);
        Assert.assertNull("Value " + a + " must not be in tree",
            tester.find(a));

        System.out.println("Removing test. Passed");
    }

}
