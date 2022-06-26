package com.onura.homework1.repository;

import com.onura.homework1.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>
{
    List<ProductComment> findAllByProductId(Long id);

    List<ProductComment> findAllByProductIdAndCommentDateBetween(Long id, Date commentDateStart, Date commentDateEnd);

    List<ProductComment> findAllByCustomerId(Long id);

    List<ProductComment> findAllByCustomerIdAndCommentDateBetween(Long id, Date commentDateStart, Date commentDateEnd);

}
