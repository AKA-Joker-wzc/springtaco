package com.example.springtaco.web;

import com.example.springtaco.data.IngreditentInterface;
import com.example.springtaco.data.TacoSave;
import com.example.springtaco.entity.Ingredient;
import com.example.springtaco.entity.Ingredient.Type;
import com.example.springtaco.entity.Order;
import com.example.springtaco.entity.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    private final IngreditentInterface  ingreditentInterface;
    private TacoSave tacoSave;
    @Autowired
    public DesignTacoController(IngreditentInterface ingreditentInterface, TacoSave tacoSave){

        this.ingreditentInterface = ingreditentInterface;
        this.tacoSave = tacoSave;
    }
    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingreditentInterface.findAll().forEach(i->ingredients.add(i));
        Type[] types = Ingredient.Type.values();
        for (Type type :types){
            model.addAttribute(type.toString().toLowerCase(),filterByType(ingredients,type));
        }
        model.addAttribute("design",new Taco());
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type){
        return  ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
    @ModelAttribute(name="order")
    public Order order(){
        return  new Order();
    }
    @ModelAttribute(name="taco")
    public Taco taco(){
        return  new Taco();
    }

    @PostMapping
    public String processDesign(@Valid Taco design , Errors errors,@ModelAttribute Order order){
        if(errors.hasErrors()){
            return "design";
        }
        Taco saved = tacoSave.save(design);

        log.info("Processing design:"+design);
        return "redirect:/orders/current";
    }
}
