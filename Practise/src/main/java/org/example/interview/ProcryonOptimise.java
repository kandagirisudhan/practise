import java.util.*;

public class ProcryonOptimise {

    public static List<Integer> countSmallerElements(LinkedList<Integer> nums) {
        // Initialize a TreeMap to store the occurrence of smaller elements for each element
        TreeMap<Integer, Integer> smallerOccurrences = new TreeMap<>();
        // Initialize a list to store the result
        List<Integer> result = new ArrayList<>();

        // Iterate over the linked list from right to left
        ListIterator<Integer> iterator = nums.listIterator(nums.size());
        while (iterator.hasPrevious()) {
            int current = iterator.previous();
            // Count the occurrence of smaller elements
            int smallerCount = smallerOccurrences.headMap(current).values().stream().mapToInt(Integer::intValue).sum();
            // Store the occurrence of smaller elements for the current element
            smallerOccurrences.put(current, smallerOccurrences.getOrDefault(current, 0) + 1);
            // Add the occurrence to the result list
            result.add(smallerCount);
        }

        // Reverse the result list to maintain the original order
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(6);
        linkedList.add(1);

        List<Integer> result = countSmallerElements(linkedList);
        System.out.println(result); // Output: [2, 1, 1, 0]
    }
}
