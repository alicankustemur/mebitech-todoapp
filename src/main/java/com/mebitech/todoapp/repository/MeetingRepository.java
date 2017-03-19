package com.mebitech.todoapp.repository;

import org.springframework.stereotype.Repository;

import com.mebitech.todoapp.domain.Meeting;
import com.mebitech.todoapp.repository.base.BaseRepository;

@Repository
public interface MeetingRepository extends BaseRepository<Meeting, Long>{

}
