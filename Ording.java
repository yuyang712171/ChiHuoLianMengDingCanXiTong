import java.util.Scanner;

public class Ording {

	/**
	 * �Ի����˶���ϵͳ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//�������� һ�鶩����Ϣ
		String[]names=new String[4];//�Ͳ���
		String[]dishMegs=new String[4];//������Ʒ��Ϣ
		int[]times=new int[4];//�Ͳ�ʱ��
		String[]addresses=new String[4];//�Ͳ͵�ַ
		int[]states=new int[4];//����״̬ 0����Ԥ��    1�������
		double[]sumPrices=new double[4];//�ܽ��
		
		//��ʼ������������Ϣ
		names[0]="����";
		dishMegs[0]="������˿1��";
		times[0]=12;
		addresses[0]="���·209��";
		states[0]=1;
		sumPrices[0]=24;
		
		
		names[1]="����";
		dishMegs[1]="���մ���2��";
		times[1]=12;
		addresses[1]="���·209��";
		states[1]=0;
		sumPrices[1]=76;
		
		//�������壺����һ���Ʒ��Ϣ
		String[]dishNames={"���մ���","������˿","ʱ���߲�"};//��Ʒ����
		double[]prices={38.0,18.0,10.0};//��Ʒ�۸�
		int[]praiseNums=new int[3];//������
		
		
//		 1��       ѭ���� do-while )
//		 2��      ѭ��������
//			��ʾ���˵�
//			��ʾ�û����빦�ܱ�ţ���ִ����Ӧ�Ĺ���
//			��ʾ����0����
//		 3��      ѭ��������
//			����0	 
//		 4��      ��֧��if  switch������ʾ�û����빦�ܱ�ţ���            ִ����Ӧ�Ĺ���
		Scanner input=new Scanner(System.in);
		
		int num=-1;
		do{   
//			ѭ��������
//			   ��ʾ���˵�
			System.out.println("************************************");
			System.out.println("1.��Ҫ����");
			System.out.println("2.�鿴�ʹ�");
			System.out.println("3.ǩ�ն���");
			System.out.println("4.ɾ������");
			System.out.println("5.��Ҫ����");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("************************************");
			
			System.out.print("��ѡ��");
			int choose=input.nextInt();//��¼�û�ѡ��Ĺ��ܱ��
			boolean isAdd=false;//true:��¼���ҵ�һ��Ϊ�յ�λ��   false��û�ҵ�
			//�����û�����Ĺ��ܱ�ţ�ִ����Ӧ�Ĺ���
			switch(choose){
				case 1:
					//1.��Ҫ����
					System.out.println("**************��Ҫ����***********");
					//����Ҫ�����λ��
					for(int i=0;i<names.length;i++){
						//���Ҫ�ҵ�Ϊ�յ�λ�ü�¼����
						while(names[i]==null){
							isAdd=true;//��¼���ҵ�һ��Ϊ�յ�λ��
						//ִ�в������
							//a.��ʾ�ɹ�ѡ��Ĳ�Ʒ��Ϣ
							System.out.println("���\t��Ʒ��\t����\t������");
							for(int j=0;j<dishNames.length;j++){
								String price=prices[j]+"Ԫ";
								String praise=praiseNums[j]+"��";
								System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
							}
							//�û�������ѡ��Ʒ��ż�����
							System.out.print("��������ѡ��Ʒ��ţ�");
							int chooseDish=input.nextInt();
							System.out.print("�������Ʒ������");
							int number=input.nextInt();
							String dishMeg=dishNames[chooseDish-1]+" "+number+"��";
							
							//b.���붩��������
							System.out.print("�����붩����������");
							String name=input.next();
							
							//c.�����Ͳ�ʱ��10~20��
							System.out.print("�������Ͳ�ʱ�䣨10~20�����Ͳͣ���");
							int time=input.nextInt();
							//��������������
							if(time<10||time>20){
								System.out.print("������������������10~20���������");
								time=input.nextInt();
							}
							//d.�����Ͳ͵�ַ
							System.out.print("�������Ͳ͵�ַ��");
							String address=input.next();
							
							//e.����ͷ�
							double sumPrice=prices[chooseDish-1]*number;
							//�ܽ�����50Ԫʱ ��6Ԫ�Ͳͷ�
							double deliCharge=sumPrice>=50?0.0:6.0;
							//3.��ʾ������Ϣ
							System.out.println("���ͳɹ�");
							System.out.println("�����ˣ�"+name);
							System.out.println("�������ǣ�"+dishMeg);
							System.out.println("�Ͳ�ʱ�䣺"+time+"��");
							System.out.println("�Ͳ͵�ַ��"+address);
							System.out.println("�ͷѣ�"+sumPrice+",�Ͳͷѣ�"+deliCharge+"Ԫ");
							System.out.println("�����ܽ�"+(sumPrice+deliCharge)+"Ԫ");
							
							//4.�������б�������
							names[i]=name;
							dishMegs[i]=dishMeg;
							times[i]=time;
							addresses[i]=address;
							sumPrices[i]=sumPrice+deliCharge;
						break;	
						}
					}
					if(!isAdd){
						System.out.println("�Բ���,���Ĳʹ�������");
					}
					//���û���ҵ�Ϊ�յ�λ�ã�����ʾ��Ϣ
					break;
				case 2:
					//2.�鿴�ʹ�
					System.out.println("************�鿴�ʹ�************");
					System.out.println("���\t������\t������Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t\t�ܽ��\t״̬");
					//��������
					for(int i=0;i<names.length;i++){
						if(names[i]!=null){
						String time=times[i]+"��";
						String sumPrice=sumPrices[i]+"Ԫ";
						String state=states[i]==0?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
						}
					}
					break;
				case 3:
					//3.ǩ�ն���
//					ǩ�ն���
					System.out.println("************ǩ�ն���*************");
	//			     Ҫ���û�����һ��Ҫǩ�յĶ������
					System.out.print("������һ��Ҫǩ�յĶ�����ţ�");
					int xuHao=input.nextInt();
					boolean isfind=false;//��ʶ�����Ƿ��ҵ� true���ҵ�  false��û�ҵ�
	//			     ��������������ѭ��������
					for(int i=0;i<names.length;i++){
		//					1���ҵ���״̬������ɣ��Ѿ�ǩ����ϣ�����ʾ�����ٴ�ǩ��
						if(names[i]!=null&&states[i]==1&&xuHao==i+1){
							System.out.println("�Բ��𣬶�����ǩ�գ������ٴ�ǩ��");
							isfind=true;
							break;
	//						2���ҵ���״̬����Ԥ����û�����ǩ�գ�������ǩ��
						}else if(names[i]!=null&&states[i]==0&&xuHao==i+1){
							states[i]=1;
							System.out.println("����ǩ�ճɹ���");
							isfind=true;
							break;
						}
					}//3��û�ҵ�����ʾ��Ϣû���ҵ�
					if(!isfind){
						System.out.println("������Ķ���������");
					}
					break;
				case 4:
					//4.ɾ������
					System.out.println("************ɾ������**********");
				//����Ҫɾ���Ķ���
					System.out.print("������Ҫɾ���Ķ�����ţ�");
					int delId=input.nextInt();
					int delIndex=-1;//Ҫɾ���Ķ������±�
					boolean isDelFind=false;//��ʶ��Ҫɾ���Ķ����Ƿ��ҵ� true:�ҵ�   false��δ�ҵ�
				//ѭ����������Ҫɾ���Ķ���
					for(int i=0;i<names.length;i++){
	     				//�ҵ��˶�������ǩ�գ�ִ��ɾ������
						// �ҵ��˶�������δǩ�գ���ʾ��Ϣ
						if(names[i]!=null&&states[i]==1&&delId==i+1){
							delIndex=i;
							isDelFind=true;
							break;
						}else if(names[i]!=null&&states[i]==0&&delId==i+1){
							System.out.println("�˶���δǩ�գ�����ɾ����");
							isDelFind=true;
							break;
						}
					}//δ�ҵ��˶�������ʾ��Ϣ
					if(!isDelFind){
						System.out.println("�Բ��𣬴˶��������ڣ�");
					}
				//ִ��ɾ��������ѭ����λ��
					if(delIndex!=-1){
						//ɾ��������ѭ����λ��
						// ��Ҫɾ����Ԫ�غ���һ����ʼ�����������һ��Ԫ��������ǰ�ƶ�һλ
						for(int i=delIndex+1;i<names.length-1;i++){
							names[i-1]=names[i];
							dishMegs[i-1]=dishMegs[i];
							times[i-1]=times[i];
							addresses[i-1]=addresses[i];
							states[i-1]=states[i];
						}
						//���һλ���
						names[names.length-1]=null;//�ַ����͵ĸ�ֵΪnull
						dishMegs[names.length-1]=null;//�ַ����͵ĸ�ֵΪnull
						times[names.length-1]=0;//���͵ĸ�ֵΪ0
						addresses[names.length-1]=null;//�ַ����͵ĸ�ֵΪnull
						states[names.length-1]=0;//���͵ĸ�ֵΪ0
						//��ʾɾ���ɹ�
						System.out.println("����ɾ���ɹ���");
					}
					break;
				case 5:
					//5.��Ҫ����
					System.out.println("**************��Ҫ����***************");
//					1����ʾ�����޵Ĳ�Ʒ�б�
					System.out.println("���\t��Ʒ��\t����\t������");
					for(int j=0;j<dishNames.length;j++){
						String price=prices[j]+"Ԫ";
						String praise=praiseNums[j]+"��";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
					}
//				     2������Ҫ���޵Ĳ�Ʒ���
					System.out.print("������Ҫ���޵Ĳ�Ʒ��ţ�");
					int dishId=input.nextInt();
//				     3������ŵĲ�Ʒ��������һ
					praiseNums[dishId-1]++;
//				     4����ʾ
					System.out.println("���޳ɹ�");
					System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"��");
					break;
				case 6:
					//6.�˳�ϵͳ
					break;
				default:
					break;
			}
			//���û����빦�ܱ��Ϊ1~5֮�������ʱ���˳�ѭ�����������ʾ����0����
			if(choose<1||choose>5){
				break;
			}else{
			//��ʾ����0����
			System.out.print("����0���أ�");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
