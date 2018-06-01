package ${package_name};


import com.biz.primus.base.redis.annotation.Ro;
import com.biz.primus.base.redis.bean.BaseRedisObject;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Data
@EqualsAndHashCode(callSuper = true)
@Ro(key = "crm:${table_name?uncap_first}")
public class ${table_name}Ro extends BaseRedisObject<Long> {
<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment}
    */

    private ${model.columnType} ${model.changeColumnName?uncap_first};

    </#list>
</#if>

    }