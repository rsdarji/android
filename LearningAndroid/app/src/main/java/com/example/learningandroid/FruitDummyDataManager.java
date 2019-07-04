package com.example.learningandroid;


import java.util.ArrayList;
import java.util.Random;

public class FruitDummyDataManager {

    /**
     * The array to hold pictures names.
     */
    public static final int[] pictures = new int[] { R.drawable.cross,
            R.drawable.cross, R.drawable.cross, R.drawable.cross,
            R.drawable.cross, R.drawable.cross,
            R.drawable.cross, R.drawable.cross };

    /**
     * The array to hold pictures names.
     */
    public static final String[] titles = new String[] { "Activity Life Cycle", "Fragments",
            "UI Demo", "Intents", "Sensors", "SQLite", "Services",
            "Broadcast" };

    /**
     * The array to hold messages.
     */
    public static final String[] messages = new String[] {
            "",
            "",
            "",
            "", "",
            "",
            "", "" };

    /**
     * Method to get fruit list using titles and messages arrays values.
     *
     * @return list
     */
    public static ArrayList<FruitItem> getFruitItemList() {
        ArrayList<FruitItem> list = new ArrayList<FruitItem>();
        for (int i = 0; i < titles.length; i++) {
            FruitItem item = new FruitItem();
            item.setFruitname(titles[i]);
            item.setMessage(messages[i]);
            item.setPictureResId(pictures[i]);
            list.add(item);

        }
        return list;
    }

    /**
     * Method to get new fruits<FruitItem>, generated just to show demo with
     * hardcoded fruit names and messages randomly.
     *
     * @return item
     */
    public static FruitItem getRandomItem() {
        FruitItem item = new FruitItem();
        int randomValue = new Random().nextInt(titles.length);
        item.setFruitname(titles[randomValue]);
        item.setMessage(messages[randomValue]);
        item.setPictureResId(pictures[randomValue]);
        return item;
    }

}