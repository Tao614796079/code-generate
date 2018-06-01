package ${package_name};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* 描述：${table_annotation}控制层
* @author ${author}
* @date ${date}
*/
@RestController
public class ${table_name}Controller {

    @Autowired
    private ${table_name}Service ${table_name?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    * @param id  ${table_annotation}id
    */
   @PostMapping("findById")
    public ${table_name}Vo findById(@RequestParam("id") Long id){
        return ${table_name?uncap_first}Service.findById(id);

    }

    /**
    * 描述:创建${table_annotation}
    * @param ${table_name?uncap_first}Vo  ${table_annotation}Vo
    */
    @PostMapping("create")
    public void create(@RequestBody ${table_name}Vo ${table_name?uncap_first}Vo){
         ${table_name?uncap_first}Service.create(${table_name?uncap_first}Vo);
    }

    /**
    * 描述：删除${table_annotation}
    * @param id
    */
    @PostMapping("deleteById")
    public void deleteById(@RequestParam("id") Long id){
    ${table_name?uncap_first}Service.deleteById(id);
    }


}