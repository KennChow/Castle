package castle;

import java.util.HashMap;
//import java.util.HashSet;

public class CastleRooms {
	//  建立一个HashMap用来存城堡的“房间名——房间”的的分布数据；
	//  建立一个函数通过房间名来取得房间
	private HashMap<String, Room> rooms = new HashMap<String,Room>();
	private Room outside, lobby, pub, study, bedroom,toilet,goldRoom;
	public CastleRooms() {
       //	给房间命名
       outside = new Room("城堡外");
       lobby = new Room("大堂");
       pub = new Room("小酒吧");
       study = new Room("书房");
       bedroom = new Room("卧室");
       toilet = new Room("卫生间"); 
       goldRoom = new Room("黄金屋"); 
       //	初始化房间的出口
       outside.setExit("east", lobby);
       outside.setExit("west", pub);
       outside.setExit("south", study);
       lobby.setExit("west", outside);
       lobby.setExit("down", toilet);//
       toilet.setExit("up", lobby);
       pub.setExit("east", outside);
       study.setExit("north", outside);
       study.setExit("east", bedroom);
       bedroom.setExit("west", study);
       study.setExit("down", goldRoom);
       goldRoom.setExit("up",study);
       
      //将房间放入HashMap
      rooms.put("outside",outside);
      rooms.put("lobby",lobby);
      rooms.put("pub",pub);
      rooms.put("study",study);
      rooms.put("bedroom",bedroom);
      rooms.put("underroom",toilet);
   }
   public Room Location(String roomName) {
	    return rooms.get(roomName);
   }
}
