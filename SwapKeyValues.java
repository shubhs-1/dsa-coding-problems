import java.util.*;

public class SwapKeyValues {
    public static void main(String[] args) {
        Map<String, List<String>> input = new HashMap<>();
        input.put("B1", Arrays.asList("A2", "A3"));
        input.put("B2", Arrays.asList("A1", "A2"));
        input.put("B3", Arrays.asList("A3", "A4"));
        input.put("B4", Arrays.asList("A4", "A1"));

        Map<String, List<String>> result = new HashMap<>();
        result = swapKeyValuePairs(input);
        System.out.println("Map: " + result.entrySet());

    }

    public static Map<String, List<String>> swapKeyValuePairs(Map<String, List<String>> input) {
        Map<String, List<String>> result = new HashMap<>();

        for(Map.Entry<String, List<String>> items : input.entrySet()) {
            List<String> values = items.getValue();
            for(String key : values) {
                List<String> value = result.get(key);
                if(value != null) {
                    value.add(items.getKey());
                    result.put(key, value);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(items.getKey());
                    result.put(key, list);
                }
            }
        }

        return result;
    }
}