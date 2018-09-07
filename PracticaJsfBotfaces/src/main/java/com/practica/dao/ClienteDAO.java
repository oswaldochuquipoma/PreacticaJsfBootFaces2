package com.practica.dao;

import com.practica.modell.Cliente;
import java.util.ArrayList;

public interface ClienteDAO {
    public boolean createCliente(Cliente cl);
    public ArrayList<Cliente> readCliente();
    public boolean updateCliente(Cliente cl);
    public boolean deleteCliente(String id);

}
