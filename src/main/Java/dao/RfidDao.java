package dao;

import po.Rfid;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/27 16:11.
 * @Comment
 */
public interface RfidDao {
    public Rfid select(String card_id);
    public void insert(Rfid rfid);
    public Rfid selects();
}
