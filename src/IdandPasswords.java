import java.util.AbstractMap;
import java.util.HashMap;

//contains hash maps of all our stored id and passwords
public class IdandPasswords {
   HashMap<String,String> loginInfo = new HashMap<String, String>();
   IdandPasswords(){
       loginInfo.put("bro","hello");
       loginInfo.put("rahulg","Friendship");
       loginInfo.put("surbhi","testing");
   }

   protected HashMap getLoginCredentials(){
       return loginInfo;
   }



}
