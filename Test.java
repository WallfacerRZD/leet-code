import java.net.Socket;
import java.net.SocketException;

/**
 * @author WallfacerRZD
 * @date 2019/1/10 15:36
 */
public class Test {
    public static void main(String[] args) throws SocketException {
        Socket s = new Socket();
        s.setReceiveBufferSize(1024);
    }
}
