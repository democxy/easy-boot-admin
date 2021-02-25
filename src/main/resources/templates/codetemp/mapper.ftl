<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.modules.${moduleName}.dao.${ClassName}Dao">

    <sql id="${className}Columns">
    <#assign columnField>
    <#list columnList as c>
        a.${c.name} AS "${c.javaField}",
    </#list>
    </#assign>
        ${columnField?substring(0, columnField?last_index_of(","))}
    </sql>

    <sql id="${className}Joins">

    </sql>

    <select id="getById" resultType="${packageName}.modules.${moduleName}.entity.${ClassName}">
        SELECT
        <include refid="${className}Columns"/>
        FROM ${table.name} a
        <include refid="${className}Joins"/>
        WHERE a.id = ${"#"}{id}
    </select>

    <select id="findList" resultType="${packageName}.modules.${moduleName}.entity.${ClassName}">
        SELECT
        <include refid="${className}Columns"/>
        FROM ${table.name} a
        <include refid="${className}Joins"/>
        <where>
        <#list table.columnList as c>
            <#if (c.isQuery?string('1','0') == "1" )>
            <if test="${c.javaField} != null and ${c.javaField} != ''">
            <#if c.queryType ?? && c.queryType == 'between'>

            <#elseif c.queryType ?? && c.queryType == 'like'>
                AND a.${c.name} LIKE  concat('%',${"#"}{${c.javaField}},'%')
            <#elseif c.queryType ?? && c.queryType == 'left_like'>
                AND a.${c.name} LIKE concat('%',${"#"}{${c.javaField}},'%')
            <#elseif c.queryType ?? && c.queryType == 'right_like'>
                AND a.${c.name} LIKE concat('%',${"#"}{${c.javaField}},'%')
            <#else>
                AND a.${c.name} ${c.queryType} ${"#"}{${c.javaField}}
            </#if>
            </if>
            </#if>
        </#list>
        </where>
    </select>

    <insert id="insert">
        INSERT INTO ${table.name}(
        <#assign insertField>
            <#list table.columnList as c>
                <#if c.isInsert?string('1','0') == "1">
            ${c.name},
                </#if>
            </#list>
        </#assign>
        ${insertField?substring(0, insertField?last_index_of(","))}
        ) VALUES (
        <#assign insertJavaField>
            <#list table.columnList as c>
                <#if c.isInsert?string('1','0') == "1">
            ${"#"}{${c.javaField}},
                </#if>
            </#list>
        </#assign>
        ${insertJavaField?substring(0, insertJavaField?last_index_of(","))}
        )
    </insert>

    <update id="update">
        UPDATE ${table.name} SET
        <#assign updateField>
            <#list table.columnList as c>
                <#if c.isEdit?string('1','0') == "1">
            ${c.name} = ${"#"}{${c.javaField}},
                </#if>
            </#list>
        </#assign>
        ${updateField?substring(0, updateField?last_index_of(","))}
        WHERE id = ${"#"}{id}
    </update>

    <delete id="delete">
        delete from ${table.name} WHERE id = ${"#"}{id}
    </delete>

</mapper>