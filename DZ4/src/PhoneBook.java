//import java.util.List;
//import java.util.ArrayList;
import java.util.*;
import java.util.Map.Entry;


//*** 1. ���������� ���������� ***


public class PhoneBook {
	static int recCount = 1000000; //���������� ������� �������
	
	//���������� ������ inpStr ����� ��������� char �� ������� size
	private static String lPad(String inpStr, int size, char sym) {
		String retVal = inpStr;
		
		int b = size - inpStr.length();
		for (int i=0; i<b; i++){
			retVal = sym + retVal;
		}
		return retVal;
	}
	
	private static void listTest(){
		System.out.println("������������� ������ ��� �������� ���������� �������");
		Long t1 = System.currentTimeMillis(); //������ ���������� ���������
		
		List<PhoneBookRecord> phoneBook = new ArrayList<PhoneBookRecord>(recCount);
		
		String operCode; //��� ��������� / ������
		
		for (int i = 0; i<recCount; i++) {
			
			PhoneBookRecord rec = new PhoneBookRecord();
			rec.fio = new FIO();
			
			rec.fio.lastName = "LASTNAME" + i;
			rec.fio.firstName = "FIRSTNAME" + i;
			rec.fio.middleName = "MIDDLENAME" + i;
			operCode = lPad(""+Math.round(Math.random()*1000), 3, '0');
			if (operCode.startsWith("9")) rec.numberType = false;
			else rec.numberType = true;
			
			rec.phoneNumber = "+7 "+operCode+" "+lPad(""+Math.round(Math.random()*1000), 3, '0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0');
			phoneBook.add(rec);
			
		}
		
		//���������� ������� ��������� ������� ���������� �������� �� ��� �� �����
		//������������ ���������� ������� (�� 10) ��� ������� ��������
		for (int i = 0; i < phoneBook.size(); i++) {
			phoneBook.get(i).relatedContList = new int[10]; //���������� ��������� ��������� -10
			//System.out.println("relContCount: "+relContCount);
			for (int j = 0; j < 10; j++) {
				int idxToAdd = (int) Math.round(Math.random()*(recCount-1));
				if (idxToAdd != i) phoneBook.get(i).relatedContList[j]=idxToAdd;
			}
		}
/*
		for (int i = 0; i < phoneBook.size(); i++) {
			System.out.println(phoneBook.get(i).fio.lastName+' '+phoneBook.get(i).fio.firstName+' '+phoneBook.get(i).phoneNumber+' '+(phoneBook.get(i).numberType ? "���������" : "�������"));
			System.out.println("��������� ��������:");
			for (Iterator<PhoneBookRecord> iter = phoneBook.get(i).relatedContList.iterator(); iter.hasNext();){
				System.out.print(iter.next().phoneNumber + " ");
			}
			System.out.println();
			
		}
*/
		//����� �������� ����� ������������� ������� (�.�. ��������)
		int[] idCounter = new int[recCount]; //������ ��� �������� ���������� �������� �������� �������
		for (int i=0; i < recCount; i++) idCounter[i] = 0; //������������� ��������
		
		for (int i=phoneBook.size()-1; i>=0; i--) {//����� ������ ��������� � �������� �������
			
			for (int x = 0; x<10; x++){//���� �� ������ ��������� ���������
				idCounter[phoneBook.get(i).relatedContList[x]]++; //����������� �������� �������� ��� ���������������� �������
			}
		}
		
		System.out.println();
		System.out.println("����� ������� � �����: "+phoneBook.size());
		//����� 5 ����� ������ ����������
		for (int j=0; j < 5; j++) {
			int id = 0;
			int maxCounter = 0; //�������� �������
			
			for (int i=0; i<recCount; i++){
				if (idCounter[i] > maxCounter) {
					id = i;//�������� id
					maxCounter = idCounter[i];//�������� ���������� ��������
				}
			}
			//�� ������ �� ����� ����� ����� � id ������ ����������� �������������� ������
			//��� ���������� ������� ������� ��� �������:
			idCounter[id] = 0;
			//������� �� �����:
			System.out.println(phoneBook.get(id).fio.lastName+' '+phoneBook.get(id).fio.firstName+' '+phoneBook.get(id).phoneNumber+' '+(phoneBook.get(id).numberType ? "���������" : "�������"));
			System.out.println("����������� " + maxCounter + " ���.");
			System.out.println();
		}

		//���������� ������� ����������
		Long t2 = System.currentTimeMillis();
		int min = (int) (t2 - t1)/60000;
		int sec = (int) (t2 - t1)/1000 - min * 60;
		
		System.out.println("����� ����������: "+min+" ��� "+sec+" ���");
		System.out.println("*******************************************");
	}

