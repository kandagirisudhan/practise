import java.util.*;

public class Procyon {

    public static void main(String args[]) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(1);

        LinkedHashMap<Integer, List<Integer>> inputMap = new LinkedHashMap<>();

        // Create a LinkedHashMap to store the elements and their occurrences of smaller elements
        for (int num : linkedList) {
            inputMap.put(num, new ArrayList<>());
        }

        // Iterate over the elements of the linked list
        for (int i = 0; i < linkedList.size(); i++) {
            int current = linkedList.get(i);
            List<Integer> smallerList = inputMap.get(current);
            // Iterate again to count smaller elements
            for (int j = i + 1; j < linkedList.size(); j++) {
                if (current > linkedList.get(j)) {
                    smallerList.add(linkedList.get(j));
                }
            }
            inputMap.put(current, smallerList);
        }

        // Convert the occurrences of smaller elements to a list
        List<Integer> result = new ArrayList<>();
        for (int num : linkedList) {
            result.add(inputMap.get(num).size());
        }

        // Print the result
        System.out.println(result);  // Output: [2, 1, 1, 0]
    }
}
