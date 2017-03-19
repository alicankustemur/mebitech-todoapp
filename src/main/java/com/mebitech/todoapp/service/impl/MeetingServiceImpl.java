package com.mebitech.todoapp.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mebitech.todoapp.domain.Meeting;
import com.mebitech.todoapp.repository.MeetingRepository;
import com.mebitech.todoapp.service.MeetingService;
import com.mebitech.todoapp.service.base.AbstractBaseServiceImpl;

@Transactional
@Service
public class MeetingServiceImpl extends AbstractBaseServiceImpl<Meeting, Long> implements MeetingService {
	
	public MeetingServiceImpl(MeetingRepository repository) {
		super(repository);
	}

}
