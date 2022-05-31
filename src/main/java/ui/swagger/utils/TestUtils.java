package ui.swagger.utils;

import ui.swagger.model.UserPojo;

import java.util.Random;

public class TestUtils extends UserPojo {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
