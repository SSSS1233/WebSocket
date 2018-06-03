package dao;

import po.Rfid;
import tools.DBTools;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/6/2 16:08.
 * @Comment
 */
public class RfidsDao {
    public Rfid select(String id)
    {
        Rfid rfid=new Rfid();
        String sql=" SELECT *from rfid WHERE card_id=?";
        List<Object[]> l=DBTools.excuteQuery(sql,id);
        if(!l.isEmpty()) {
            Object[] o = l.get(0);
            rfid.setCard_id((String) o[1]);
            rfid.setType((String) o[2]);
        }else {
            return null;
        }
        return rfid;
    }
    public void insert(Rfid rfid)
    {
        String sql="INSERT INTO rfiddata VALUE(null,?,?)";
        int i=DBTools.excuteUpdate(sql,rfid.getCard_id(),rfid.getType());
        if(i>0)
            System.out.println("插入成功");
    }


}
