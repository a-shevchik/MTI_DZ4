import java.util.HashSet;
import java.util.Set;

//*** 3. �������� ��� ����������� ***



public class SetOperations {
	
	private static Set<Integer> union (Set<Integer> set1, Set<Integer> set2) {
		//����������� ��������
		Set<Integer> resultSet = new HashSet<>();
		
		for (Integer i :set1) resultSet.add(i);
		for (Integer i :set2) resultSet.add(i);
		
		return resultSet;
	}
	
	private static Set<Integer> intersect (Set<Integer> set1, Set<Integer> set2) {
		//����������� ��������
		Set<Integer> resultSet = new HashSet<>();
		
		for (Integer i :set1) {
			if (set2.contains(i)) resultSet.add(i);
		}
		
		return resultSet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		//���������� ��������:
		for (int i = 0; i < 20; i++) {
			set1.add((int) Math.round(Math.random()*100));
			set2.add((int) Math.round(Math.random()*100));
		}
		
		System.out.println("��������� set1:");
		for (Integer i : set1) System.out.print(i +" ");
		System.out.println();
		
		System.out.println("��������� set2:");
		for (Integer i : set2) System.out.print(i +" ");
		System.out.println();
		
		System.out.println("����������� �������� set 1 � set2:");
		for (Integer i : union(set1, set2)) System.out.print(i +" ");
		System.out.println();
		
		System.out.println("����������� �������� set 1 � set2:");
		for (Integer i : intersect (set1, set2)) System.out.print(i +" ");
		System.out.println();

	}

}
