package modeloVO;
public class UsuarioVO {
    private String usuId, usuLogin, usuPassword;

    public UsuarioVO(String usuId, String usuLogin, String usuPassword) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
    }

    public UsuarioVO() {

    }



    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLigon) {
        this.usuLogin = usuLigon;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }
    
}
