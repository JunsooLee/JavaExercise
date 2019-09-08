package myFirstJava;

public class VariableEx {
	/*
	 * ���ͷ�(�Ϲ����� ��)�� ���� ����, �������� default�� Integer, �Ǽ����� default�� double�̴�.
	 * Float �� Long�� ������ ���� �Ҵ��� ���� ���� �ڿ�  F �� L�� ������� �Ѵ�.float�� ��� ���� ���� �� Error(float < double)
	 * 16������ 0x, 8������ 0, 2������ 0b�� �����ϰ� ǥ�� �����ϴ�.
	 * Java�� ������ ���ͷ��� type�� ����ġ�� �� ū ���� �ȿ� ���� Ÿ���� ���� �ִ� �͸� ����Ѵ�. => Long type ���� �ȿ� int type�� ���ͷ��� ���� �� �ִ�.
	 * String�� primitive�� �ƴ� reference �����̴�. �� Class�̴�.
	 * ���ڿ��� ���ڿ� Ȥ�� �ٸ� type�� concat�� +�����ڷ� �ϸ� �� ���, ���  ���ڿ��� ��ȯ �� ��������.
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
		System.out.printf("Character = %c, %d\n",c,(int)c); //Java���� character�� Integer�� ǥ�� �� ����ȯ �ʼ�
		
		System.out.printf("[5ĭ ����(������ ����)]%5d\n",100);
		System.out.printf("[5ĭ ����(���� ����)]%-5d\n",100);
		System.out.printf("[5ĭ ����(�� ĭ 0���� ��ü)]%05d\n",100);
		System.out.printf("hex = %#x\n",hex);
		System.out.printf("OctNum = %o, in decimal %d\n",octNum,octNum);
		System.out.printf("HexNum = %x, in decimal %d\n",hexNum,hexNum);
		System.out.printf("BinNum = %s, in decimal %d\n",Integer.toBinaryString(binNum),binNum);//2������ ������ִ� �����ڴ� �����Ƿ� Integer class�� �޼ҵ� ���
	}

}
