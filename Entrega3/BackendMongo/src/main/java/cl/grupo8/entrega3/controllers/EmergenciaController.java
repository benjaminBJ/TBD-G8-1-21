package cl.grupo8.entrega3.controllers;


import cl.grupo8.entrega3.models.EmergenciaModel;
import cl.grupo8.entrega3.services.EmergenciaService;
import com.mongodb.client.AggregateIterable;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emergencia")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EmergenciaController {

        @Autowired
        EmergenciaService emergenciaService;

        @GetMapping
        @ResponseBody
        public List<EmergenciaModel> getAllEmergencias(){
            return emergenciaService.getAllEmergencias();
        }

        @PostMapping()
        @ResponseBody
        public EmergenciaModel saveEmergencia(@RequestBody EmergenciaModel emergencia){
            return  this.emergenciaService.saveEmergencia(emergencia);
        }

        @GetMapping(value = "/{id}")
        @ResponseBody
        public EmergenciaModel getEmergencia(@PathVariable String id){
            EmergenciaModel result = this.emergenciaService.getEmergencia(id);
            return result;
        }

        @DeleteMapping(value = "/delete/{id}")
        @ResponseBody
        public void deleteEmergencia(@PathVariable String id){
            this.emergenciaService.deleteEmergencia(id);
        }

        //Ruta de consulta custom
        @GetMapping(value = "/tareas")
        @ResponseBody
        public ArrayList<Document> getEmergencia(){

            ArrayList<Document> result = this.emergenciaService.tareasXEmergencia();
            return result;
        }


}
