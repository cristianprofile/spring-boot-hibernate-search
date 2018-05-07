package com.cromero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cromero.repository.CardRepository;
import com.cromero.model.Card;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardrepository;


    public void addCards() {
        Card card=new Card();
        card.setHolderName("Ted Williams");
        card.setHolderSurname("Romero");
        card.setExpiration("12/08/2017");

        cardrepository.save(card);

        card=new Card();
        card.setHolderName("Bob Gibson");
        card.setHolderSurname("Alonso");
        card.setExpiration("12/08/2019");

        cardrepository.save(card);

        card=new Card();

        card=new Card();
        card.setHolderName("Carlos Mathaus");
        card.setHolderSurname("Mathaus");
        card.setExpiration("12/08/2019");

        card=new Card();

        card=new Card();
        card.setHolderName("Carlos Angular");
        card.setHolderSurname("black");
        card.setExpiration("12/08/2019");

        cardrepository.save(card);

        card=new Card();
        card.setHolderName("Black");
        card.setHolderSurname("Rodriguez");
        card.setExpiration("12/08/2019");

        cardrepository.save(card);

    }
}
