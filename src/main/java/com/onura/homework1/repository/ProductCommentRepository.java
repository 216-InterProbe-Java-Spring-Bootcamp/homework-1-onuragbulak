package com.onura.homework1.repository;

import com.onura.homework1.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long>
{
    List<ProductComment> findAllProductCommentByProductId(Long id);

    List<ProductComment> findAllProductCommentByProductIdAndCommentDateBetween(Long id, Date commentDateStart, Date commentDateEnd);

    List<ProductComment> findAllProductCommentByCustomerId(Long id);

    List<ProductComment> findAllProductCommentByCustomerIdAndCommentDateBetween(Long id, Date commentDateStart, Date commentDateEnd);

}
