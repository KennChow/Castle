package castle;

import java.util.HashMap;
//import java.util.HashSet;

public class CastleRooms {
	//  ����һ��HashMap������Ǳ��ġ��������������䡱�ĵķֲ����ݣ�
	//  ����һ������ͨ����������ȡ�÷���
	private HashMap<String, Room> rooms = new HashMap<String,Room>();
	private Room outside, lobby, pub, study, bedroom,toilet,goldRoom;
	public CastleRooms() {
       //	����������
       outside = new Room("�Ǳ���");
       lobby = new Room("����");
       pub = new Room("С�ư�");
       study = new Room("�鷿");
       bedroom = new Room("����");
       toilet = new Room("������"); 
       goldRoom = new Room("�ƽ���"); 
       //	��ʼ������ĳ���
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
       
      //���������HashMap
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
