package com.cgnexus.example_19.repository;

import com.cgnexus.example_19.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {


}
