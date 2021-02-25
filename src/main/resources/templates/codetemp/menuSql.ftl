-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}', '', '1', '${moduleName}/${className}', 'M', '0', '', 'fa fa-gears', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '${table.comments}菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}查询', @parentId, '1',  '#',  'B', '0', '${moduleName}:${className}:view',         '#', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '');

insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}新增', @parentId, '2',  '#',  'B', '0', '${moduleName}:${className}:add',          '#', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '');

insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}修改', @parentId, '3',  '#',  'B', '0', '${moduleName}:${className}:edit',         '#', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '');

insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}保存', @parentId, '4',  '#',  'B', '0', '${moduleName}:${className}:save',       '#', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '');

insert into sys_menu (menu_name, parent_id, order_num, href, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('${table.comments}删除', @parentId, '5',  '#',  'B', '0', '${moduleName}:${className}:del',       '#', 'democxy', '2020-12-01', 'democxy', '2020-12-01', '');
