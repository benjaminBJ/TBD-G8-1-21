package cl.tbd.entrega3.repositories;

import cl.tbd.entrega3.models.Voluntario;
import cl.tbd.entrega3.models.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.ArrayList;
import java.util.List;


@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    
    @Autowired
    private Sql2o sql2o;

    private final Voluntario_HabilidadRepository voluntario_habilidadRepository;
    public VoluntarioRepositoryImp(Voluntario_HabilidadRepository voluntario_habilidadRepository) {
        this.voluntario_habilidadRepository = voluntario_habilidadRepository;
    }


    //Funcion de hash que distribuira
    //por columna rut
    private Integer hashFunction(Integer rut){
        return rut % 3;
    }

    @Override
    public int countVoluntarios() {
        int total0 = 0;
        int total1 = 0;
        int total2 = 0;
        int total = 0;
        try(Connection conn = sql2o.open()){
            total0 = conn.createQuery("SELECT COUNT(*) FROM voluntario0").executeScalar(Integer.class);
            total1 = conn.createQuery("SELECT COUNT(*) FROM voluntario1").executeScalar(Integer.class);
            total2 = conn.createQuery("SELECT COUNT(*) FROM voluntario2").executeScalar(Integer.class);
        }
        total = total0 + total1 + total2;
        return total;
    }

    @Override
    public List<Voluntario> getAllVoluntarios() {
        try(Connection conn = sql2o.open()){
            String sql = "SELECT id, nombre, rut, email, telefono, tabla" + " FROM voluntario";
            return conn.createQuery(sql)
                    .executeAndFetch(Voluntario.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntario(int id) {

        try(Connection conn = sql2o.open()){

            String sql = "SELECT id, nombre, rut, email, telefono, tabla" + " FROM voluntario WHERE id = :id";

            Voluntario voluntario = conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntarioNombre(String nombre) {

        try(Connection conn = sql2o.open()){

            String sql = "SELECT VO.id, VO.nombre, VO.tabla FROM (SELECT * FROM voluntario0 UNION SELECT * FROM voluntario1 UNION SELECT * FROM voluntario2) VO WHERE VO.nombre = :nombre";

            Voluntario voluntario = conn.createQuery(sql, true)
                    .addParameter("nombre", nombre)
                    .executeAndFetchFirst(Voluntario.class);
            return voluntario;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {

        try(Connection conn = sql2o.open()){

                String rut = voluntario.getRut().split("-")[0];
                Integer index = hashFunction( Integer.parseInt(rut));
                String tabla = "voluntario"+index;

                String sql =
                    "INSERT INTO "+ tabla +" (nombre, rut, email, telefono,tabla)" +
                            "values (:nombre, :rut, :email, :telefono, :tabla)";

                int insertedId = (int) conn.createQuery(sql, true)
                        .addParameter("nombre", voluntario.getNombre())
                        .addParameter("rut", voluntario.getRut())
                        .addParameter("email", voluntario.getEmail())
                        .addParameter("telefono", voluntario.getTelefono())
                        .addParameter("tabla",tabla)
                        .executeUpdate().getKey();
                voluntario.setId(insertedId);
                voluntario.setTabla(tabla);

            // Crear modelo intermedio
            voluntario_habilidadRepository.createVoluntario_Habilidad(insertedId, tabla);

            return voluntario;



        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario upVoluntario(Voluntario voluntario) {
        try(Connection conn = sql2o.open()){

            String sql =
                    "UPDATE voluntario SET nombre = :nombre, rut = :rut , email = :email , " +
                            "telefono = :telefono, tabla = :tabla";

            conn.createQuery(sql, true)
                    .addParameter("id", voluntario.getId())
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("telefono", voluntario.getTelefono())
                    .addParameter("id", voluntario.getId())
                    .executeUpdate();

            return voluntario;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteVoluntario(int id) {
        try(Connection conn = sql2o.open()){
            String sql = "DELETE FROM voluntario WHERE id = :id";
            conn.createQuery(sql, true)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public String habilidadesVoluntario(String nombre){
        

        try(Connection conn = sql2o.open()){
            Voluntario voluntario = getVoluntarioNombre(nombre);

            String sql = "SELECT HA.descrip as descrip, VA.tabla as tabla_habilidad FROM (SELECT * FROM vol_habilidad0 UNION SELECT * FROM vol_habilidad1 UNION SELECT * FROM vol_habilidad2) VA INNER JOIN habilidad AS HA ON VA.id_voluntario = :id_voluntario AND VA.tabla_voluntario = :tabla_voluntario AND VA.id_habilidad = HA.id";
        
            List<Respuesta> respuestas = (List<Respuesta>) conn.createQuery(sql)
                    .addParameter("id_voluntario", voluntario.getId())
                    .addParameter("tabla_voluntario", voluntario.getTabla())
                    .executeAndFetch(Respuesta.class);

            String lista = "Habilidades: \n";
            for(int i = 0; i < respuestas.size(); i++){
                lista = lista + respuestas.get(i).getDescrip() + "      Tabla voluntario_habilidad: " + respuestas.get(i).getName() + "\n";
            }

            String resultado ="Nombre: " + voluntario.getNombre() + "\nTabla Voluntario: " + voluntario.getTabla() + "\n" + lista;
            return resultado;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String getJson() {
        // TODO Auto-generated method stub
        final String query = "SELECT json_build_object("+
                "'type', 'FeatureCollection',"+
                "'features', json_agg(ST_AsGeoJSON(t.geom)::json)"+
                ")"+
                "FROM division_regional_4326 AS t WHERE t.gid = 5;";
        return null;
    }


}
