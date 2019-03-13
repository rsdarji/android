package com.example.admin.listviewwithcheckbox;


import java.util.ArrayList;
import java.util.Random;

public class FruitDummyDataManager {

    /**
     * The array to hold pictures names.
     */
    public static final int[] pictures = new int[] { R.drawable.apple,
            R.drawable.banana, R.drawable.orange, R.drawable.mango,
            R.drawable.papaya, R.drawable.pomegranate,
            R.drawable.strabarey, R.drawable.watermalon };

    /**
     * The array to hold pictures names.
     */
    public static final String[] titles = new String[] { "Apple", "Banana",
            "Orange", "Mango", "Papaya", "Pomegranate", "Strawberry",
            "Watermelon" };

    /**
     * The array to hold messages.
     */
    public static final String[] messages = new String[] {
            "Apple color is red.",
            "Banana color is yellow.",
            "Nagpur is famous for orange, thats why it is known as orange city.",
            "Mango is king of fruits.", "Papaya is best for skin.",
            "Pomegranate is most useful for increasing blood level.",
            "Strawberry color is red.", "Watermelon is very useful in summer." };

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