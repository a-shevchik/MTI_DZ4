import java.util.ArrayList;
import java.util.List;

//*** 4. �������� �������� ��������� �� ������ ***



public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		
		//���������� ������:
		for (int i = 0; i < 70; i++) list.add(i);
		
		System.out.println("������ list:");
		System.out.println("������ - ��������");
		
		for (int i = 0; i < 70; i++) {
			System.out.println(i + " - " + list.get(i));
		}
		System.out.println();
		
		//�������� ���������, ������� �� �������� ��������:
		for (int i = list.size()-1; i>=0; i--) {
			if (i%2 != 0) list.remove(i);
		}

		System.out.println("������ list ����� �������� �������� ���������:");
		System.out.println("������ - ��������");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " - " + list.get(i));
		}
		System.out.println();
	}

}
