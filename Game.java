package castle;
/*	城堡游戏介绍：
 *  1、建立Room类表示房间，CastleRooms表示城堡的房间分布情况，Game表示主程序游戏
 *  2、Room：通过HashMap建立每个出口对应的房间；
 *  3、CastleRooms：通过HashMap建立“房间名——房间”的集合，以及构造每个房间的出口和分布；相当于MVC的Model;
 *  4、Game：主程序。建立了内部类Handler，通过switch-case方式，表示各个命令对应的执行程序；按每行的方式将欢迎语句分开，放入ArrayList，并在构造的时候初始化欢迎语句；
 *  这样的设计方式的好处：
 *  1、如果需要添加命令，只需要修改内部类Handler，避免按照每个命令一个子类的方式，建立很多类，很大程序上简化了程序；
 *  2、如果需要改变欢迎语句，只需要在构造的时候改写；
 *  3、如果需要修改房间布局，只需要修改CastleRooms类；
 *  4、按照MVC的原则，尽量使得数据保持独立；比如“房间布局”，将控制和表现结合到Game类里面；
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private CastleRooms castlerooms;	//城堡房间分布
    private ArrayList<String> lines= new ArrayList<String>();	//放置欢迎语句 
    //创建命令的内部类
    private class Handler {   
    	private boolean r = false;
    	//通过switch-case执行不同的命令
    	public void docmd(String[] cmd) {
    		switch (cmd[0]) {
    		case "bye":
    			r = true;
    			break;
    		case "help":
    			System.out.print("迷路了吗？你可以输入：go bye help");
                System.out.println("如：\tgo east");
                break;
    		case "go":
    			goRoom(cmd[1]);
    			break;
    		default :
    			System.out.println("你输入的命令错误！你可以做的命令有：go bye help");
    		}
    	}
    	public boolean isBye() {return r;}
    }
    //构造函数
    public Game() 
    {
    	//初始化欢迎语句
    	//lines.add("------------------------");
    	lines.add("欢迎来到城堡！");
    	lines.add("这是一个超级无聊的游戏。");
    	lines.add("如果需要帮助，请输入 'help' 。");
    	//lines.add("-------华丽的分割线---------");
    	//初始化城堡房间和开始位置   	
    	castlerooms = new CastleRooms();
        currentRoom = castlerooms.Location("outside");  //	从城堡门外开始
    }
    //展示出口
    public void showPromt() {
    	 System.out.print("出口有：");
         System.out.println(currentRoom.getExitDesc());
    }
    //欢迎
    private void printWelcome() {
        for(String k: lines) {
        	System.out.println(k);//一行一行打印欢迎来到城堡等欢迎语句
        }
        System.out.println("现在你在" + currentRoom);
        showPromt();
    }
    // 去某个方向的房间
    public void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom == null) {
            System.out.println("那里没有门！请重新输入！");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("现在你在" + currentRoom);
            showPromt();
        }
    }
    //开始游戏
    public void play() {
    	Scanner in = new Scanner(System.in);
    	Handler handler = new Handler();	
    	while(true) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		handler.docmd(words);
    		if(handler.isBye()) {
    			System.out.println("欢迎下次光临，再见！");
    			break;
    		}
    	}
    	in.close();
    }
	//主程序
	public static void main(String[] args) {
	
		Game game = new Game();
		game.printWelcome();	//打印欢迎页面
		game.play();            //开始游戏
	}
}
