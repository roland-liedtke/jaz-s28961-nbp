package me.rolandliedtke.jaz_s28961_nbp.repository;

import me.rolandliedtke.jaz_s28961_nbp.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

}
