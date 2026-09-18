import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[101];
        LocalDate YMD = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        Map<String,String> map1=new HashMap<>();
        Map<String,String> map2=new HashMap<>();
        
        for(int i=0;i<terms.length;i++){
            String[] temp = terms[i].split(" ");
            map1.put(temp[0], temp[1]);
        }
        
        int cnt=0;
        for(int i=0;i<privacies.length;i++){
            String[] temp = privacies[i].split(" "); // 그리고 개인정보 수집일자 
            String getMap = map1.get(temp[1]); // 유효기간 몇달인지
            LocalDate privacyDate = LocalDate.parse(temp[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            LocalDate PlusDate = privacyDate.plusMonths(Integer.parseInt(getMap));
            if(!YMD.isBefore(PlusDate)){
                answer[cnt++]=i+1;
            }
        }
        
        return Arrays.copyOf(answer, cnt);
    }
}