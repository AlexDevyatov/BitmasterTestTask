package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("id")
    private Long id;

    @SerializedName("owner")
    private String owner;

    @SerializedName("secret")
    private String secret;

    @SerializedName("server")
    private Integer server;

    @SerializedName("farm")
    private String farm;

    @SerializedName("title")
    private String title;

    @SerializedName("ispublic")
    private Integer isPublic;

    @SerializedName("isfriend")
    private Integer isFriend;

    @SerializedName("isfamily")
    private Integer isFamily;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getServer() {
        return server;
    }

    public void setServer(Integer server) {
        this.server = server;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getUrl() {
        setUrl("http://farm" + farm + ".static.flickr.com/"
                + server + "/" + id + "_" + secret + ".jpg");
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
