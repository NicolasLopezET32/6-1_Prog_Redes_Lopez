package Chat;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainServer {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 5000;

        try ( server servidor = new server(Utils.enumType.SERVER, ip, port) ){
            servidor.setIp(ip);
            servidor.setPort(port);

            servidor.serverOn();
        } catch (UnknownHostException ex) {
            Logger.getLogger(mainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
