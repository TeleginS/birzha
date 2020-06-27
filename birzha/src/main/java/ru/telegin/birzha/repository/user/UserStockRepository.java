package ru.telegin.birzha.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.telegin.birzha.model.Stock;
import ru.telegin.birzha.model.market.MarketActionName;
import ru.telegin.birzha.model.user.User;
import ru.telegin.birzha.model.user.UserStock;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserStockRepository extends JpaRepository<UserStock, Long> {
    Optional<UserStock> findById(Long id);

    List<UserStock> findByUser(User user);

    List<UserStock> findByStock(Stock stock);

    List<UserStock> findByAction(MarketActionName action);
}
