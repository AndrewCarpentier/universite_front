package fr.andrew.universite.universite_front.utils.repository;

public enum url {

    urlF("http://localhost:65000/");

    private final String url;

    url(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
