import java.util.Scanner;

public class Ording {

	/**
	 * 吃货联盟订餐系统
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//数据主体 一组订单信息
		String[]names=new String[4];//送餐人
		String[]dishMegs=new String[4];//所定餐品信息
		int[]times=new int[4];//送餐时间
		String[]addresses=new String[4];//送餐地址
		int[]states=new int[4];//订单状态 0：已预定    1：已完成
		double[]sumPrices=new double[4];//总金额
		
		//初始化两条订单信息
		names[0]="张晴";
		dishMegs[0]="鱼香肉丝1份";
		times[0]=12;
		addresses[0]="天成路209号";
		states[0]=1;
		sumPrices[0]=24;
		
		
		names[1]="张晴";
		dishMegs[1]="红烧带鱼2份";
		times[1]=12;
		addresses[1]="天成路209号";
		states[1]=0;
		sumPrices[1]=76;
		
		//数据主体：定义一组餐品信息
		String[]dishNames={"红烧带鱼","鱼香肉丝","时令蔬菜"};//餐品类型
		double[]prices={38.0,18.0,10.0};//餐品价格
		int[]praiseNums=new int[3];//点赞数
		
		
//		 1、       循环（ do-while )
//		 2、      循环操作：
//			显示主菜单
//			提示用户输入功能编号，并执行相应的功能
//			提示输入0返回
//		 3、      循环条件：
//			输入0	 
//		 4、      分支（if  switch）：提示用户输入功能编号，并            执行相应的功能
		Scanner input=new Scanner(System.in);
		
		int num=-1;
		do{   
//			循环操作：
//			   显示主菜单
			System.out.println("************************************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("************************************");
			
			System.out.print("请选择：");
			int choose=input.nextInt();//记录用户选择的功能编号
			boolean isAdd=false;//true:记录已找到一个为空的位置   false：没找到
			//根据用户输入的功能编号，执行相应的功能
			switch(choose){
				case 1:
					//1.我要订餐
					System.out.println("**************我要订餐***********");
					//查找要插入的位置
					for(int i=0;i<names.length;i++){
						//如果要找到为空的位置记录下来
						while(names[i]==null){
							isAdd=true;//记录已找到一个为空的位置
						//执行插入操作
							//a.显示可供选择的餐品信息
							System.out.println("序号\t餐品名\t单价\t点赞数");
							for(int j=0;j<dishNames.length;j++){
								String price=prices[j]+"元";
								String praise=praiseNums[j]+"赞";
								System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
							}
							//用户输入所选餐品编号及份数
							System.out.print("请输入所选餐品编号：");
							int chooseDish=input.nextInt();
							System.out.print("请输入餐品餐数：");
							int number=input.nextInt();
							String dishMeg=dishNames[chooseDish-1]+" "+number+"份";
							
							//b.输入订餐人姓名
							System.out.print("请输入订餐人姓名：");
							String name=input.next();
							
							//c.输入送餐时间10~20点
							System.out.print("请输入送餐时间（10~20整点送餐）：");
							int time=input.nextInt();
							//如果输错，重新输入
							if(time<10||time>20){
								System.out.print("您的输入有误，请输入10~20点的整数：");
								time=input.nextInt();
							}
							//d.输入送餐地址
							System.out.print("请输入送餐地址：");
							String address=input.next();
							
							//e.计算餐费
							double sumPrice=prices[chooseDish-1]*number;
							//总金额大于50元时 免6元送餐费
							double deliCharge=sumPrice>=50?0.0:6.0;
							//3.显示订单信息
							System.out.println("订餐成功");
							System.out.println("订餐人："+name);
							System.out.println("您订的是："+dishMeg);
							System.out.println("送餐时间："+time+"点");
							System.out.println("送餐地址："+address);
							System.out.println("餐费："+sumPrice+",送餐费："+deliCharge+"元");
							System.out.println("订单总金额："+(sumPrice+deliCharge)+"元");
							
							//4.向数组中保存数据
							names[i]=name;
							dishMegs[i]=dishMeg;
							times[i]=time;
							addresses[i]=address;
							sumPrices[i]=sumPrice+deliCharge;
						break;	
						}
					}
					if(!isAdd){
						System.out.println("对不起,您的餐袋已满！");
					}
					//如果没有找到为空的位置，则提示信息
					break;
				case 2:
					//2.查看餐袋
					System.out.println("************查看餐袋************");
					System.out.println("序号\t订餐人\t所订餐品信息\t送餐时间\t送餐地址\t\t总金额\t状态");
					//遍历数组
					for(int i=0;i<names.length;i++){
						if(names[i]!=null){
						String time=times[i]+"点";
						String sumPrice=sumPrices[i]+"元";
						String state=states[i]==0?"已预定":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
						}
					}
					break;
				case 3:
					//3.签收订单
//					签收订单
					System.out.println("************签收订单*************");
	//			     要求用户输入一个要签收的订单序号
					System.out.print("请输入一个要签收的订单序号：");
					int xuHao=input.nextInt();
					boolean isfind=false;//标识订单是否找到 true：找到  false：没找到
	//			     查找这条订单（循环遍历）
					for(int i=0;i<names.length;i++){
		//					1、找到，状态是已完成（已经签收完毕）：提示不能再次签收
						if(names[i]!=null&&states[i]==1&&xuHao==i+1){
							System.out.println("对不起，订单已签收，不能再次签收");
							isfind=true;
							break;
	//						2、找到，状态是已预定（没有完成签收）：可以签收
						}else if(names[i]!=null&&states[i]==0&&xuHao==i+1){
							states[i]=1;
							System.out.println("订单签收成功！");
							isfind=true;
							break;
						}
					}//3、没找到：提示信息没有找到
					if(!isfind){
						System.out.println("您输入的订单不存在");
					}
					break;
				case 4:
					//4.删除订单
					System.out.println("************删除订单**********");
				//输入要删除的订单
					System.out.print("请输入要删除的订单序号：");
					int delId=input.nextInt();
					int delIndex=-1;//要删除的订单的下标
					boolean isDelFind=false;//标识：要删除的订单是否找到 true:找到   false：未找到
				//循环查找这条要删除的订单
					for(int i=0;i<names.length;i++){
	     				//找到此订单，已签收：执行删除操作
						// 找到此订单，且未签收：提示信息
						if(names[i]!=null&&states[i]==1&&delId==i+1){
							delIndex=i;
							isDelFind=true;
							break;
						}else if(names[i]!=null&&states[i]==0&&delId==i+1){
							System.out.println("此订单未签收，不能删除！");
							isDelFind=true;
							break;
						}
					}//未找到此订单：提示信息
					if(!isDelFind){
						System.out.println("对不起，此订单不存在！");
					}
				//执行删除操作（循环移位）
					if(delIndex!=-1){
						//删除操作（循环移位）
						// 从要删除的元素后面一个开始，到数组最后一个元素依次向前移动一位
						for(int i=delIndex+1;i<names.length-1;i++){
							names[i-1]=names[i];
							dishMegs[i-1]=dishMegs[i];
							times[i-1]=times[i];
							addresses[i-1]=addresses[i];
							states[i-1]=states[i];
						}
						//最后一位清空
						names[names.length-1]=null;//字符串型的赋值为null
						dishMegs[names.length-1]=null;//字符串型的赋值为null
						times[names.length-1]=0;//整型的赋值为0
						addresses[names.length-1]=null;//字符串型的赋值为null
						states[names.length-1]=0;//整型的赋值为0
						//提示删除成功
						System.out.println("订单删除成功！");
					}
					break;
				case 5:
					//5.我要点赞
					System.out.println("**************我要点赞***************");
//					1、显示供点赞的餐品列表
					System.out.println("序号\t餐品名\t单价\t点赞数");
					for(int j=0;j<dishNames.length;j++){
						String price=prices[j]+"元";
						String praise=praiseNums[j]+"赞";
						System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
					}
//				     2、输入要点赞的餐品序号
					System.out.print("请输入要点赞的餐品序号：");
					int dishId=input.nextInt();
//				     3、该序号的餐品点赞数加一
					praiseNums[dishId-1]++;
//				     4、显示
					System.out.println("点赞成功");
					System.out.println(dishNames[dishId-1]+" "+praiseNums[dishId-1]+"赞");
					break;
				case 6:
					//6.退出系统
					break;
				default:
					break;
			}
			//当用户输入功能编号为1~5之外的数字时，退出循环；否则会提示输入0返回
			if(choose<1||choose>5){
				break;
			}else{
			//提示输入0返回
			System.out.print("输入0返回：");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临！");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
