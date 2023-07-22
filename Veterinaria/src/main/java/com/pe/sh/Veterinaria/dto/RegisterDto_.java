/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.dto;

/**
 *
 * @author shmen
 */
public class RegisterDto_ {

    private String username;
    private String codigove;
    private String password;

    public RegisterDto_() {
    }

    public RegisterDto_(String username, String codigove, String password) {
        this.username = username;
        this.codigove = codigove;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCodigove() {
        return codigove;
    }

    public void setCodigove(String codigove) {
        this.codigove = codigove;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
