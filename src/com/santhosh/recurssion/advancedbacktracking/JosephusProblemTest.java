package com.santhosh.recurssion.advancedbacktracking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class JosephusProblemTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void givenCircularLinkedList_WhenAddingElements_ThenListContainsThoseElements() {
        JosephusProblem.CircularLinkedList cll = JosephusProblem.createCircularLinkedList();

        Assert.assertTrue(cll.find(8));
        Assert.assertTrue(cll.find(37));
    }


}
