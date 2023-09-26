import javax.xml.soap.Text;

public class Main {
    public static void main(String[] args) {
        IdandPasswords idandpasswords = new IdandPasswords();
        LoginPage loginpage = new LoginPage(idandpasswords.getLoginCredentials());
        // Quiz quiz = new Quiz("maniket");
    }

}