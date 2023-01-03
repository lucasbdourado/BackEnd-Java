package com.br.crudswing;

import java.util.Objects;

public class Cliente {
    private String name;
    private long cpf;
    private long phone;
    private String state;
    private String city;
    private String street;
    private Integer number;

    public Cliente(String name, String cpf, String phone, String state, String city, String street, String number) {
        this.name = name;
        this.cpf = Long.parseLong(cpf.trim());
        this.phone = Long.parseLong(phone.trim());
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = Integer.valueOf(number.trim());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf == cliente.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Cliente: {" +
                "Nome='" + name + '\'' +
                ", CPF=" + cpf +
                '}';
    }
}
