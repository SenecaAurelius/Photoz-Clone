package com.companyname.earl.photozclone.repository;

import com.companyname.earl.photozclone.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotozRepository extends CrudRepository<Photo, Integer> {

}
