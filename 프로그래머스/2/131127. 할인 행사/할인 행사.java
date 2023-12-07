import java.util.*;
class Solution {
    public boolean isAvailable(HashMap<String, Integer> wishList) {
        boolean isAvailable = true;    
        for (String product: wishList.keySet()) {
            if (wishList.get(product) != 0) {
                isAvailable = false;
                break;
            }    
        }
        
        return isAvailable;
    }
    
    public HashMap<String, Integer> calculateDiscount(
        int start, 
        String[] discount, 
        HashMap<String, Integer> wishList
    ) {
        int end = discount.length <= start + 10 ? discount.length : start + 10;
        for (int i = start; i < end; i++) {
            String product = discount[i];
            if (wishList.get(product) != null && wishList.get(product) > 0) {
               wishList.put(product, wishList.get(product) - 1); 
            }
        }
        
        return wishList;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wishList = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            String product = want[i];
            wishList.put(product, number[i]);
        }
        
        for (int i = 0; i < discount.length - want.length + 1; i++) {
            HashMap<String, Integer> wishListCopy = new HashMap<>(wishList);        
            HashMap<String, Integer> calcWishList = calculateDiscount(i, discount, wishListCopy);
        
            if (isAvailable(calcWishList)) {
                answer++;
            }
        }
        
        return answer;
    }
}