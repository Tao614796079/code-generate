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
public class ${table_name}To${table_name}Ro implements Function<${table_name}, ${table_name}Ro> {

    @Nullable
    @Override
    public ${table_name}Ro apply(@Nullable ${table_name} input) {
        if (input != null) {
            ${table_name}Ro ${table_name?uncap_first} = new ${table_name}Ro();
            CopyUtils.copyProperties(input, ${table_name?uncap_first});
            return ${table_name?uncap_first};
        } else {
            return null;
        }
    }
}
