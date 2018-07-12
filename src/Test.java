import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        UserManager manager=UserManager.getInstance();
        List<Message> list=manager.getSortedMessage(1);
        for (Message message:list)
            System.out.println(message.toString());
    }
}
