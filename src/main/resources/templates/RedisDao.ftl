package ${package_name};

import com.biz.primus.base.redis.CrudRedisDao;

import ${package_name}.${table_name}Ro;


import org.springframework.stereotype.Repository;

/**
* 描述：${table_annotation}Dao
* @author ${author}
* @date ${date}
*/
@Repository
public class ${table_name}RedisDao  extends CrudRedisDao<${table_name}Ro, Long> {



}
