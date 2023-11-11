package com.server.dosopt.thirdseminar.repository;

import com.server.dosopt.thirdseminar.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}
