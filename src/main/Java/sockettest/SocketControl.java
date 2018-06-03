package sockettest;

import dao.RfidDao;
import dao.RfidsDao;
import org.apache.ibatis.session.SqlSession;
import po.Rfid;
import utils.MybatisUtil;

/**
 * Created by Intellij IDEA.
 *
 * @Author SUBING
 * @Date 2018/5/24 23:33.
 * @Comment
 */
public class SocketControl {

   public static SqlSession sqlSession ;
   public static void select(String card_id)
   {
    /*  sqlSession = MybatisUtil.getSqlSession();
      RfidDao rfidDao = sqlSession.getMapper(RfidDao.class);*/
      RfidsDao rfidsDao=new RfidsDao();
      System.out.println("id="+card_id);
      Rfid rfid=rfidsDao.select(card_id);
      if(rfid!=null){
         rfidsDao.insert(rfid);
      }
     // System.out.println(rfid+"LLL");

    /*  if(rfid==null) {
         MybatisUtil.closeSession(sqlSession);
        // return false;
      }
      else{
         rfidDao.insert(rfid);
         sqlSession.commit();
         MybatisUtil.closeSession(sqlSession);
        // return true;
      }*/

   }
   public static String selects()
   {
      sqlSession = MybatisUtil.getSqlSession();
      RfidDao rfidDao = sqlSession.getMapper(RfidDao.class);
      Rfid rfid=rfidDao.selects();
      System.out.println(rfid);
      return rfid.getType();
   }




}
