package example.Controller.Repository;

import example.Controller.Model.Work;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WorkRepository extends CrudRepository<Work,Long> {

@Query(value = "SELECT a FROM Work a WHERE a.userId=?1 AND a.date=?2")
List<Work>  findByTime(int userId, String date);



}
