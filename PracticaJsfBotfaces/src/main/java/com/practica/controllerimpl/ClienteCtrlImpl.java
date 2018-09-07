
package com.practica.controllerimpl;

import com.practica.modell.Cliente;
import com.practica.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.practica.dao.ClienteDAO;


public class ClienteCtrlImpl implements ClienteDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Cliente> listDatos;

    public ClienteCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createCliente(Cliente cl) {
        sql = "INSERT INTO public.cliente(id_cliente, nombres_razon_social, telefono, correo, dni_ruc) "
                + "values ("+cl.getId_cliente()+",'"+ cl.getNombres_razon_social()+"',"
                + "'"+cl.getTelefono()+"','"+cl.getTelefono()+"','"+cl.getCorreo()+"','"+cl.getDni_ruc()+"') ";
     return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Cliente> readCliente() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_cliente, nombres_razon_social, telefono, correo, dni_ruc from public.cliente";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Cliente(rs.getString("id_cliente"),rs.getString("nombres_razon_social"),rs.getString("telefono"),
                        rs.getString("correo"), rs.getString("dni_ruc")));

           }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateCliente(Cliente cl) {
        sql = "UPDATE  public.cliente "
                + "SET name_cat = '" +cl.getId_cliente()+",'"+ cl.getNombres_razon_social()+"',"
                + "'"+cl.getTelefono()+"','"+cl.getTelefono()+"','"+cl.getCorreo()+"','"+cl.getDni_ruc()+"'))"
                + " WHERE id_cliente = "+cl.getId_cliente()+ "";
     return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteCliente(int id) {
        sql = "DELETE  public.cliente "
              + " WHERE id_cliente = "+id+ "";
     return cx.executeInsertUpdate(sql);
    }

   
}
