package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Futbolcu {
    private Long id;
    private String isim;
    private String mevki;
    private  int formaNo;
    private Long deger;
    private  Long takimId;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public int getFormaNo() {
        return formaNo;
    }

    public void setFormaNo(int formaNo) {
        this.formaNo = formaNo;
    }

    public Long getDeger() {
        return deger;
    }

    public void setDeger(Long deger) {
        this.deger = deger;
    }

    public Long getTakimId() {
        return takimId;
    }

    public void setTakimId(Long takimId) {
        this.takimId = takimId;
    }

    @Override
    public String toString() {
        return "Futbolcu{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", mevki='" + mevki + '\'' +
                ", formaNo=" + formaNo +
                ", deger=" + deger +
                ", takimId=" + takimId +
                '}';
    }
}
