// https://leetcode.com/problems/reveal-cards-in-increasing-order/
import java.util.*;

public class Q14_Reveal_Cards_In_Increasing_Order {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int[] ans = new int[deck.length];
        LinkedList<Integer> dq = new LinkedList<>();

        for(int i=0; i<ans.length; i++){
            dq.add(i);
        }

        for(int card : deck){
            int idx = dq.removeFirst();
            ans[idx] = card;
            if(!dq.isEmpty()){
                dq.addLast(dq.removeFirst());
            }
        }
        return ans;
    }
}