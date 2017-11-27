package com.niit.cmsdemo.dao;

import com.niit.cmsdemo.domain.FollowUp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FollowUpDao {

    Integer insertOne(FollowUp followUp);

    Integer deleteOne(Long id);

    Integer updateOne(FollowUp followUp);

    FollowUp selectOne(Long id);

    List<FollowUp> selectByStuId(Long stuId);

    List<FollowUp> selectRecent(@Param("stuId") Long stuId, @Param("classification") Character classification,
                                @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<FollowUp> selectConditions(Map<String,Object> map);
}
