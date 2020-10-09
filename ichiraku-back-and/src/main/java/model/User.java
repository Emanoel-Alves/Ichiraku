package model;

public class User {
	 
    int id;
    String login;
    String password;
    String email;
    String senha;
    String confSenha;
 
    public User(int id, String login, String password, String email, String senha, String confSenha) {
        super();
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.senha = senha;
        this.confSenha = confSenha;
    }
 
    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email  + ", senha=" + senha   + ", confSenha=" + confSenha +"]";
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
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
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }
 
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getConfSenha() {
        return confSenha;
    }
 
    public void setConfSenha(String confSenha) {
        this.confSenha = confSenha;
    }
}