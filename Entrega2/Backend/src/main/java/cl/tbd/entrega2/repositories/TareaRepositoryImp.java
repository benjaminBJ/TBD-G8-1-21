package cl.tbd.entrega2.repositories;

import cl.tbd.entrega2.models.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea() {
        int total = 0;
        try(Connection conn = sql2o.open()){
            String sql = "SELECT COUNT(*) " + 
                         "FROM tarea";             
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Tarea> getAllTarea() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT * " + 
                         "FROM tarea";             
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea getTarea(int id) {
        try(Connection conn = sql2o.open()){

            String sql = "select * from tarea WHERE id = :id";

            Tarea tarea = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
            return tarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        try(Connection conn = sql2o.open()){
            String sql = 
                    "INSERT INTO tarea (nombre, descrip, vol_requeridos, finicio, ffin, id_emergencia, id_estado)" + 
                        "values (:nombre, :descrip, :vol_requeridos, :finicio, :ffin, :id_emergencia, :id_estado)";           
            int insertedId = (int) conn.createQuery(sql, true)
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("descrip", tarea.getDescrip())
                    .addParameter("vol_requeridos", tarea.getVol_requeridos())
                    .addParameter("finicio", tarea.getFinicio())
                    .addParameter("ffin", tarea.getFfin())
                    .addParameter("id_emergencia", tarea.getId_emergencia())
                    .addParameter("id_estado", tarea.getId_estado())
                    .executeUpdate().getKey();
            tarea.setId(insertedId);
            return tarea;        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea upTarea(Tarea Tarea) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE tarea SET nombre = :nombre, descrip = :descrip, vol_requeridos = :vol_requeridos, " +
                        "finicio = :finicio, ffin = :ffin, id_emergencia = :id_emergencia, id_estado = :id_estado WHERE id = :id";

            conn.createQuery(sql, true)
                    .addParameter("id", Tarea.getId())
                    .addParameter("nombre", Tarea.getNombre())
                    .addParameter("descrip", Tarea.getDescrip())
                    .addParameter("vol_requeridos", Tarea.getVol_requeridos())
                    .addParameter("finicio", Tarea.getFinicio())
                    .addParameter("ffin", Tarea.getFfin())
                    .addParameter("id_emergencia", Tarea.getId_emergencia())
                    .addParameter("id_estado", Tarea.getId_estado())                   
                    .executeUpdate();

            return Tarea;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteTarea(int id) {

        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM tarea WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void procedure1(int idt, int idv) {

        try(Connection conn = sql2o.open()){
            
            String sql2 = "CALL public.cerrar_tarea("+idt+","+idv+" )";
            conn.createQuery(sql2, true)
                    .executeUpdate();

           // System.out.println("Ejecuta procedimiento");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
