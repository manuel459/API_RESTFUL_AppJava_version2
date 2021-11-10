
package org.rest.servicio;

import java.util.List;
import org.rest.dao.BaseDeDatos;
import org.rest.modelo.usuario;

public class UsuarioServicio {

   private List<usuario> listado = BaseDeDatos.getInstancia().getListado();
   
   public List<usuario> getUsuarios(){
   return listado;
   }
     //Metodo get que retorna la lista almacenada segun el id
   public usuario getUsuario(int id){
       for(usuario usu: listado){
       if(usu.getId()==id){
       return usu;
         }
       }
       return null;
   }
   //metodo add que establece un nuevo usuario 
   public usuario addUsuario(usuario usu){
    usu.setId(getMaximo());
    listado.add(usu);
    return usu;
   }
   
   
   //metodo que permite hacer un update de los usuarios 
   public usuario updateUsuario(usuario usu){
    int posicion = getPosicion(usu.getId());
    try{
      listado.set(posicion, usu);
    }catch(IndexOutOfBoundsException ioobe){
    return null;
    }
    return usu;
   }
   //Metodo que elimina al usuario de la lista segun el id
   public void deleteUsuario(int id){
      int posicion = getPosicion(id);
      listado.remove(posicion);
   }
    //metodo que determina o mapea la poscicion de un usuario segun su id
   private int getPosicion(int id){
   for(int i=0; i<listado.size();i++){
    if(listado.get(i).getId()== id){
    return i;
      }
     }
   return -1;
   }
   
   //Metodo para autoincrementar el id cada vez que se agrega          
   public int getMaximo(){
    int size = listado.size();
     if(size>0){
      return listado.get(size - 1).getId()+1;
    }else{
      return 1;
    }
   }
   
  
}
