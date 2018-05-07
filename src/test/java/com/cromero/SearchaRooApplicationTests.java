package com.cromero;

import com.cromero.model.Card;
import com.cromero.service.CardService;
import com.cromero.service.HibernateSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchaRooApplicationTests {


	@Autowired
	private CardService cardService;

	@Autowired
	private HibernateSearchService hibernateSearchServiceImpl;

	
	@Test
	public void searcMultipleTermWithTypos() {

		cardService.addCards();
		List<Card> cardList = hibernateSearchServiceImpl.magicSearch("Bob Gibson");
		assert(cardList.size()==1);
		assert(cardList.get(0).getHolderName().equals("Bob Gibson"));

		cardList = hibernateSearchServiceImpl.magicSearch("Bob Giibsssson");
		assert(cardList.size()==1);
		assert(cardList.get(0).getHolderName().equals("Bob Gibson"));


		cardList = hibernateSearchServiceImpl.magicSearch("Romero");
		assert(cardList.size()==1);
		assert(cardList.get(0).getHolderSurname().equals("Romero"));


		cardList = hibernateSearchServiceImpl.magicSearch("Romerro");
		assert(cardList.size()==1);
		assert(cardList.get(0).getHolderSurname().equals("Romero"));


		cardList = hibernateSearchServiceImpl.magicSearch("black");
		assert(cardList.size()==2);

	}

}
