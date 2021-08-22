package cl.tbd.entrega3.repositories;

import cl.tbd.entrega3.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
            voluntario_habilidadRepository.createVoluntario_Habilidad2(insertedId);

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