	private static void setTest(){
		System.out.println("������������� ��������� ��� �������� ���������� �������");
		Long t1 = System.currentTimeMillis(); //������ ���������� ���������
		
		Set<PhoneBookRecord> phoneBook = new HashSet<PhoneBookRecord>();
		
		String operCode; //��� ��������� / ������
		
		for (int i = 0; i<recCount; i++) {
			
			PhoneBookRecord rec = new PhoneBookRecord();
			rec.fio = new FIO();
			
			rec.fio.lastName = "LASTNAME" + i;
			rec.fio.firstName = "FIRSTNAME" + i;
			rec.fio.middleName = "MIDDLENAME" + i;
			operCode = lPad(""+Math.round(Math.random()*1000), 3, '0');
			if (operCode.startsWith("9")) rec.numberType = false;
			else rec.numberType = true;
			
			rec.phoneNumber = "+7 "+operCode+" "+lPad(""+Math.round(Math.random()*1000), 3, '0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0');
			//��������� ������:
			phoneBook.add(rec);
			//System.out.print("w");
		}
		//System.out.println();
		
		//���������� ������� ��������� ������� ���������� �������� �� ��� �� �����
		for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();) {
			PhoneBookRecord rec = (PhoneBookRecord) iter.next();
			//System.out.print("r");
			
			rec.relatedContList = new int[10];
			//System.out.println("������ ���������� ������ ��� ��������: "+" "+rec.phoneNumber+" (������: "+rec.hashCode()+")");
			
			for (int j = 0; j < 10; j++) {
				int rndCounter = (int) Math.round(Math.random()*(recCount)); //�������� ������������ ����� � ������ ���������� �������
				int i=0;
				//System.out.println("�������� ������������ �����: "+" "+rndCounter);
				
				Iterator<PhoneBookRecord> iterRelCont = phoneBook.iterator();
				PhoneBookRecord recRelCont = new PhoneBookRecord();
				for (i=0; i<rndCounter; i++) {
					
					recRelCont = iterRelCont.next();//��������� �� ������������ �����
					//System.out.println("������� ������: "+" "+recRelCont.hashCode());
				} 
				//System.out.println("	������� ������: "+" "+recRelCont.hashCode());
				
				if (recRelCont.hashCode() != iter.hashCode()) rec.relatedContList[j]=recRelCont.hashCode();//���� ���������� ����� �� ����� ��������, ���������� ��� ������ � ������ ��������� �������
			}
			
		}
		//System.out.println();
//���� ������ �� ������ ������ ���������:
/*
		for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();) {
			PhoneBookRecord rec = (PhoneBookRecord) iter.next();
			
			System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
			System.out.println("��������� ��������:");
			for (int i=0; i<10; i++){
				for (Iterator<PhoneBookRecord> iterRelCont = phoneBook.iterator(); iterRelCont.hasNext();){
					PhoneBookRecord recRelCont = (PhoneBookRecord) iterRelCont.next();
					if (rec.relatedContList[i] == recRelCont.hashCode()) System.out.print(recRelCont.phoneNumber + " ");
				}
				
			}
			System.out.println();
			
		}
*/
		//����� �������� ����� ������������� �������
		//����� ��� �������� ���������� �������� �������� �������
		//���� - ������, �������� - ���������� ��������
		Map<Integer, Integer> idCounter = new LinkedHashMap<>(recCount);
		//������������� �������� �����:
		for (PhoneBookRecord rec : phoneBook) {
			idCounter.put(rec.hashCode(), 0); 
		}
		
