package LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by evanhitchings on 10/20/16.
 */
public class ZipLinkedListTest {
    ZipLinkedList zipLinkedList = new ZipLinkedList();


    @Before
    public void setup(){
        zipLinkedList.add(5);
        zipLinkedList.add(4);
        zipLinkedList.add(3);
        zipLinkedList.add(2);
        zipLinkedList.add(1);
        zipLinkedList.add(0);
    }


    @Test
    public void addTest(){
        zipLinkedList.add(5);
        Assert.assertEquals("Did not return 5", 5, zipLinkedList.head.data);
    }

    @Test
    public void removeTest(){
        zipLinkedList.remove(3);
        Assert.assertEquals("Did not remove element at index 3", 4, zipLinkedList.head.next.next.next.data);
    }

    @Test
    public void containsTrueTest(){
        Assert.assertTrue("Did not return true when list did contain element", zipLinkedList.contains(2));
    }

    @Test
    public void containsFalseTEst(){
        Assert.assertFalse("Returned true when it did not actually contain element", zipLinkedList.contains(7));
    }

    @Test
    public void findTestIndex(){
        Assert.assertEquals("Did not find element in index 2 and return 2", 2, zipLinkedList.find(2));
    }

    @Test
    public void findTestFail(){
        Assert.assertEquals("Did not return -1 after failing to find element ", -1, zipLinkedList.find(7));
    }

    @Test
    public void getByIndex(){
        Assert.assertEquals("Did not return element at index 4 as requested", 4, zipLinkedList.get(4));
    }

    @Test
    public void copyTest() {
        ZipLinkedList copied = zipLinkedList.copy();
        Assert.assertEquals("List did not copy correctly", copied.head.data, zipLinkedList.head.data);

        System.out.println(copied);
        System.out.println(zipLinkedList);

    }
    @Test
    public void sortTest(){
        zipLinkedList.add(5);
        System.out.println(zipLinkedList);
        zipLinkedList.sort();
        Assert.assertEquals("Head element was not zero", 0, zipLinkedList.head.data);
        System.out.println(zipLinkedList);
    }

    @Test
    public void reverseTest(){
        System.out.println(zipLinkedList);
        zipLinkedList.reverse();
        System.out.println(zipLinkedList);
        Assert.assertEquals("Did not reverse list as expected", 5, zipLinkedList.head.data);
        System.out.println(zipLinkedList.getSize());
    }

    @Test
    public void sliceTest(){
        ZipLinkedList sliced = zipLinkedList.slice(2, 5);
        System.out.println(sliced);
        Assert.assertEquals("Linked List was not sliced correctly", 2, sliced.head.data);
    }



}
