package ch05;
//학생 수와 학생 점수를 입력받아 최고 점수, 평균점수를 구하기

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		boolean run=true;
		int studentNum=0;
		int[] scores=null;
		int max=0;
		double avg=0;
		int sum=0;
		
		Scanner scanner=new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>");
			
			int selectNo=scanner.nextInt();

			
			if(selectNo==1) {
				System.out.print("학생 수를 입력해주세요.");
				studentNum=scanner.nextInt();
				
				
			}else if(selectNo==2) {
				if(studentNum==0) {
					System.out.println("학생 수가 입력이 안되었습니다.");
				}else {
					scores=new int[studentNum];
					for(int i=0;i<studentNum;i++){
						System.out.print((i+1)+"번 학생의 점수를 입력해주세요.");
						scores[i]=scanner.nextInt();
					}
				}
			
			
			}else if(selectNo==3) {
				if(scores==null) {
					System.out.println("점수가 입력되어 있지 않습니다.");
				}else {
					for(int i=1;i<=studentNum;i++) {
					System.out.println(i+"번 학생의 점수: "+scores[i-1]);	
					}
				}
				
				
			}else if(selectNo==4) {
				
				if(scores==null) {
					System.out.println("점수가 입력되어 있지 않습니다.");
				}else {
					for(int score:scores) {
						sum+=score;
						if(score>max) {
							max=score;
						}
					}
					avg=sum/studentNum;
					System.out.println("최고 점수:"+max);
					System.out.println("평균 점수:"+avg);
				}
				
			}else if(selectNo==5) {
				run=false;
			}
		}

		
		System.out.println("프로그램 종료");
		scanner.close();
		
	}

}
