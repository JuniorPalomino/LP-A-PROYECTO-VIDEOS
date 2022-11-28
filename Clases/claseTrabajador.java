package Clases;

public class claseTrabajador extends clasePersona {

    Double sueldo;
    String acceso;
    String login;
    String password;

    public claseTrabajador() {
    }

    public claseTrabajador(Double sueldo, String acceso, String login, String password) {
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.login = login;
        this.password = password;

    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
