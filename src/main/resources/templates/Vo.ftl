package ${package_name};


import lombok.Data;



/**
* 描述：${table_annotation}模型
* @author ${author}
* @date ${date}
*/
@Data
public class ${table_name}Vo{

    /**
    *java.lang.Long
    */
        private Long id;
<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment}
    */

    private ${model.columnType} ${model.changeColumnName?uncap_first};

    </#list>
</#if>

    }