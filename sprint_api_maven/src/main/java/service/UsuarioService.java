package service;

import java.sql.ResultSet;
import dao.Dao;
import model.Usuario;

public class UsuarioService {

	public static void InserirUsuario(Usuario u) {  
        String query = String.format("INSERT INTO tb_usuario(id,nome,idade,email,deficiencia,cep,uf,localidade) VALUES(%s,'%s',%s,'%s','%s','%s','%s','%s')", u.getId(), u.getNome(), u.getIdade(), u.getEmail(), u.getDeficiencia(),u.getCep(),u.getUf(),u.getLocalidade());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void Atualizar_Usuario(Usuario u) {
        String query = String.format("update tb_usuario set nome = '%s', idade = %s, email = '%s', deficiencia = '%s', cep = '%s' where id = %d", u.getNome(), u.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirUsuario(int id) {
        String query = String.format("delete from tb_usuario where id = %d", id);
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExibirUsuarios() {
        String query= "select * from tb_usuario";
       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.print(rs.getString("id")+" - "+rs.getString("nome"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
    }
   
    public static void ExibirUsuario(int id) {
        String query = String.format("select * from tb_usuario where id = %d", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.print(rs.getString("id")+" - "+rs.getString("nome")+"\nIdade: "+rs.getString("idade")+"\nEmail: "+rs.getString("email")+"\nDeficiência: "+rs.getString("deficiencia"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
}