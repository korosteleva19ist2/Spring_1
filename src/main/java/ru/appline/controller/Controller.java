package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petmodel=PetModel.getInstance();
    private static final AtomicInteger newID= new AtomicInteger(1);

    @PostMapping(value = "/createPet",consumes = "application/json",produces = "text/html")
    public String createPet(@RequestBody Pet pet) //чтобы Pet pet воспринимали как json надо прописать аннотацию @RequestBody
    {
        petmodel.add(pet, newID.getAndIncrement());
        String pt="Вы создали нового питомца";
        return pt;

    }

    @GetMapping(value = "/getAll",produces = "application/json")
    public Map<Integer,Pet> getAll()
    {
        return petmodel.getAll();
    }

    //если писать id  в body
    /*@GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id)
    {
        return petmodel.petGetFromList(id.get("id"));

    }*/

    //если писать id в строке
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestParam("id") int id)
    {
        return petmodel.petGetFromList(id);

    }

    //если писать id  в body
    /*@DeleteMapping(value = "/delPet",consumes = "application/json")
    public void delPet(@RequestBody Map<String,Integer> id)
    {
        int newid=id.get("id");
         petmodel.delete(newid);

    }*/
    //если писать id в строке
    @DeleteMapping(value = "/delPet",consumes = "application/json")
    public void delPet(@RequestParam("id") int id)
    {
        petmodel.delete(id);
    }

    @PutMapping(value = "/updPet/{id}",consumes = "application/json")
    public void updPet(@RequestBody Pet pet, @PathVariable("id") int id)
    {
        petmodel.add(pet, id);
    }

}
