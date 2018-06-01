package ${package_name};

import com.biz.primus.ms.base.service.AbstractBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${po_path}.${table_name};


/**
* 描述：${table_annotation} service层
* @author ${author}
* @date ${date}
*/


@Slf4j
@Service
public class ${table_name}Service extends AbstractBaseService{

    @Autowired
    private  ${table_name}RedisDao ${table_name?uncap_first}RedisDao;

    @Autowired
    private  ${table_name}Repository ${table_name?uncap_first}Repository;


    @Transactional(rollbackFor = Exception.class)
    public void create(${table_name}Vo ${table_name?uncap_first}Vo) {


        ${table_name} ${table_name?uncap_first} = new ${table_name}VoTo${table_name}().apply(${table_name?uncap_first}Vo);

        if (${table_name?uncap_first}.getId() == null) {
                ${table_name?uncap_first}.setId(idService.getNextId());
        }
        ${table_name} savedPo = ${table_name?uncap_first}Repository.save(${table_name?uncap_first});

        delayer.executeAfterTransactionCommit(() ->
                {
                    final ${table_name}Ro ${table_name?uncap_first}Ro = new ${table_name}To${table_name}Ro().apply(savedPo);
                    ${table_name?uncap_first}RedisDao.save(${table_name?uncap_first}Ro);
                }
        );
    }
    public ${table_name}Vo findById(Long id) {
        ${table_name} ${table_name?uncap_first} = ${table_name?uncap_first}Repository.findOne(id);
        return new ${table_name}To${table_name}Vo().apply(${table_name?uncap_first});
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        ${table_name?uncap_first}Repository.delete(id);
        delayer.executeAfterTransactionCommit(() ->
                {
            ${table_name?uncap_first}RedisDao.delete(id);
                }
        );
    }


}