		for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();) {//����� ������ ���������
			PhoneBookRecord rec = (PhoneBookRecord) iter.next();
			
			for (int x = 0; x<10; x++){//���� �� ������ ��������� ���������
				//����������� �������� �������� ��� ���������������� �������:
				try {
					idCounter.put(rec.relatedContList[x], idCounter.get(rec.relatedContList[x])+1);
				} catch(NullPointerException ne) {
					
				}
				finally {
					
				}
			}
		}
		
		System.out.println();
		System.out.println("����� ������� � �����: "+phoneBook.size());
		//����� 5 ����� ������ ����������
		for (int j=0; j < 5; j++) {
			int id = 0;
			int maxCounter = 0; //�������� �������

			for (Entry<Integer, Integer> entry : idCounter.entrySet()) {
				if (entry.getValue() > maxCounter) {
					id = entry.getKey();//�������� id
					maxCounter = entry.getValue();//�������� ���������� ��������
				}
				
			}
			//�� ������ �� ����� ����� ����� � id ������ ����������� �������������� ������
			//��� ���������� ������� ������� ��� �������:
			idCounter.put(id, 0);
			//������� �� �����:
			for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();){
				PhoneBookRecord rec = (PhoneBookRecord) iter.next();
				
				if (id == rec.hashCode()) {
					System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
					System.out.println("����������� " + maxCounter + " ���.");
					System.out.println();
					
				}
			}
		}

		
		//���������� ������� ����������
		Long t2 = System.currentTimeMillis();
		int min = (int) (t2 - t1)/60000;
		int sec = (int) (t2 - t1)/1000 - min * 60;
		
		System.out.println("����� ����������: "+min+" ��� "+sec+" ���");
		System.out.println("*******************************************");
	}

	private static void mapTest(){
		System.out.println("������������� ����� ��� �������� ���������� �������");
		Long t1 = System.currentTimeMillis(); //������ ���������� ���������
		
		Map<Integer, PhoneBookRecord> phoneBook = new LinkedHashMap<>(recCount);
		
		String operCode; //��� ��������� / ������
		
		for (int i = 0; i<recCount; i++) {
			
			PhoneBookRecord rec = new PhoneBookRecord();
			rec.fio = new FIO();
			
			rec.fio.lastName = "LASTNAME" + i;
			rec.fio.firstName = "FIRSTNAME" + i;
			rec.fio.middleName = "MIDDLENAME" + i;
			operCode = lPad(""+Math.round(Math.random()*999), 3, '0');
			if (operCode.startsWith("9")) rec.numberType = false;
			else rec.numberType = true;
			
			rec.phoneNumber = "+7 "+operCode+" "+lPad(""+Math.round(Math.random()*999), 3, '0')+"-"+lPad(""+Math.round(Math.random()*99),2,'0')+"-"+lPad(""+Math.round(Math.random()*99),2,'0');
			//��������� ������:
			phoneBook.put(i, rec);
			
		}
		
		//���������� ������� ��������� ������� ���������� �������� �� ��� �� �����
		for (Entry<Integer, PhoneBookRecord> entry : phoneBook.entrySet()) {
			PhoneBookRecord rec = entry.getValue();
			rec.relatedContList = new int[10];//������������� �������
			//System.out.println("������ ���������� ������ ��� ��������: "+" "+rec.phoneNumber+" (������: "+rec.hashCode()+")");
			
			for (int j = 0; j < 10; j++) {
				rec.relatedContList[j] = (int) Math.round(Math.random()*(recCount-1)); //�������� ������������ ����� � ������ ���������� �������
				//System.out.println("�������� ������������ �����: "+" "+rndCounter);
			}
			
		}
//���� ������ �� ������ ������ ���������:
/*
		for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();) {
			PhoneBookRecord rec = (PhoneBookRecord) iter.next();
			
			System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
			System.out.println("��������� ��������:");
			for (int i=0; i<10; i++){
				for (Iterator<PhoneBookRecord> iterRelCont = phoneBook.iterator(); iterRelCont.hasNext();){
					PhoneBookRecord recRelCont = (PhoneBookRecord) iterRelCont.next();
					if (rec.relatedContList[i] == recRelCont.hashCode()) System.out.print(recRelCont.phoneNumber + " ");
				}
				
			}
			System.out.println();
			
		}
*/
		//����� �������� ����� ������������� �������
		int[] idCounter = new int[recCount]; //������ ��� �������� ���������� �������� �������� �������
		for (int i=0; i < recCount; i++) idCounter[i] = 0; //������������� ��������
		
		for (Entry<Integer, PhoneBookRecord> entry : phoneBook.entrySet()) {//����� ������ ��������� 
			
			for (int x = 0; x<10; x++){//���� �� ������ ��������� ���������
				idCounter[entry.getValue().relatedContList[x]]++; //����������� �������� �������� ��� ���������������� �������
			}
		}
		
		System.out.println();
		System.out.println("����� ������� � �����: "+phoneBook.size());
		//����� 5 ����� ������ ����������
		for (int j=0; j < 5; j++) {
			int id = 0;
			int maxCounter = 0; //�������� �������
			
			for (int i=0; i<recCount; i++){
				if (idCounter[i] > maxCounter) {
					id = i;//�������� id
					maxCounter = idCounter[i];//�������� ���������� ��������
				}
			}
			//�� ������ �� ����� ����� ����� � id ������ ����������� �������������� ������
			//��� ���������� ������� ������� ��� �������:
			idCounter[id] = 0;
			//������� �� �����:
			System.out.println(phoneBook.get(id).fio.lastName+' '+phoneBook.get(id).fio.firstName+' '+phoneBook.get(id).phoneNumber+' '+(phoneBook.get(id).numberType ? "���������" : "�������"));
			System.out.println("����������� " + maxCounter + " ���.");
			System.out.println();
		}

		
		
		
		
		
		
		
		
//		//����� �������� ����� ������������� �������
//		int[][] oftenNum = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}; //5 �������� ����� ������������� ������� (index, ���-�� ��������)
//		int debugNum =0;
//		System.out.println("���������� �������:");
//		
//		for (Entry<Integer, PhoneBookRecord> entry : phoneBook.entrySet()) {
//			Integer recId = entry.getKey();//������ ������������ ������
//			int counter = 0;
//			debugNum++;
//			if (debugNum%500 == 0) System.out.print(debugNum+" ");
//			
//			//���� ������� ����� � ��������� ��������� ������ �������
//			for (Entry<Integer, PhoneBookRecord> entryRelCont : phoneBook.entrySet()){//���� �� ������ �������
//				PhoneBookRecord recRelCont = (PhoneBookRecord) entryRelCont.getValue(); //�����, � ��������� ��������� �������� ���������
//				
//				for (int i=0; i<10; i++){//���� �� ������ ��������� ���������
//					if (recRelCont.relatedContList[i] == recId) counter ++;
//				}
//			}
//
//			for (int j=0; j < 5; j++) {
//				if (oftenNum[j][1] <= counter) {
//					//���� ������� ����� ����������� ���� ������, �������� �� ����� � �������, � ��������� ��������
//					for (int z=4; z >= j; z--) {
//						if (z>0) {
//							oftenNum[z][0] = oftenNum[z-1][0];
//							oftenNum[z][1] = oftenNum[z-1][1];
//						}
//					}
//					oftenNum[j][0] = recId; //������ ����� �������������� ������
//					oftenNum[j][1] = counter; //���������� ��������
//					j=5;//������� �� �����
//				}
//			}
//
//		}
//		
//		System.out.println("����� ������� � �����: "+phoneBook.size());
//		for (int i = 0; i < 5; i++) {
//			PhoneBookRecord rec = phoneBook.get(oftenNum[i][0]);
//			System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
//			System.out.println("����������� " + oftenNum[i][1] + " ���.");
//			System.out.println();
//			
//		}
		//���������� ������� ����������
		Long t2 = System.currentTimeMillis();
		int min = (int) (t2 - t1)/60000;
		int sec = (int) (t2 - t1)/1000 - min * 60;
		
		System.out.println("����� ����������: "+min+" ��� "+sec+" ���");
		System.out.println("*******************************************");
	}

	private static void arrTest(){
		System.out.println("������������� �������� ������� ��� �������� ���������� �������");
		Long t1 = System.currentTimeMillis(); //������ ���������� ���������
		
		PhoneBookRecord[] phoneBook = new PhoneBookRecord[recCount];
		
		String operCode; //��� ��������� / ������
		
		for (int i = 0; i<recCount; i++) {
			
			PhoneBookRecord rec = new PhoneBookRecord();
			rec.fio = new FIO();
			
			rec.fio.lastName = "LASTNAME" + i;
			rec.fio.firstName = "FIRSTNAME" + i;
			rec.fio.middleName = "MIDDLENAME" + i;
			operCode = lPad(""+Math.round(Math.random()*1000), 3, '0');
			if (operCode.startsWith("9")) rec.numberType = false;
			else rec.numberType = true;
			
			rec.phoneNumber = "+7 "+operCode+" "+lPad(""+Math.round(Math.random()*1000), 3, '0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0')+"-"+lPad(""+Math.round(Math.random()*100),2,'0');
			//��������� ������:
			phoneBook[i] = rec;
			
		}
		
		//���������� ������� ��������� ������� ���������� �������� �� ��� �� �����
		for (int i = 0; i<recCount; i++) {
			PhoneBookRecord rec = phoneBook[i];
			rec.relatedContList = new int[10];//������������� �������
			//System.out.println("������ ���������� ������ ��� ��������: "+" "+rec.phoneNumber+" (������: "+rec.hashCode()+")");
			
			for (int j = 0; j < 10; j++) {
				rec.relatedContList[j] = (int) Math.round(Math.random()*(recCount-1)); //�������� ������������ ����� � ������ ���������� �������
				//System.out.println("�������� ������������ �����: "+" "+rndCounter);
			}
			
		}
//���� ������ �� ������ ������ ���������:
/*
		for (Iterator<PhoneBookRecord> iter = phoneBook.iterator(); iter.hasNext();) {
			PhoneBookRecord rec = (PhoneBookRecord) iter.next();
			
			System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
			System.out.println("��������� ��������:");
			for (int i=0; i<10; i++){
				for (Iterator<PhoneBookRecord> iterRelCont = phoneBook.iterator(); iterRelCont.hasNext();){
					PhoneBookRecord recRelCont = (PhoneBookRecord) iterRelCont.next();
					if (rec.relatedContList[i] == recRelCont.hashCode()) System.out.print(recRelCont.phoneNumber + " ");
				}
				
			}
			System.out.println();
			
		}
*/
		//����� �������� ����� ������������� ������� (�.�. ��������)
		int[] idCounter = new int[recCount]; //������ ��� �������� ���������� �������� �������� �������
		for (int i=0; i < recCount; i++) idCounter[i] = 0; //������������� ��������
		
		for (int i = recCount-1; i>=0; i--) {//����� ������ ��������� � �������� �������
			
			for (int x = 0; x<10; x++){//���� �� ������ ��������� ���������
				idCounter[phoneBook[i].relatedContList[x]]++; //����������� �������� �������� ��� ���������������� �������
			}
		}
		
		System.out.println();
		System.out.println("����� ������� � �����: "+phoneBook.length);
		//����� 5 ����� ������ ����������
		for (int j=0; j < 5; j++) {
			int id = 0;
			int maxCounter = 0; //�������� �������
			
			for (int i=0; i<recCount; i++){
				if (idCounter[i] > maxCounter) {
					id = i;//�������� id
					maxCounter = idCounter[i];//�������� ���������� ��������
				}
			}
			//�� ������ �� ����� ����� ����� � id ������ ����������� �������������� ������
			//��� ���������� ������� ������� ��� �������:
			idCounter[id] = 0;
			//������� �� �����:
			System.out.println(phoneBook[id].fio.lastName+' '+phoneBook[id].fio.firstName+' '+phoneBook[id].phoneNumber+' '+(phoneBook[id].numberType ? "���������" : "�������"));
			System.out.println("����������� " + maxCounter + " ���.");
			System.out.println();
		}

		
		
		
		
		
		
		
		
		
		
//		//����� �������� ����� ������������� �������
//		int[][] oftenNum = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}; //5 �������� ����� ������������� ������� (index, ���-�� ��������)
//		int debugNum = 0;
//		System.out.println("���������� �������:");
//		
//		for (int x = recCount-1; x>=0; x--) { //����� � �������� �������
//			int counter = 0;
//			debugNum++;
//			if (debugNum%500 == 0) System.out.print(debugNum+" ");
//			
//			//���� ������� ����� � ��������� ��������� ������ �������
//			for (int y = 0; y<recCount; y++){//���� �� ������ �������
//				PhoneBookRecord recRelCont = phoneBook[y]; //�����, � ��������� ��������� �������� ���������
//				
//				for (int i=0; i<10; i++){//���� �� ������ ��������� ���������
//					if (recRelCont.relatedContList[i] == x) counter ++;
//				}
//			}
//
//			for (int j=0; j < 5; j++) {
//				if (oftenNum[j][1] <= counter) {
//					//���� ������� ����� ����������� ���� ������, �������� �� ����� � �������, � ��������� ��������
//					for (int z=4; z >= j; z--) {
//						if (z>0) {
//							oftenNum[z][0] = oftenNum[z-1][0];
//							oftenNum[z][1] = oftenNum[z-1][1];
//						}
//					}
//					oftenNum[j][0] = x; //������ ����� �������������� ������
//					oftenNum[j][1] = counter; //���������� ��������
//					j=5;//������� �� �����
//				}
//			}
//
//		}
//		
//		System.out.println("����� ������� � �����: "+phoneBook.length);
//		for (int i = 0; i < 5; i++) {
//			PhoneBookRecord rec = phoneBook[oftenNum[i][0]];
//			System.out.println(rec.fio.lastName+' '+rec.fio.firstName+' '+rec.phoneNumber+' '+(rec.numberType ? "���������" : "�������"));
//			System.out.println("����������� " + oftenNum[i][1] + " ���.");
//			System.out.println();
//			
//		}
		//���������� ������� ����������
		Long t2 = System.currentTimeMillis();
		int min = (int) (t2 - t1)/60000;
		int sec = (int) (t2 - t1)/1000 - min * 60;
		
		System.out.println("����� ����������: "+min+" ��� "+sec+" ���");
		System.out.println("*******************************************");
	}

	
	public static void main(String[] args) {
		//������������� ������:
		listTest();
		//������������� ���������:
		if (recCount <= 1000) //��� ������� ���������� ������������ ���������� ������� ���������
		setTest();
		//������������� �����:
		mapTest();
		//������������� �������� �������:
		arrTest();
		
	}

}
