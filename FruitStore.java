package LastTest;
import java.util.Scanner;

public class FruitStore {

public static void main(String[] args) {

	Scanner s=new Scanner(System.in);
	String str; String fruits;

	String menu[]= new String[5];
	int price[]= new int [5];

	int AdminOn=0; int GuestOn=0; int a=0; int money=0; int loading=0;

	System.out.println("[왕경이네 과일도매장]");
	System.out.println("매일 신선한 제철과일을 5종류씩 판매, 구매합니다");
	System.out.println("종류는 매일 바뀌니 유의해 주세요.");

	while(true) {
		System.out.println("\n방문해주셔서 감사합니다");
		System.out.println("관리자? 판매자?");
		str=s.next();

		if (str.equals("관리자")) {
			AdminOn++;

		if (AdminOn==1) {

			System.out.println("오늘 구매하실 과일의 품목을 입력하세요");
			for(int i=0; i<5; i++) {
						menu[i]=s.next();
					}

		System.out.println("오늘의 과일:");

			for (int i=0; i<menu.length; i++) {
				System.out.print(menu[i]+" ");
			}

		System.out.println("\n과일 별 가격 입력");

			for (int i=0; i<menu.length; i++) {
				System.out.print(menu[i]+": ");
				price[i]=s.nextInt(); 
			}

	System.out.println("등록이 완료되었습니다!");
	AdminOn=2;
	} if(AdminOn>=1) {
			
			System.out.println("등록된 과일목록");
			for(int i=0; i<5; i++) {
				System.out.println(menu[i]+": "+price[i]+"원");
			}
			
			System.out.println("과일을 편집하시려면 '편집'을 입력하세요.");
				if (str.equals("편집")) {
					AdminOn=0;
					System.out.println("초기화가 완료되었습니다.");
				}
				} 					
			System.out.println("로그아웃? 종료?");
			str=s.next();
			if(str.equals("종료")) {
				System.out.println("감사합니다.");
				break;
			} if (str.equals("편집")) {
				AdminOn=0;
				System.out.println("초기화가 완료되었습니다.");
			}
			
			else {				
			}
		
		} else if (str.equals("판매자")) {
			if (AdminOn==0) {
				System.out.println("아직 과일이 업데이트 되지 않았습니다.");
			} else if (AdminOn>=1) {

				System.out.println("오늘의 과일: ");

				for (int i=0; i<menu.length; i++) {

					System.out.print(menu[i]+": ("+price[i]+"원) ");

				}

				System.out.print("\n판매할 과일을 입력하세요>>");
					fruits=s.next();

				for (int i=0; i<5; i++) 
					if (fruits.equals(menu[i])) {
						GuestOn=1;
						System.out.println(menu[i]+"의 가격은"+price[i]);
						System.out.println("몇 개를 판매하시겠습니까?");
						a=s.nextInt();
						
						System.out.println(menu[i]+"를"+a+"개 판매하셨습니다"
 						+"\n당신이 받은 금액은: "+(a*price[i])+"원");
						money+=a*price[i];
						
						

					} else if(!(fruits.equals(menu[i]))) {
						System.out.println("로딩..");
						loading++;
						if(loading==5) {
							System.out.println("판매중인 과일이 아닙니다.");
							loading=0;
						}
					}
				}

				if (GuestOn==1) {

					System.out.println("오늘의 총 수익: "+money);
					System.out.print("초기화 하시려면 초기화, 저장하시려면 계속을 입력>>");
					str=s.next();
					loading=0;
					
					if (str.equals("초기화")) {
						GuestOn=0;
						money=0;
						System.out.println("초기화가 완료되었습니다.");
					}
				} 

				System.out.println("로그아웃? 종료?");
				str=s.next();

				if(str.equals("종료")) {
					System.out.println("감사합니다.");
					break;
				} else {
				}
			}
		else if(str.equals("종료")) {
			System.out.println("감사합니다.");
			break;
		} else {
			System.out.println("다시 입력하세요.");
		} 
	}
}
