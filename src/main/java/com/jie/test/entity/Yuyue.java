package com.jie.test.entity;

import java.io.Serializable;

/**
 * (Yuyue)实体类
 *
 * @author makejava
 * @since 2020-10-15 15:56:54
 */
public class Yuyue implements Serializable {
    private static final long serialVersionUID = 590821605086183667L;

    private String title;

    private String applyname;

    private String applydate;

    private String guestname;

    private String guesttel;

    private String followcount;

    private String guestdate;

    private String gusettime;

    private String address;

    private String guesttools;

    private String guestcar;

    private String guestfoods;

    private String guestacc;

    private String godate;

    private String gotime;

    private String gotools;

    private String gocar;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApplyname() {
        return applyname;
    }

    public void setApplyname(String applyname) {
        this.applyname = applyname;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getGuesttel() {
        return guesttel;
    }

    public void setGuesttel(String guesttel) {
        this.guesttel = guesttel;
    }

    public String getFollowcount() {
        return followcount;
    }

    public void setFollowcount(String followcount) {
        this.followcount = followcount;
    }

    public String getGuestdate() {
        return guestdate;
    }

    public void setGuestdate(String guestdate) {
        this.guestdate = guestdate;
    }

    public String getGusettime() {
        return gusettime;
    }

    public void setGusettime(String gusettime) {
        this.gusettime = gusettime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuesttools() {
        return guesttools;
    }

    public void setGuesttools(String guesttools) {
        this.guesttools = guesttools;
    }

    public String getGuestcar() {
        return guestcar;
    }

    public void setGuestcar(String guestcar) {
        this.guestcar = guestcar;
    }

    public String getGuestfoods() {
        return guestfoods;
    }

    public void setGuestfoods(String guestfoods) {
        this.guestfoods = guestfoods;
    }

    public String getGuestacc() {
        return guestacc;
    }

    public void setGuestacc(String guestacc) {
        this.guestacc = guestacc;
    }

    public String getGodate() {
        return godate;
    }

    public void setGodate(String godate) {
        this.godate = godate;
    }

    public String getGotime() {
        return gotime;
    }

    public void setGotime(String gotime) {
        this.gotime = gotime;
    }

    public String getGotools() {
        return gotools;
    }

    public void setGotools(String gotools) {
        this.gotools = gotools;
    }

    public String getGocar() {
        return gocar;
    }

    public void setGocar(String gocar) {
        this.gocar = gocar;
    }

    @Override
    public String toString() {
        return "Yuyue{" +
                "title='" + title + '\'' +
                ", applyname='" + applyname + '\'' +
                ", applydate='" + applydate + '\'' +
                ", guestname='" + guestname + '\'' +
                ", guesttel='" + guesttel + '\'' +
                ", followcount='" + followcount + '\'' +
                ", guestdate='" + guestdate + '\'' +
                ", gusettime='" + gusettime + '\'' +
                ", address='" + address + '\'' +
                ", guesttools='" + guesttools + '\'' +
                ", guestcar='" + guestcar + '\'' +
                ", guestfoods='" + guestfoods + '\'' +
                ", guestacc='" + guestacc + '\'' +
                ", godate='" + godate + '\'' +
                ", gotime='" + gotime + '\'' +
                ", gotools='" + gotools + '\'' +
                ", gocar='" + gocar + '\'' +
                '}';
    }
}