package myFirstJava;

public class VariableEx {
	/*
	 * 리터럴(일반적인 수)을 적을 때에, 정수형은 default가 Integer, 실수형은 default가 double이다.
	 * Float 나 Long의 변수에 수를 할당할 때는 숫자 뒤에  F 와 L을 적어줘야 한다.float의 경우 적지 않을 시 Error(float < double)
	 * 16진수는 0x, 8진수는 0, 2진수는 0b로 간단하게 표현 가능하다.
	 * Java는 변수와 리터럴의 type이 불일치할 시 큰 범위 안에 좁은 타입의 값을 넣는 것만 허용한다. => Long type 변수 안에 int type의 리터럴은 넣을 수 있다.
	 * String은 primitive가 아닌 reference 변수이다. 즉 Class이다.
	 * 문자열과 문자열 혹은 다른 type의 concat은 +연산자로 하며 이 경우, 모두  문자열로 변환 후 합쳐진다.
	 * 
	 */
	public static void main(String[] args) {
		printfExercise();
	}
	public static void printfExercise() {
		byte b = 1;
		short s = 2;
		char c = 'A';
		
		long hex = 0xFFFF_FFFF_FFFF_FFFFL;
		int octNum = 010;
		int hexNum = 0x10;
		int binNum = 0b10;
		
		System.out.printf("Byte = %d\n",b);
		System.out.printf("Short = %d\n",s);
		System.out.printf("Character = %c, %d\n",c,(int)c); //Java에선 character를 Integer로 표현 시 형변환 필수
		
		System.out.printf("[5칸 차지(오른쪽 정렬)]%5d\n",100);
		System.out.printf("[5칸 차지(왼쪽 정렬)]%-5d\n",100);
		System.out.printf("[5칸 차지(빈 칸 0으로 대체)]%05d\n",100);
		System.out.printf("hex = %#x\n",hex);
		System.out.printf("OctNum = %o, in decimal %d\n",octNum,octNum);
		System.out.printf("HexNum = %x, in decimal %d\n",hexNum,hexNum);
		System.out.printf("BinNum = %s, in decimal %d\n",Integer.toBinaryString(binNum),binNum);//2진수로 출력해주는 지시자는 없으므로 Integer class의 메소드 사용
	}

}
