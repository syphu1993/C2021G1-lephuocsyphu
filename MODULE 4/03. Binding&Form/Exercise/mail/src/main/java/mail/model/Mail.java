package mail.model;

public class Mail {
    private int id;
    private String language;
    private int pageSize;
    private boolean enable;
    private String signature;

    public Mail(int id, String language, int pageSize, boolean enable, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.enable = enable;
        this.signature = signature;
    }

    public Mail(String language, int pageSize, boolean enable, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enable = enable;
        this.signature = signature;
    }

    public Mail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
