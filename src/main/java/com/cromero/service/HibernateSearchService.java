package com.cromero.service;

import com.cromero.model.Card;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HibernateSearchService {
    @Transactional
    List<Card> magicSearch(String searchTerm);
}
