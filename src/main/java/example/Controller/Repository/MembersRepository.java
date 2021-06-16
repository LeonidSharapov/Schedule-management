package example.Controller.Repository;

import example.Controller.Model.Members;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MembersRepository extends CrudRepository<Members,Long> {
    @Query(value = "SELECT a FROM Members a WHERE a.userId=?1")
    List<Members>  findByAll(int userId);
}
