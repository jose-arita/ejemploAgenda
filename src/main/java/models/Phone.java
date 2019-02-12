/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class Phone {
    
    private int id;
    private String number;
    private int costumerId;
    private String costumerName;
    private int typeId;
    private String typeName;

    public Phone(int costumerId, int typeId, String number) {
        this.number = number;
        this.costumerId = costumerId;
        this.typeId = typeId;
    }

    public Phone(int id, String number, int costumerId, String costumerName, int typeId, String typeName) {
        this.id = id;
        this.number = number;
        this.costumerId = costumerId;
        this.costumerName = costumerName;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getCostumerId() {
        return costumerId;
    }

    public String getCostumerName() {
        return costumerName;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCostumerId(int costumerId) {
        this.costumerId = costumerId;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
   
}
