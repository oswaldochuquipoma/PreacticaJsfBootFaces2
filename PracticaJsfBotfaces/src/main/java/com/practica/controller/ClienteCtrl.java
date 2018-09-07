
package com.practica.controller;

import com.practica.controllerimpl.ClienteCtrlImpl;
import com.practica.dao.ClienteDAO;
import com.practica.modell.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "clienteCtrl")
@SessionScoped
public class ClienteCtrl implements Serializable {

    private Cliente selected;
    private boolean est;
    ClienteDAO cldao;
    private ArrayList<Cliente> list = new ArrayList<>();

    public ClienteCtrl() {
        this.selected = new Cliente();
        this.cldao = new ClienteCtrlImpl();
    }

    public void createCliente() {        
        if (cldao.createCliente(selected)) {
            System.out.println("Insertado");
        } else {
            System.out.println("Error al momento de insertar");
        }
    }

    public ArrayList<Cliente> getList() {
        list = cldao.readCliente();
        return list;
    }

    public void updateCliente(Cliente cl) {
        System.out.println("cliente = "+cl.nombres_razon_social());
        if (cldao.updateCliente(cl)) {
            System.out.println("Actualizado");
        } else {
            System.out.println("Error al momento de actualizar");
        }
    }
    public void deleteCliente(String id){
        
        if (cldao.deletecliente(id)) {
            System.out.println("Eliminado"+id);
        } else {
            System.out.println("Error al momento de eliminar");
        }
    }
    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

}
