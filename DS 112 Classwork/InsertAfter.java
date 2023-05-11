public class InsertAfter {
    public static void insertAfter(Node head, int target, int newValue) {
        //traverse to find target
        for (Node ptr = head; ptr != null; ptr = ptr.next){
            if (ptr.value == target){
                //insert new Node;
                ptr.next = new Node (newValue, ptr.next);
                break;


                //bigO? O(n) ----> worst case
            }
        }
        
    }

    public static int maximum(Node head){
        if (head == null){
            return 0;
        } else{
            int max = 0;
            if (head > max){
                max = head.value;
            }
           maximum(head.next);
            return max;

            //bigO is still O(n) because you make n recursive calls
            //space complexity is O(n) because you're storing recursive calls

            }
        }
    }