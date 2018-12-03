package uz.protokol.asbt.eprotokol.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class LoginResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("id")
    private String id;

    @SerializedName("jeton")
    private String jeton;

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    @SerializedName("district")
    private String district;

    @SerializedName("otr")
    private String otr;

    @SerializedName("mg")
    private String mg;

    @SerializedName("role")
    private String role;

    @SerializedName("regionname")
    private String regionName;

    @SerializedName("districtname")
    private String districtName;

    @SerializedName("otrname")
    private String otrName;

    @SerializedName(".issued")
    private Date issued;

    @SerializedName(".expires")
    private Date expires;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getOtr() {
        return otr;
    }

    public void setOtr(String otr) {
        this.otr = otr;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getOtrName() {
        return otrName;
    }

    public void setOtrName(String otrName) {
        this.otrName = otrName;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", id='" + id + '\'' +
                ", jeton='" + jeton + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", otr='" + otr + '\'' +
                ", mg='" + mg + '\'' +
                ", role='" + role + '\'' +
                ", regionName='" + regionName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", otrName='" + otrName + '\'' +
                ", issued=" + issued +
                ", expires=" + expires +
                '}';
    }
}
