package chap15.ex09;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;	//최고점수 아이디
		int maxScore = 0;	//최고점수
		int totalScore = 0; //점수 합계

		Set<String> keySet=map.keySet();
		for(String key : keySet) {
			if(map.get(key)>maxScore) {
				maxScore=map.get(key);
				name=key;
			}
			totalScore+=map.get(key);
		}
		/*
		 Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
		 for(Map.Entry<String,Integer> entry : entrySet){
		  	if(entry.getValue() > maxScore){
		  		name=entry.getKey();
		  		maxScore=entry.getValue();
		 	}
		 	totalScore+=entry.getValue();
		 }
		 */
		
		
		
		
		int avg=totalScore/map.size();
		System.out.println("평균점수:"+avg);
		System.out.println("최고점수:"+maxScore);
		System.out.println("최고점수를 받은 아이디:"+name);
	}
}
