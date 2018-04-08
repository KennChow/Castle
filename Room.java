package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> exits = new HashMap<String,Room>();
    //���췿��
    public Room(String description) 
    {
        this.description = description;
    }
    //���ó���
    public void setExit(String direction,Room nextRoom) 
    {
    	exits.put(direction, nextRoom);
    }
    //��ȡ��������
    @Override
    public String toString()
    {
        return description;
    }
    //��ȡ���������Ϣ
    public String getExitDesc() {
    	StringBuffer sb = new StringBuffer();
    	for(String direction : exits.keySet()) {
    		sb.append(direction);
    		sb.append(" ");
    	}
    	return sb.toString();
    	
    }
    //��ȡ������ڶ�Ӧ�ķ���
    public Room getExit(String direction) {
    	return exits.get(direction);
    }
}
