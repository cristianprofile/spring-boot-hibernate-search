package com.cromero;

import com.cromero.model.Card;
import com.cromero.repository.CardRepository;
import com.cromero.service.HibernateSearchService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//firs call addCards method
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchaRooApplicationTestsIt {


	@Autowired
	private HibernateSearchService hibernateSearchServiceImpl;



	@Autowired
	private CardRepository cardRepository;


//
//	After this initial build, Hibernate Search will take care of keeping the index up to date.
//   I. e. we can create, manipulate and delete entities via the EntityManager as usual.
//	Note: we have to make sure that entities are fully committed to the database before they can be discovered and indexed
// by Lucene (by the way, this also the reason why the initial test data import in our example code test cases comes in a dedicated
// JUnit test case, annotated with @Commit).

	@Commit
	@Test
	public void addCards() {
		Card card=new Card();
		card.setHolderName("Ted Williams");
		card.setHolderSurname("Romero");
		card.setExpiration("12/08/2017");

		cardRepository.save(card);

		card=new Card();
		card.setHolderName("Bob Gibson");
		card.setHolderSurname("Alonso");
		card.setExpiration("12/08/2019");

		cardRepository.save(card);

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

		cardRepository.save(card);

		card=new Card();
		card.setHolderName("Black");
		card.setHolderSurname("Rodriguez");
		card.setExpiration("12/08/2019");

		cardRepository.save(card);

		List<Card> cardList = cardRepository.findAll();
		assert(cardList.size()==4);
	}


	
	@Test
	public void searchMultipleTermWithTypos() {



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
