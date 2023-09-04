import java.util.*;

public class Cliente{
    private int id;
    private String nome;

    //Setters
    public void setID(int ID){
        this.id = ID;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }

    //Getters
    public int getID(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    //Construtor
    public Cliente(int ID, String Nome){
        this.id = ID;
        this.nome = Nome;
    }

    public Cliente(){

    }
}