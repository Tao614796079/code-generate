package ${package_name};

import com.biz.primus.common.utils.CopyUtils;
import ${po_path}.${table_name};
import ${package_name}.${table_name}Ro;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/**
* 描述：${table_annotation}控制层
* @author ${author}
* @date ${date}
*/
public class ${table_name}VoTo${table_name} implements Function<${table_name}Vo, ${table_name}> {

    @Nullable
    @Override
    public ${table_name} apply(@Nullable ${table_name}Vo input) {
        if (input != null) {
            ${table_name} ${table_name?uncap_first} = new ${table_name}();
            CopyUtils.copyProperties(input, ${table_name?uncap_first});
            return ${table_name?uncap_first};
        } else {
            return null;
        }
    }
}
