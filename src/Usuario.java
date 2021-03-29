
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 */
public abstract class Usuario {
    /**
     *
     */
    private String email;

    /**
     *
     */
    private String nick;

    /**
     *
     */
    private String contraseña;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @param email
     * @param nick
     * @param contraseña
     */
    public Usuario(String email, String nick, String contraseña) {
        this.email = email;
        this.nick = nick;
        this.contraseña = contraseña;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return nick
     */
    public String getNick() {
        return this.nick;
    }

    /**
     * @return contraseña
     */
    public String getContraseña() {
        return this.contraseña;
    }

    /**
     * @param newMail
     */
    public boolean cambiarEmail(String newMail) {
        if (Pattern.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$", newMail)) {
            this.email = newMail;
            return true;
        } else
            return false;
    }

    /**
     * @param newNick
     */
    public void cambiarNick(String newNick) {
        this.nick = nick;
    }

    /**
     * @param newPass
     */
    public void cambiarContraseña(String newPass) {
        this.contraseña = newPass;
    }

}