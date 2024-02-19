package com.eazybank.service;


import com.eazybank.entity.Cards;
import com.eazybank.entity.Notice;
import com.eazybank.repository.CardsRepository;
import com.eazybank.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticesService {

    private final NoticeRepository repository;

    public List<Notice> getNotices() {
        return repository.findAllActiveNotices();
    }

}
