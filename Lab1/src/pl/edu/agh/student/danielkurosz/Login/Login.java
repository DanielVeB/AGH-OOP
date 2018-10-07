package pl.edu.agh.student.danielkurosz.Login;


/**
 *
 * @author DanielKurosz
 */
class Login {
    private String login;
    private String password;

    /**
     *
     * @param _login login jaki dana instancja klasy będiz eprzechowywać
     * @param _password hasło jakie dana instancja klasy będiz eprzechowywać
     */
    Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    /**
     *
     * @param _login login do porównania z przechowywanym wewnątrz obiektu
     * @param _password hasło do porównania z przechowywanym wewnatrz obiektu
     * @return prawda, gdy login i hasło zgadzaja sie, fałsz gdy albo login albo hasło nie pasuje do tych rpzechowywanych przez instancję kalsy
     */
    boolean check(String _login, String _password){
        return _login.matches(login) && _password.matches(password);
    }

}