package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.dao.impl.ResellerDAO;
import org.example.dto.PlantDTO;
import org.example.dto.ResellerDTO;
import org.example.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

public class Populate
{
    //private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    public static void main(String[] args)
    {
    }

    public static ArrayList<PlantDTO> populatePlants()
    {
        PlantDTO Albertine = new PlantDTO("Rose", "Albertine", 400, 199.50);
        PlantDTO Aronia = new PlantDTO("Bush", "Aronia", 200, 169.50);
        PlantDTO AromaApple = new PlantDTO("FruitAndBerries", "AromaApple", 350, 399.50);
        PlantDTO Astrid = new PlantDTO("Rhododendron", "Astrid", 40, 269.50);
        PlantDTO TheDarkLady = new PlantDTO("Rose", "The DarkLady", 100, 199.50);


        ArrayList<PlantDTO> plantDTOList = new ArrayList<>();
        plantDTOList.add(Albertine);
        plantDTOList.add(Aronia);
        plantDTOList.add(AromaApple);
        plantDTOList.add(Astrid);
        plantDTOList.add(TheDarkLady);
        return plantDTOList;
    }

    public static List<ResellerDTO> populateResellers()
    {
        ResellerDTO LyngbyPlantecenter = new ResellerDTO("Lyngby Plantecenter", "Firskovvej 18", 33212334);
        ResellerDTO GlostrupPlanter = new ResellerDTO("Glostrup Planter", "Tværvej 35", 32233232);
        ResellerDTO HolbækPlanteskole = new ResellerDTO("Holbæk Planteskole", "Stenhusvej 49", 59430945);

        int counter = 1;
        List<ResellerDTO> resellerDTOList = List.of(LyngbyPlantecenter, GlostrupPlanter, HolbækPlanteskole);
        for(ResellerDTO r : resellerDTOList)
        {
            r.setId(counter++);
        }
        return resellerDTOList;
    }
}