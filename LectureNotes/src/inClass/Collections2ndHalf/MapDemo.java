package inClass.Collections2ndHalf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class MapDemo {
    public static void main(String[] args) {
        //Maps store Key and Value pair, key is always unique
        //Maps are generic but has two generic variables
        Map gMap = new HashMap<>();
        Map<Integer, String> iSMap = new HashMap<>();
        Map<Integer, Integer> iIMap = new HashMap<>();
        Map<String, String> sSMap = new HashMap<>();
        Map<Double, Boolean> dBMap = new HashMap<>();

        HashMap<Integer, String> hISMap = new HashMap<>();
        hISMap.put(1, "#inc");
        hISMap.put(2, "Monkey");
        hISMap.put(3, "Baby");
        hISMap.put(4, "#inc");
        hISMap.put(5, "Monkey");
        hISMap.put(1, "OMFG"); //put at same key will replace value
        hISMap.put(6, null);
        hISMap.put(null, null);
        hISMap.put(0, "0");
        System.out.println(hISMap);

        System.out.println(hISMap.size());
        System.out.println(hISMap.keySet());
        System.out.println(hISMap.values());

        for (String i : hISMap.values()) {
            System.out.println(i);
        }

        for (Integer i : hISMap.keySet()) {
            System.out.println(i);
        }

        System.out.println(hISMap.entrySet());
        for (Entry<Integer, String> i : hISMap.entrySet()) {
            System.out.println(i);
        }

        //Lambda Functions
        hISMap.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });

        //TreeMap implements Map and SortedMap interfaces
        //Duplicate elements are allowed but not duplicate keys
        //TreeMap key cannot be null but can have null values
        //Maintains the order ASC by key by default
        TreeMap<Integer, String> iSTMap = new TreeMap<>();
        TreeMap<Integer, Integer> iITMap = new TreeMap<>();
        TreeMap<String, String> sSTMap = new TreeMap<>();
        TreeMap<Double, Boolean> dBTMap = new TreeMap<>();

        iSTMap.put(0, null);
        iSTMap.put(1, "#inc");
        iSTMap.put(4, "#inc");
        iSTMap.put(3, "Monkey");
        iSTMap.put(-1, "Dude");
        iSTMap.put(2, "Duder");
        System.out.println(iSTMap);
        System.out.println(iSTMap.keySet());
        System.out.println(iSTMap.descendingKeySet());
        System.out.println(iSTMap.values());
        System.out.println(iSTMap.entrySet());
        System.out.println(iSTMap.descendingMap());
        System.out.println(iSTMap.headMap(3));
        System.out.println(iSTMap.tailMap(3));
        System.out.println(iSTMap.containsKey(3));
        System.out.println(iSTMap.containsValue("3"));
        System.out.println(iSTMap.subMap(2, 5));

    }
}
