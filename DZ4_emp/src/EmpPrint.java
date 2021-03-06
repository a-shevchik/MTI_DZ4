import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//*** 2. ���������� ***



public class EmpPrint {
	
	private static void printEmployee(Collection<Employee> employees, int workAge) {
		//����� ����������� �� ������ workAge
		
		System.out.println("��������� �� ������ "+workAge+" ���:");
		
		for (Iterator<Employee> iter = employees.iterator(); iter.hasNext();) {
			Employee emp = iter.next();
			
			if (emp.stage == workAge) {
				System.out.println(emp.lastName + " " + emp.firstName + " " + emp.middleName);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			Employee emp = new Employee();
			emp.firstName = "���_����������_"+i;
			emp.lastName = "�������_����������_"+i;
			emp.middleName = "��������_����������_"+i;
			emp.stage = (int) Math.round(Math.random()*30);
			employees.add(emp);
			
		}
		
		System.out.println("���������� ��������:");
		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i).lastName+' '+employees.get(i).firstName+" ����: "+employees.get(i).stage);
		}
		System.out.println();
		
		printEmployee(employees, 20);//����� ����������� �� ������ 20 ���
	}

}
