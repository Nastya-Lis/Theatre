package com.lad.springserver.model.repository;

import com.lad.springserver.model.entity.CommonEntity;
import org.dom4j.tree.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;

@NoRepositoryBean
public interface IRepository<E extends CommonEntity> extends JpaRepository<E, Integer> {

}
