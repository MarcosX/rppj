package strategy;

import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoFaceNoteLogin {

    private static Logger logger = Logger.getLogger(ServicoFaceNoteLogin.class.getName());

    public int autenticar(String idUsuario) {
        try {
            return autenticarViaPost(idUsuario);
        } catch (TimeoutException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return 500;
    }

    private int autenticarViaPost(String idUsuario) throws TimeoutException{
        // Implementação não importa
        return 200;
    }
}
