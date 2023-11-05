package org.example.dto;

import lombok.Getter;
import lombok.Setter;

/*
id name address phone
1 Lyngby Plantecenter Firskovvej 18 33212334
2 Glostrup Planter Tværvej 35 32233232
3 Holbæk Planteskole Stenhusvej 49 59430945
 */
@Setter
@Getter
public class ResellerDTO
{
    private int id;
    private String name;
    private String address;
    private int phone;

    public ResellerDTO(String name, String address, int phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}