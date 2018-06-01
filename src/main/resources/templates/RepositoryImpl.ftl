package ${package_name};

import com.biz.primus.ms.base.jpa.repository.CommonJpaRepositoryBean;

import ${po_path}.${table_name};
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;

/**
* 描述：${table_annotation} Repository接口
* @author ${author}
* @date ${date}
*/

public class ${table_name}RepositoryImpl extends CommonJpaRepositoryBean<${table_name}, Long> implements ${table_name}Dao {

    public ${table_name}RepositoryImpl(@Autowired EntityManager em) {
        super(${table_name}.class, em);
    }

}
