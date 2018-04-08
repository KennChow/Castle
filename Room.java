package castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String,Room> exits = new HashMap<String,Room>();
    //构造房间
    public Room(String description) 
    {
        this.description = description;
    }
    //设置出口
    public void setExit(String direction,Room nextRoom) 
    {
    	exits.put(direction, nextRoom);
    }
    //获取房间描述
    @Override
    public String toString()
    {
        return description;
    }
    //获取房间出口信息
    public String getExitDesc() {
    	StringBuffer sb = new StringBuffer();
    	for(String direction : exits.keySet()) {
    		sb.append(direction);
    		sb.append(" ");
    	}
    	return sb.toString();
    	
    }
    //获取房间出口对应的房间
    public Room getExit(String direction) {
    	return exits.get(direction);
    }
}
