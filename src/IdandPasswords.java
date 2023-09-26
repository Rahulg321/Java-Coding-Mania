import java.util.AbstractMap;
import java.util.HashMap;

//contains hash maps of all our stored id and passwords
public class IdandPasswords {
   HashMap<String,String> loginInfo = new HashMap<String, String>();
   IdandPasswords(){
       loginInfo.put("bro","hello");
       loginInfo.put("rahul","Friendship");
       loginInfo.put("rishi","testing");
       loginInfo.put("sam","testing");
       loginInfo.put("name","testing");
       loginInfo.put("shivam","testing");
       loginInfo.put("maniket","testing");
   }

   protected HashMap getLoginCredentials(){
       return loginInfo;
   }



}
