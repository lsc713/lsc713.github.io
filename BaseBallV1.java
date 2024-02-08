
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class BaseBallV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] com = new int[3];
        com[0] = (int) (random() * 10);
        com[1] = (int) (random() * 10);
        while (com[0] == com[1]){
            com[1] = (int) (random() * 10);
        }
        com[2] = (int) (random() * 10);
        while (com[2] == com[0] || com[2] == com[1]) {
            com[2] = (int) (random() * 10);
        }

//        System.out.println("com = " + Arrays.toString(com));

        int[] user = new int[3];
        System.out.println("컴퓨터가 숫자를 생성했습니다. 답을 맞춰보세요");
        int strike = 0;
        int ball = 0;
        int count = 0;

        while (true) {
            count++;
            String strNum = sc.nextLine();
            char[] c = strNum.toCharArray();
            int number = Integer.parseInt(strNum);
            if( number > 1000 ){
                System.out.println("세자리숫자를 적어주세요");
                continue;
            }

            if(c.length < 3) {
                System.out.println("세자리 숫자를 입력하세요");
                continue;
            }

            user[0] = number / 100;
            user[1] = (number % 100) / 10;
            user[2] = number % 10;
            if (user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
                System.out.println("중복발생");
                continue;
            }
            for (int i = 0; i < user.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (com[j]==user[i]){
                        if(i == j){
                            strike++;
                        } else{
                            ball++;
                        }
                    }
                }
            }

            if (strike == 3) {
                System.out.println(count+"번째 시도 : "+strike+"S");
            } else if (ball==3) {
                System.out.println(count+"번째 시도 : "+ ball + "B");
            } else {
                System.out.println(count+"번째 시도 : "+ball+"B"+strike+"S");
            }

            if (strike == 3) {
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                strike = 0;
                ball=0;
            }
        }
    }
}