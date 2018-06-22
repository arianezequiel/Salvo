package com.accenture.salvo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import javax.persistence.Entity;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player, Long>
{
    List<Player> findByUserName(String Player);
}
