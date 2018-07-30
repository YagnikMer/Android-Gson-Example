package com.worldmer.gsonexample;

import java.util.List;

/**
 * Created by Yagnik on 30-Jul-18.
 */

public class AlphabetResponse {

    String success;
    List<Alphabets> alphabets;

    static class Alphabets {
        String name;
        String image;
    }
}
