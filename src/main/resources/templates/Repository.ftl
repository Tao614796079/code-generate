package ${package_name};

import com.biz.primus.ms.base.jpa.repository.CommonJpaRepository;
import ${po_path}.${table_name};
/**
* 描述：${table_annotation} Repository接口
* @author ${author}
* @date ${date}
*/
public interface ${table_name}Repository extends CommonJpaRepository<${table_name}, Long> , ${table_name}Dao{



}